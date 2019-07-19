package com.maro.githubuser.data.remote

import com.google.gson.annotations.SerializedName
import com.maro.githubuser.data.local.UserItem

/**
 * Created by Wanhar on 19/07/19.
 * Email : Wanhardaengmaro@gmail.com
 */

data class GithubUserResponse(

    @SerializedName("total_count")
    val totalCount: Int? = null,

    @SerializedName("incomplete_results")
    val incompleteResults: Boolean? = null,

    @SerializedName("items")
    val user: MutableList<UserItem>
)