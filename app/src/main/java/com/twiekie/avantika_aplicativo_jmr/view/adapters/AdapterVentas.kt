package com.twiekie.avantika_aplicativo_jmr.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twiekie.avantika_aplicativo_jmr.R
import com.twiekie.avantika_aplicativo_jmr.model.Inventariomodel

class AdapterVentas(private val listado:List<Inventariomodel>?): RecyclerView.Adapter<AdapterVentas.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemclave.text = "Clave :" + listado!![position].claveprod
        viewHolder.itemcantidad.text = "Cantidad:" + listado!![position].cantidad
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_item_ventas, viewGroup, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return listado!!.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemclave: TextView
        var itemcantidad: TextView

        init {
            itemclave = itemView.findViewById(R.id.cantidadventas)
            itemcantidad = itemView.findViewById(R.id.claveventas)
        }
    }
}
