package com.example.git_hub_search_repositories.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * @param login String
 */
@Parcelize
data class RepositoryOwner(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
) : Parcelable