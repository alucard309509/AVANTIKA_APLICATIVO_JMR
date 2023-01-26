package com.twiekie.avantika_aplicativo_jmr.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.twiekie.avantika_aplicativo_jmr.R
import com.twiekie.avantika_aplicativo_jmr.viewmodel.ProductosViewMdel

class MenuFragment : Fragment(R.layout.fragment_menu) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bt1 = requireView().findViewById<Button>(R.id.SHOP)
        val bt2 = requireView().findViewById<Button>(R.id.productoscompradoss)
        val bt3=requireView().findViewById<Button>(R.id.inventario)
        val bt4=requireView().findViewById<Button>(R.id.ventass)
        bt1.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_comprasProductos)
        }
        bt2.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_productosComprados)
        }
        bt3.setOnClickListener { findNavController().navigate(R.id.action_menuFragment_to_inventario)
        }

        bt4.setOnClickListener { findNavController().navigate(R.id.action_menuFragment_to_ventas)
        }

    }
}