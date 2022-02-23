package com.example.corutineswithretrofit.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.corutineswithretrofit.Model.Post
import com.example.corutineswithretrofit.R

class PostAdapter(private val context: Context, private var postlist: ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return  PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false));
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post=postlist[position]
        holder.id.text=post.id.toString();
        holder.title.text=post.title.toString();
    }

    override fun getItemCount(): Int =postlist.size;

    class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val id:TextView=itemView.findViewById(R.id.id);
        val title:TextView=itemView.findViewById(R.id.title);
    }

    fun setData(postlist: ArrayList<Post>)
    {
        this.postlist=postlist;
        notifyDataSetChanged();
    }
}