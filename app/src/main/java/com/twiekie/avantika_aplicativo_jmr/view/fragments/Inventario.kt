package com.twiekie.avantika_aplicativo_jmr.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twiekie.avantika_aplicativo_jmr.R
import com.twiekie.avantika_aplicativo_jmr.view.adapters.AdapterInventario
import com.twiekie.avantika_aplicativo_jmr.view.adapters.AdapterProductoscomprados
import com.twiekie.avantika_aplicativo_jmr.view.constants.Constants
import com.twiekie.avantika_aplicativo_jmr.viewmodel.ProductosViewMdel
import io.paperdb.Paper

class Inventario : Fragment(R.layout.fragment_inventario) {

    private val prodviewmode: ProductosViewMdel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Paper.init(requireActivity())
        prodviewmode.inventariod()
        prodviewmode.inventarioo.observe(viewLifecycleOwner) { prod ->
            val recycler = requireView().findViewById<RecyclerView>(R.id.listainventario)
            recycler.layoutManager= LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
            recycler!!.setHasFixedSize(true)
            recycler.adapter = AdapterInventario(prod)
        }
    }
}