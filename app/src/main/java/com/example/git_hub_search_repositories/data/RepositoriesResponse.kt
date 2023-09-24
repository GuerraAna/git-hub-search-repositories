package com.example.git_hub_search_repositories.data

import android.os.Parcelable
import com.example.git_hub_search_repositories.domain.Repositories
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 *
 */
@Parcelize
internal class RepositoriesResponse(
    /** */
    @SerializedName("repos")
    val repositories: List<Repositories>
) : Parcelable