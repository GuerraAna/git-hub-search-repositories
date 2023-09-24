package com.example.git_hub_search_repositories.data

import android.os.Parcelable
import com.example.git_hub_search_repositories.domain.Repositories
import kotlinx.parcelize.Parcelize

/**
 *
 */
@Parcelize
internal class RepositoriesResponse(
    /** */
    val repositories: List<Repositories>
) : Parcelable