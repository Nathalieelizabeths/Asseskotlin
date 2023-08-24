package com.example.postsassesment

data class postsResponse(
    var posts:List<Posts>,
    var total:Int,
    var skip:Int,
    var limit:Int
)


