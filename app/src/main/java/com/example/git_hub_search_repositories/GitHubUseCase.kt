package com.example.git_hub_search_repositories

import com.example.git_hub_search_repositories.domain.Repositories

/**
 *
 */
internal class GitHubUseCase(
    private val repository: GitHubRepository = GitHubRepository()
) {

    /** */
    suspend fun getRepositories(userName: String): List<Repositories> =
        repository.getRepositories(userName)
}