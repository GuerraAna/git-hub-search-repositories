package com.example.git_hub_search_repositories.data

import com.example.git_hub_search_repositories.domain.Repositories
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 */
internal interface GitHubApi {

    /**
     *
     */
    @GET("users/{user}/repos")
    suspend fun getGitHubRepositories(
        @Path("user") user: String
    ): List<Repositories>
}