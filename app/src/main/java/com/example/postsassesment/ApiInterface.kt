package com.example.postsassesment

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

        @GET("/posts")
        fun getPosts(): Call<List<Posts>>
}
