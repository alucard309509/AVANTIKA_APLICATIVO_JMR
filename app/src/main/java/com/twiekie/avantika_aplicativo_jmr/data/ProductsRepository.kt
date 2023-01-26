package com.twiekie.avantika_aplicativo_jmr.data

import android.util.Log
import com.twiekie.avantika_aplicativo_jmr.model.Productos
import com.twiekie.avantika_aplicativo_jmr.model.Totales
import com.twiekie.avantika_aplicativo_jmr.view.constants.Constants
import io.paperdb.Paper
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ProductsRepository {
    suspend fun getAllTotales(): List<Totales> {
        Constants.total.clear()
        val data: MutableList<MutableMap<Int, Productos>>? = Paper.book().read("contacts")
        if (!data.isNullOrEmpty()) {
            var clave:Int
            var cantidad:Int
            data!!.forEach {
                var suma: Double = 0.0
                var cantidad:Int=0
                for (key in it.keys) {
                    suma = suma + it[key]!!.precio * it[key]!!.canitidad

                }
                val dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd yyyy"))
                //total = Totales(suma, dateTime + "")*/
                val total = Totales(suma, dateTime)
                Constants.total.add(total)
            }
        }
        return Constants.total;
    }
}