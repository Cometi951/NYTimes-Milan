package com.android.nytimes_milansexercise.Activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.nytimes_milansexercise.Constant.Constant
import com.android.nytimes_milansexercise.Constant.Constant.ARTICLE
import com.android.nytimes_milansexercise.Data.DataArticle
import com.android.nytimes_milansexercise.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class ActivityDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        init()
    }

    private fun init() {
        supportActionBar?.hide()
        val article = intent.getSerializableExtra(ARTICLE) as DataArticle.Result
        if (article.media.size > 0)
            Glide.with(this).load(article.media.get(0).media_metadata.get(2).url)
                .into(img_detail)
        title_detail.text = article.title
        detail_detail.text = article.abstract
        type.text = article.subsection
        time.text = article.published_date
        back.setOnClickListener {
            finish()
        }
        web.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(article.url)))
        }
    }

}