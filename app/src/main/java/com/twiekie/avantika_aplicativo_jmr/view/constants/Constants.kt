package com.twiekie.avantika_aplicativo_jmr.view.constants

import com.twiekie.avantika_aplicativo_jmr.model.Inventariomodel
import com.twiekie.avantika_aplicativo_jmr.model.Productos
import com.twiekie.avantika_aplicativo_jmr.model.Totales

class Constants {

    companion object  {
        lateinit var listaproductos: List<Productos>
       // lateinit var listado: MutableList<Productos>=mutable
        //val listado= mutableListOf<Productos>()
        val listado= mutableMapOf<Int,Productos>()
        val listado2= mutableListOf<MutableMap<Int,Productos>>()
        var total= mutableListOf<Totales>()
       //
        //
        val inventario= mutableMapOf<Int,Int>()

        var listadoinv= mutableListOf<Inventariomodel>()

    }
}