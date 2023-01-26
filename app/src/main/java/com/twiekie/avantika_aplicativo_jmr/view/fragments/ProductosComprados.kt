package com.twiekie.avantika_aplicativo_jmr.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twiekie.avantika_aplicativo_jmr.R
import com.twiekie.avantika_aplicativo_jmr.model.Productos
import com.twiekie.avantika_aplicativo_jmr.view.adapters.AdapterProductoscomprados
import com.twiekie.avantika_aplicativo_jmr.view.constants.Constants
import com.twiekie.avantika_aplicativo_jmr.viewmodel.ProductosViewMdel
import io.paperdb.Paper

class ProductosComprados : Fragment(R.layout.fragment_productos_comprados) {

    private val prodviewmode: ProductosViewMdel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Paper.init(requireActivity())
        prodviewmode.total()
        prodviewmode.totals.observe(viewLifecycleOwner) { prod ->
            val datainventario: MutableMap<Int, Int>?=Paper.book().read("inventario")
           // for(key in Constants.inventario.keys){
                Log.d("vida", datainventario.toString())
          //  }
            Log.d("ejercicoos",prod.toString())
            val recycler = requireView().findViewById<RecyclerView>(R.id.listaproductoscomprados)
            recycler.layoutManager= LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
            recycler!!.setHasFixedSize(true)
            recycler.adapter = AdapterProductoscomprados(prod)
        }
    }
}