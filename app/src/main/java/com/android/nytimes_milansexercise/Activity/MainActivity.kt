package com.android.nytimes_milansexercise.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.nytimes_milansexercise.Adapter.AdapterArticleList
import com.android.nytimes_milansexercise.Constant.Constant.API_KEY
import com.android.nytimes_milansexercise.Constant.Constant.ARTICLE
import com.android.nytimes_milansexercise.Constant.Constant.OK
import com.android.nytimes_milansexercise.Data.DataArticle
import com.android.nytimes_milansexercise.R
import com.android.nytimes_milansexercise.Utility.Toast
import com.android.nytimes_milansexercise.Utility.observer
import com.android.nytimes_milansexercise.Utility.response
import com.android.nytimes_milansexercise.ViewModel.ViewModelArticle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var listArticle = ArrayList<DataArticle.Result>()
    val viewModelArticle: ViewModelArticle by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        apiCall()
    }

    private fun init() {
        supportActionBar?.hide()
        recycler_article.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = AdapterArticleList(this@MainActivity, listArticle) {
                startActivity(Intent(this@MainActivity, ActivityDetail::class.java).putExtra(ARTICLE, listArticle.get(it)))
            }
        }
    }

    private fun apiCall() {
        viewModelArticle.getArticle()
        response(viewModelArticle.articleResponse) {
            if (it.status.equals(OK)){
                listArticle.addAll(it.results)
                recycler_article.adapter!!.notifyDataSetChanged()
            }
            else
                Toast(it.status)
        }
    }

}