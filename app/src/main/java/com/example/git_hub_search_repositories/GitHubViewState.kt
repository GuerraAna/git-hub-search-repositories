package com.example.git_hub_search_repositories

import com.example.git_hub_search_repositories.domain.Repositories

/**
 *
 */
internal sealed class GitHubViewState {
   /** */
    data object Loading: GitHubViewState()

    /** */
    data object Error: GitHubViewState()

    /** */
    data object Empty: GitHubViewState()

    /** */
    data class Loaded(val repositories: List<Repositories>): GitHubViewState()
}
