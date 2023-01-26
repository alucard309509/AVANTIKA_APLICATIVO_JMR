package com.twiekie.avantika_aplicativo_jmr.view.adapters;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twiekie.avantika_aplicativo_jmr.R
import com.twiekie.avantika_aplicativo_jmr.model.Totales

class AdapterProductoscomprados(private val listado: List<Totales>?) :
    RecyclerView.Adapter<AdapterProductoscomprados.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_item_totales, viewGroup, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemTotal.text = "Total:" + listado!![position].total
        viewHolder.itemFecha.text = "Fecha de compra:" + listado!![position].fechacompra
    }
    override fun getItemCount(): Int {
        return listado!!.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTotal: TextView
        var itemFecha: TextView
        init {
            itemTotal = itemView.findViewById(R.id.total)
            itemFecha = itemView.findViewById(R.id.fechacompra)
        }
    }
}
