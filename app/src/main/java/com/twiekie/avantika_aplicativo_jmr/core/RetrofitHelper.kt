package com.twiekie.avantika_aplicativo_jmr.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/alucard309509/Apiproductos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}