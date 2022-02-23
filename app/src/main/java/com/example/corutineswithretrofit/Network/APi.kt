package com.example.corutineswithretrofit.Network

import com.example.corutineswithretrofit.Model.Post
import retrofit2.http.GET

interface APi {
    @GET("posts")
    suspend fun getPost(): List<Post>
}