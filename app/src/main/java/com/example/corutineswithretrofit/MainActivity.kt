package com.example.corutineswithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.corutineswithretrofit.Adapter.PostAdapter
import com.example.corutineswithretrofit.Model.Post
import com.example.corutineswithretrofit.Repository.PostRepository
import com.example.corutineswithretrofit.ViewModel.PostViewModel
import com.example.corutineswithretrofit.ViewModel.PostViewModelFactory

class MainActivity : AppCompatActivity() {
    private  lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var  postViewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar:ProgressBar=findViewById(R.id.progressBar)
        initRecycleView()
        val postRepository= PostRepository()
        val viewModelFactory=PostViewModelFactory(postRepository)
        postViewModel=ViewModelProvider(this,viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postMutableLiveData.observe(this, Observer {
            postAdapter.setData(it as ArrayList<Post>)
            progressBar.visibility= View.GONE;
            recyclerView.visibility=View.VISIBLE;
        })
    }

    private fun initRecycleView() {
        recyclerView = findViewById(R.id.recycleView)
        postAdapter= PostAdapter(this, ArrayList())

        recyclerView.apply{
           setHasFixedSize(true)
           layoutManager=LinearLayoutManager(this@MainActivity)
           adapter=postAdapter
        }
    }
}