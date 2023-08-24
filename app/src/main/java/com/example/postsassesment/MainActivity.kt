package com.example.postsassesment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postsassesment.databinding.ActivityMainBinding
import com.example.postsassessment.PostsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        getPosts()
    }

    private fun getPosts() {
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : Callback<List<Posts>>{
            override fun onResponse(
                call: Call<List<Posts>>,
                response: Response<List<Posts>>
            ) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    val postsAdapter = PostsAdapter(posts ?: emptyList())
                    binding.rvposts.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvposts.adapter = postsAdapter
                    Toast.makeText(
                        baseContext,
                        "Fetched ${posts?.size} posts",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
