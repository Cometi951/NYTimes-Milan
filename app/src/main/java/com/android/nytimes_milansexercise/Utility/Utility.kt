package com.android.nytimes_milansexercise.Utility

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


fun Context.Toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun ViewGroup.inflateLayout(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun <T> AppCompatActivity.response(liveData: LiveData<Resource<T>>, callback: (response: T) -> Unit) {
    liveData.observe(this, androidx.lifecycle.Observer {
       when (it) {
            is Resource.Success<*> -> {
                lifecycleScope.launch {
                    callback(it.value as T)
                }
            }
            is Resource.Failure -> {
                if (it.networkError!!) {
                    Toast("Network Not Available")
                }
            }
        }
    })
}

fun <T> AppCompatActivity.observer(liveData: LiveData<T>, callBack: (data: T) -> Unit){
    liveData.observe(this, androidx.lifecycle.Observer {
        callBack(it)
    })
}