package com.twiekie.avantika_aplicativo_jmr.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twiekie.avantika_aplicativo_jmr.R
import com.twiekie.avantika_aplicativo_jmr.view.adapters.AdapterInventario
import com.twiekie.avantika_aplicativo_jmr.view.adapters.AdapterVentas
import com.twiekie.avantika_aplicativo_jmr.viewmodel.ProductosViewMdel
import io.paperdb.Paper

class Ventas : Fragment(R.layout.fragment_ventas) {
    private val prodviewmode: ProductosViewMdel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Paper.init(requireActivity())
        prodviewmode.inventariod()
        prodviewmode.inventarioo.observe(viewLifecycleOwner) { prod ->
            Log.d("hermelando", prod.toString())
            val recycler = requireView().findViewById<RecyclerView>(R.id.listainventarioventas)
            recycler.layoutManager= LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
            recycler!!.setHasFixedSize(true)
            recycler.adapter = AdapterVentas(prod)
        }
    }
}