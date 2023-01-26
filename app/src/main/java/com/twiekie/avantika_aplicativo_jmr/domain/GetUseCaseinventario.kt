package com.twiekie.avantika_aplicativo_jmr.domain

import com.twiekie.avantika_aplicativo_jmr.data.InventarioRepository
import com.twiekie.avantika_aplicativo_jmr.data.ProductsRepository
import com.twiekie.avantika_aplicativo_jmr.model.Inventariomodel
import com.twiekie.avantika_aplicativo_jmr.model.Totales

class GetUseCaseinventario {

    private val repositorytotal= InventarioRepository()

    suspend operator fun invoke():List<Inventariomodel>?=repositorytotal.getInventario()
}