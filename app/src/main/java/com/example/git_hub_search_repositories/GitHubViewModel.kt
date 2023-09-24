package com.example.git_hub_search_repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 *
 */
internal class GitHubViewModel(
    private val useCase: GitHubUseCase = GitHubUseCase()
) : ViewModel() {

    private val mutableViewState = MutableLiveData<GitHubViewState>()

    /** */
    val viewState: LiveData<GitHubViewState> = mutableViewState

    /**
     *
     */
    fun initialize(userName: String) {
        viewModelScope.launch {
            getGitHubRepositories(userName)
        }
    }

    suspend fun getGitHubRepositories(userName: String) {
        mutableViewState.postValue(GitHubViewState.Loading)

        try {
            val repositories = useCase.getRepositories(userName)

             when (repositories.isEmpty()) {
                 false -> mutableViewState.postValue(GitHubViewState.Loaded(repositories))
                 true -> mutableViewState.postValue(GitHubViewState.Empty)
             }

        } catch (error: Throwable) {
            mutableViewState.postValue(GitHubViewState.Error)
        }
    }
}