package com.example.git_hub_search_repositories.data

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
    fun getGitHubRepositories(
        @Path("user") user: String
    ): RepositoriesResponse
}