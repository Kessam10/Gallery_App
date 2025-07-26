package com.example.data.utils

import android.util.Log
import com.example.data.R
import com.google.gson.Gson
import java.io.IOException
import java.net.UnknownHostException


fun handleError(throwable: Throwable): Exception {
    return when (throwable) {
        is UnknownHostException, is IOException -> {
            Log.e("TAG", "handleError: ${throwable.message}")
            R.string.check_your_internet_connection
            Exception(throwable)
        }

        else -> {
            Log.e("TAG", "handleError: ${throwable.message}")
            Log.e("TAG", "handleError: Throwable object : $throwable")
            Exception(throwable)
        }
    }
}

fun <T> String.fromJson(clazz: Class<T>): T {
    val gson = Gson()
    return gson.fromJson(this, clazz)
}
