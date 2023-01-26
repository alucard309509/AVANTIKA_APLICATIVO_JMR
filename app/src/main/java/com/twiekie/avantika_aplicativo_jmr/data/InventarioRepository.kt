package com.twiekie.avantika_aplicativo_jmr.data

import com.twiekie.avantika_aplicativo_jmr.model.Inventariomodel
import com.twiekie.avantika_aplicativo_jmr.view.constants.Constants
import io.paperdb.Paper

class InventarioRepository {
    suspend fun getInventario(): List<Inventariomodel> {
        Constants.listadoinv.clear()
        val datainventario: MutableMap<Int, Int>? = Paper.book().read("inventario")
        if (!datainventario.isNullOrEmpty()) {
            datainventario.keys.forEach { key ->
                val value = Inventariomodel(key, datainventario[key])
                Constants.listadoinv.add(value)
            }
        }
        return Constants.listadoinv
    }
}