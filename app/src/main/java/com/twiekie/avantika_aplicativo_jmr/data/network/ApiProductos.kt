package com.twiekie.avantika_aplicativo_jmr.data.network

import com.twiekie.avantika_aplicativo_jmr.model.Productos
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiProductos {

    @GET("prod")
    suspend fun getAllProductos(): Response <List<Productos>>
}