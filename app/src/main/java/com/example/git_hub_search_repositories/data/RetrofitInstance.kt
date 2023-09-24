package com.example.git_hub_search_repositories.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitInstance {

    private const val baseUrl = "https://api.github.com/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: GitHubApi by lazy {
        retrofit.create(GitHubApi::class.java)
    }
}
