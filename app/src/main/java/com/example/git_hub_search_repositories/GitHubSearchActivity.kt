package com.example.git_hub_search_repositories

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.git_hub_search_repositories.databinding.ActivityGithubSearchBinding
import com.example.git_hub_search_repositories.user.UserAdapter

data class RepositoryOwner(
    val login: String,
    val avatarUrl: String
)

data class Repositories(
    val id: Long,
    val nodeId: String,
    val name: String,
    val fullName: String,
    val private: Boolean,
    val owner: RepositoryOwner,
    val htmlUrl: String,
    val description: String? = null,
    val fork: Boolean,
    val url: String
)

internal class GitHubSearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGithubSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()

        val mockOfRepositories = listOf(
            Repositories(
                id = 647032678,
                nodeId = "R_kgDOJpDvZg",
                name = "abstergo-industries-aws",
                fullName = "GuerraAna/abstergo-industries-aws",
                private = false,
                owner = RepositoryOwner(
                    login = "GuerraAna",
                    avatarUrl = "https://avatars.githubusercontent.com/u/78937585?v=4"
                ),
                htmlUrl = "https://github.com/GuerraAna/abstergo-industries-aws",
                description = "Abstergo Industries AWS",
                fork = false,
                url = "https://api.github.com/repos/GuerraAna/abstergo-industries-aws"
            ),
            Repositories(
                id = 647032678,
                nodeId = "R_kgDOJpDvZg",
                name = "abstergo-industries-aws",
                fullName = "GuerraAna/abstergo-industries-aws",
                private = false,
                owner = RepositoryOwner(
                    login = "GuerraAna",
                    avatarUrl = "https://avatars.githubusercontent.com/u/78937585?v=4"
                ),
                htmlUrl = "https://github.com/GuerraAna/abstergo-industries-aws",
                description = "Abstergo Industries AWS",
                fork = false,
                url = "https://api.github.com/repos/GuerraAna/abstergo-industries-aws"
            ),
            Repositories(
                id = 647032678,
                nodeId = "R_kgDOJpDvZg",
                name = "abstergo-industries-aws",
                fullName = "GuerraAna/abstergo-industries-aws",
                private = false,
                owner = RepositoryOwner(
                    login = "GuerraAna",
                    avatarUrl = "https://avatars.githubusercontent.com/u/78937585?v=4"
                ),
                htmlUrl = "https://github.com/GuerraAna/abstergo-industries-aws",
                description = "Abstergo Industries AWS",
                fork = false,
                url = "https://api.github.com/repos/GuerraAna/abstergo-industries-aws"
            ),
            Repositories(
                id = 647032678,
                nodeId = "R_kgDOJpDvZg",
                name = "abstergo-industries-aws",
                fullName = "GuerraAna/abstergo-industries-aws",
                private = false,
                owner = RepositoryOwner(
                    login = "GuerraAna",
                    avatarUrl = "https://avatars.githubusercontent.com/u/78937585?v=4"
                ),
                htmlUrl = "https://github.com/GuerraAna/abstergo-industries-aws",
                description = "Abstergo Industries AWS",
                fork = false,
                url = "https://api.github.com/repos/GuerraAna/abstergo-industries-aws"
            )
        )

        setupAdapter(mockOfRepositories)
    }

    private fun setupBinding() {
        binding = ActivityGithubSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupAdapter(list: List<Repositories>) {
        binding.usersList.apply {
            layoutManager = LinearLayoutManager(this@GitHubSearchActivity)
            adapter = UserAdapter(this@GitHubSearchActivity, list)
        }
    }
}