package com.twiekie.avantika_aplicativo_jmr.domain

import com.twiekie.avantika_aplicativo_jmr.data.ProductosRepository
import com.twiekie.avantika_aplicativo_jmr.model.Productos

class GetUProdUseCase {

    private val repository=ProductosRepository()

    suspend operator fun invoke():List<Productos>?=repository.getAllProductos()
}