package com.example.git_hub_search_repositories.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.git_hub_search_repositories.GitHubViewModel
import com.example.git_hub_search_repositories.GitHubViewState
import com.example.git_hub_search_repositories.databinding.ActivityGithubSearchBinding
import com.example.git_hub_search_repositories.ui.user.UserAdapter

internal class GitHubSearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGithubSearchBinding
    private val viewModel: GitHubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupViewModel()
    }

    private fun setupBinding() {
        binding = ActivityGithubSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupViewModel() {
        val userName = binding.usernameInput.text.toString()

        viewModel.initialize(userName)
        viewModel.viewState.observe(this) { state: GitHubViewState ->
            when (state) {
                GitHubViewState.Loading -> Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                GitHubViewState.Empty -> Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show()
                GitHubViewState.Error -> Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()

                is GitHubViewState.Loaded -> setupLoadedLayout(state)
            }
        }
    }

    private fun setupLoadedLayout(response: GitHubViewState.Loaded) {
        binding.usersList.apply {
            layoutManager = LinearLayoutManager(this@GitHubSearchActivity)
            adapter = UserAdapter(this@GitHubSearchActivity, response.repositories)
        }
    }
}