package com.example.git_hub_search_repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.git_hub_search_repositories.domain.Repositories
import kotlinx.coroutines.Dispatchers
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
        getGitHubRepositories(userName)
    }

    private fun getGitHubRepositories(userName: String) {
        mutableViewState.postValue(GitHubViewState.Loading)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                onGetRepositoriesDataSuccess(useCase.getRepositories(userName))
            } catch (error: Throwable) {
                mutableViewState.postValue(GitHubViewState.Error)
            }
        }
    }

    private fun onGetRepositoriesDataSuccess(repositories: List<Repositories>) {
        when (repositories.isEmpty()) {
            false -> mutableViewState.postValue(GitHubViewState.Loaded(repositories))
            true -> mutableViewState.postValue(GitHubViewState.Empty)
        }
    }
}