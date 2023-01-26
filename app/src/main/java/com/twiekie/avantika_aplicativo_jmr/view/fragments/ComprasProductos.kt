package com.twiekie.avantika_aplicativo_jmr.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twiekie.avantika_aplicativo_jmr.R
import com.twiekie.avantika_aplicativo_jmr.model.Productos
import com.twiekie.avantika_aplicativo_jmr.view.adapters.AdapterProductos
import com.twiekie.avantika_aplicativo_jmr.view.constants.Constants
import com.twiekie.avantika_aplicativo_jmr.viewmodel.ProductosViewMdel
import io.paperdb.Paper

class ComprasProductos : Fragment(R.layout.fragment_compras_productos) {
    private val prodviewmode: ProductosViewMdel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prodviewmode.onCreate()
        prodviewmode.prodModel.observe(viewLifecycleOwner) { prod ->
            val recycler = requireView().findViewById<RecyclerView>(R.id.lista)
            recycler.layoutManager= LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
            recycler!!.setHasFixedSize(true)
            recycler.adapter =AdapterProductos(prod)
        }
        val comprar=requireView().findViewById<Button>(R.id.save);
        comprar.setOnClickListener {
            Constants.listado2.add(Constants.listado)
            Paper.init(requireActivity())
            val data: MutableList<MutableMap<Int, Productos>>? = Paper.book().read("contacts")
            if(data.isNullOrEmpty()){
                Paper.book().write("inventario",Constants.inventario)
                Paper.book().write("contacts", Constants.listado2)
                Toast.makeText(activity, "is non nullOreMOTY", Toast.LENGTH_SHORT).show()
            }
            else{
                data.add(Constants.listado)
                Paper.book().write("contacts", data)
                val datainventario: MutableMap<Int, Int>?=Paper.book().read("inventario")
                if (datainventario != null) {
                    Constants.inventario.forEach{entry ->
                        if(datainventario.get(entry.key)==null){
                            datainventario.put(entry.key,entry.value)
                        }
                        else{
                            datainventario.put(entry.key,entry.value+ datainventario.get(entry.key)!!)
                        }
                    }
                    Paper.book().write("inventario",datainventario)
                }
            }
            Constants.listado.clear()
            Constants.listado2.clear()
            Constants.inventario.clear()
        }
    }
}