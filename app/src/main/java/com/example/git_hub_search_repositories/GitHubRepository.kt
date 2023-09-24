package com.example.git_hub_search_repositories

import com.example.git_hub_search_repositories.data.RetrofitInstance
import com.example.git_hub_search_repositories.domain.Repositories

/**
 *
 */
internal class GitHubRepository {

    suspend fun getRepositories(userName: String): List<Repositories> =
        RetrofitInstance.api.getGitHubRepositories(userName)
}
