package com.twiekie.avantika_aplicativo_jmr.domain

import com.twiekie.avantika_aplicativo_jmr.data.ProductosRepository
import com.twiekie.avantika_aplicativo_jmr.data.ProductsRepository
import com.twiekie.avantika_aplicativo_jmr.model.Productos
import com.twiekie.avantika_aplicativo_jmr.model.Totales

class GetTotalsUseCase {

    private val repositorytotal= ProductsRepository()

    suspend operator fun invoke():List<Totales>?=repositorytotal.getAllTotales()
}