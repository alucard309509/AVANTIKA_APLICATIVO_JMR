package com.twiekie.avantika_aplicativo_jmr.data

import com.twiekie.avantika_aplicativo_jmr.data.network.ProdService
import com.twiekie.avantika_aplicativo_jmr.model.ProdProvider
import com.twiekie.avantika_aplicativo_jmr.model.Productos
import io.paperdb.Paper

class ProductosRepository {
    private val api = ProdService()
    suspend fun getAllProductos(): List<Productos> {
        val response = api.getProd()

        ProdProvider.prod = response
        return response;
    }
}