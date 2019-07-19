package com.maro.githubuser.api

import com.maro.githubuser.data.remote.GithubUserResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Wanhar on 22/06/19.
 * Email : Wanhardaengmaro@gmail.com
 */
interface ApiService {


    @Headers("Accept: application/vnd.github.v3+json")
    @GET("search/users")
    fun getUsers(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 20
    ): Observable<GithubUserResponse>
}
