package com.android.nytimes_milansexercise.Adapter

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.android.nytimes_milansexercise.Data.DataArticle
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class AdapterArticleListTest{

    private lateinit var adapterArticleList: AdapterArticleList


    @Test
    fun testAdapter(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val listArticle = articles()
        adapterArticleList = AdapterArticleList(context, listArticle){

        }
        assertThat(adapterArticleList).isNotNull()
    }

    fun articles() : List<DataArticle.Result> {
        val des_facet = List(1, {""})
        val geo_facet = List(1, {""})
        val org_facet = List(1, {""})
        val per_facet = List(1, {""})
        val metaData  = List(1, { DataArticle.Result.Media.MediaMetadata("",1,"",1)})
        val mediaList = List(1, { DataArticle.Result.Media(1,",","",metaData,"","")})
        val articleResult = DataArticle.Result("","",1,"","",des_facet,1,geo_facet, 1,mediaList,"",org_facet,per_facet,"","","","","","","","","")
        val listResult = List(1, {articleResult})
        //val article = DataArticle("",20,listResult,"")
        return listResult
    }

}