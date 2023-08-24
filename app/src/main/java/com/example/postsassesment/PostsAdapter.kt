package com.example.postsassessment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postsassesment.Posts
import com.example.postsassesment.databinding.RecyclerBinding

class PostsAdapter(private val postlist: List<Posts>) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = RecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentPost = postlist[position]
        val binding = holder.binding
        binding.textView4.text = currentPost.id
        binding.textView5.text = currentPost.title
        binding.textView6.text = currentPost.userId.toString()
        binding.textView7.text = currentPost.body
    }

    override fun getItemCount(): Int {
        return postlist.size
    }

    class PostsViewHolder(val binding: RecyclerBinding) : RecyclerView.ViewHolder(binding.root)
}

