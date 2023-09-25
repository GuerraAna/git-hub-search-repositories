package com.example.git_hub_search_repositories.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.git_hub_search_repositories.GitHubViewModel
import com.example.git_hub_search_repositories.GitHubViewState
import com.example.git_hub_search_repositories.databinding.ActivityGithubSearchBinding
import com.example.git_hub_search_repositories.domain.Repositories
import com.example.git_hub_search_repositories.ui.user.UserAdapter

internal class GitHubSearchActivity : AppCompatActivity() {

	private lateinit var binding: ActivityGithubSearchBinding
	private val viewModel: GitHubViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setupBinding()
		setupListeners()
	}

	private fun setupBinding() {
		binding = ActivityGithubSearchBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}

	private fun setupListeners() {
		val sharedPreferences = getSharedPreferences("search", Context.MODE_PRIVATE)

		binding.confirmUsername.setOnClickListener {
			saveUserName(sharedPreferences)
			showUserNameRepositories()
		}

		binding.loadUserName.setOnClickListener {
			getLastUserNameSearched(sharedPreferences)
		}
	}

	private fun saveUserName(sharedPreferences: SharedPreferences) {
		val name = binding.usernameInput.text.toString()
		sharedPreferences.edit().apply {
			putString("userName", name)
			apply()
		}
	}

	private fun showUserNameRepositories() {
		val userName = binding.usernameInput.text.toString()

		when (userName.isEmpty()) {
			true -> Toast.makeText(
					this,
					"Por favor, insira um nome para a pesquisa",
					Toast.LENGTH_LONG
			).show()

			false -> setupViewModel(userName)
		}
	}

	private fun getLastUserNameSearched(sharedPreferences: SharedPreferences) {
		val userName = sharedPreferences.getString("userName", null)
		binding.usernameInput.setText(userName)
	}

	private fun setupViewModel(userName: String) {
		viewModel.initialize(userName)
		viewModel.viewState.observe(this) { state: GitHubViewState ->
			when (state) {
				GitHubViewState.Loading -> {
					binding.usersList.isVisible = false
					Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
				}

				GitHubViewState.Empty -> {
					binding.usersList.isVisible = false
					Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show()
				}

				GitHubViewState.Error -> {
					binding.usersList.isVisible = false
					Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
				}

				is GitHubViewState.Loaded -> {
					Toast.makeText(this, "Loaded", Toast.LENGTH_LONG).show()
					setupLoadedLayout(state.repositories)
				}
			}
		}
	}

	private fun setupLoadedLayout(response: List<Repositories>) {
		binding.usersList.apply {
			isVisible = true
			layoutManager = LinearLayoutManager(this@GitHubSearchActivity)
			adapter = UserAdapter(this@GitHubSearchActivity, response)
		}
	}
}