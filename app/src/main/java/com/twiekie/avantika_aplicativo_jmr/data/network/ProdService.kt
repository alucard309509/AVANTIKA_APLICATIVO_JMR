package com.twiekie.avantika_aplicativo_jmr.data.network

import android.util.Log
import com.twiekie.avantika_aplicativo_jmr.core.RetrofitHelper
import com.twiekie.avantika_aplicativo_jmr.model.Productos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProdService {

    private val retrofit= RetrofitHelper.getRetrofit()
    suspend fun  getProd():List<Productos>{

        return withContext(Dispatchers.IO){
            val response=retrofit.create(ApiProductos::class.java).getAllProductos()
            Log.i("response",response.message())
            response.body()?: emptyList()
        }
    }
}