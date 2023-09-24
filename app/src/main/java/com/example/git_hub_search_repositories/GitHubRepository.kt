package com.example.git_hub_search_repositories

import com.example.git_hub_search_repositories.data.RetrofitInstance
import com.example.git_hub_search_repositories.domain.Repositories

/**
 *
 */
internal class GitHubRepository {

    suspend fun getRepositories(userName: String): List<Repositories> {
        //TODO: Revert after api response is succeed
        return RetrofitInstance.api.getGitHubRepositories(userName)
//
//        return listOf(
//            Repositories(
//                id = 647032678,
//                nodeId = "R_kgDOJpDvZg",
//                name = "abstergo-industries-aws",
//                fullName = "GuerraAna/abstergo-industries-aws",
//                private = false,
//                owner = RepositoryOwner(
//                    login = "GuerraAna",
//                    avatarUrl = "https://avatars.githubusercontent.com/u/78937585?v=4"
//                ),
//                htmlUrl = "https://github.com/GuerraAna/abstergo-industries-aws",
//                description = "Abstergo Industries AWS",
//                fork = false,
//                url = "https://api.github.com/repos/GuerraAna/abstergo-industries-aws"
//            ),
//            Repositories(
//                id = 647032678,
//                nodeId = "R_kgDOJpDvZg",
//                name = "abstergo-industries-aws",
//                fullName = "GuerraAna/abstergo-industries-aws",
//                private = false,
//                owner = RepositoryOwner(
//                    login = "GuerraAna",
//                    avatarUrl = "https://avatars.githubusercontent.com/u/78937585?v=4"
//                ),
//                htmlUrl = "https://github.com/GuerraAna/abstergo-industries-aws",
//                description = "Abstergo Industries AWS",
//                fork = false,
//                url = "https://api.github.com/repos/GuerraAna/abstergo-industries-aws"
//            ),
//            Repositories(
//                id = 647032678,
//                nodeId = "R_kgDOJpDvZg",
//                name = "abstergo-industries-aws",
//                fullName = "GuerraAna/abstergo-industries-aws",
//                private = false,
//                owner = RepositoryOwner(
//                    login = "GuerraAna",
//                    avatarUrl = "https://avatars.githubusercontent.com/u/78937585?v=4"
//                ),
//                htmlUrl = "https://github.com/GuerraAna/abstergo-industries-aws",
//                description = "Abstergo Industries AWS",
//                fork = false,
//                url = "https://api.github.com/repos/GuerraAna/abstergo-industries-aws"
//            ),
//            Repositories(
//                id = 647032678,
//                nodeId = "R_kgDOJpDvZg",
//                name = "abstergo-industries-aws",
//                fullName = "GuerraAna/abstergo-industries-aws",
//                private = false,
//                owner = RepositoryOwner(
//                    login = "GuerraAna",
//                    avatarUrl = "https://avatars.githubusercontent.com/u/78937585?v=4"
//                ),
//                htmlUrl = "https://github.com/GuerraAna/abstergo-industries-aws",
//                description = "Abstergo Industries AWS",
//                fork = false,
//                url = "https://api.github.com/repos/GuerraAna/abstergo-industries-aws"
//            )
//        )
    }
}
