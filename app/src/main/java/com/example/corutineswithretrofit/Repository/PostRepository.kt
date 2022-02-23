package com.example.corutineswithretrofit.Repository

import com.example.corutineswithretrofit.Model.Post
import com.example.corutineswithretrofit.Network.RetrofitBuilder

class PostRepository {

    suspend fun getPost():List<Post> = RetrofitBuilder.api.getPost()
}