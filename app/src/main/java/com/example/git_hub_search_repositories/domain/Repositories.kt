package com.example.git_hub_search_repositories.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 *
 * @param id Long
 */
@Parcelize
data class Repositories(
    @SerializedName("id") val id: Long,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("private") val private: Boolean,
    @SerializedName("owner") val owner: RepositoryOwner,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("description") val description: String? = null,
    @SerializedName("fork") val fork: Boolean,
    @SerializedName("url") val url: String
) : Parcelable