package com.maro.githubuser.data.local

import com.google.gson.annotations.SerializedName

/**
 * Created by Wanhar on 19/07/19.
 * Email : Wanhardaengmaro@gmail.com
 */
data class UserItem(

    @SerializedName("gists_url")
    val gistsUrl: String? = null,

    @SerializedName("repos_url")
    val reposUrl: String? = null,

    @SerializedName("following_url")
    val followingUrl: String? = null,

    @SerializedName("starred_url")
    val starredUrl: String? = null,

    @SerializedName("login")
    val login: String? = null,

    @SerializedName("followers_url")
    val followersUrl: String? = null,

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String? = null,

    @SerializedName("score")
    val score: Double? = null,

    @SerializedName("received_events_url")
    val receivedEventsUrl: String? = null,

    @SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @SerializedName("events_url")
    val eventsUrl: String? = null,

    @SerializedName("html_url")
    val htmlUrl: String? = null,

    @SerializedName("site_admin")
    val siteAdmin: Boolean? = null,

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("gravatar_id")
    val gravatarId: String? = null,

    @SerializedName("organizations_url")
    val organizationsUrl: String? = null
)