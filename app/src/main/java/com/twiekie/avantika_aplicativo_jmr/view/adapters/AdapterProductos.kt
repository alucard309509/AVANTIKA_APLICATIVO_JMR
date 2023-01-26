package com.twiekie.avantika_aplicativo_jmr.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.twiekie.avantika_aplicativo_jmr.R
import com.twiekie.avantika_aplicativo_jmr.model.Productos
import com.twiekie.avantika_aplicativo_jmr.view.constants.Constants

class AdapterProductos(private val listado: List<Productos>?) :
    RecyclerView.Adapter<AdapterProductos.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_item_prod, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemClaveprod.text = "Codigo de producto:" + listado!![position].claveproducto
        viewHolder.itemTitle.text = "Nombre Producto:" + listado!![position].nombreproducto
        viewHolder.itemPrice.text = "Precio:" + listado!![position].precio.toString()
        viewHolder.itemQuantity.text = "Cantidad:" + listado!![position].canitidad.toString()
        viewHolder.itemadd.setOnClickListener {
            if (!viewHolder.cantidadadquirida.text.toString().isNullOrEmpty()) {
                viewHolder.cantidadadquirida.setText(
                    "" + (viewHolder.cantidadadquirida.text.toString().toInt() + 1)
                )
                Constants.listado.put(
                    position,
                    validaciondata(
                        listado!![position],
                        viewHolder.cantidadadquirida.text.toString()
                    )
                )
                //este metodo se encarga de el inventario
                Constants.inventario.put(
                    listado!![position].claveproducto,
                    viewHolder.cantidadadquirida.text.toString().toInt()
                )
            } else if (viewHolder.cantidadadquirida.text.toString().isEmpty()) {
                viewHolder.cantidadadquirida.setText("1")
                Constants.listado.put(
                    position,
                    validaciondata(
                        listado!![position],
                        viewHolder.cantidadadquirida.text.toString()
                    )
                )
                //este metodo se encarga de el inventario
                Constants.inventario.put(
                    listado!![position].claveproducto,
                    viewHolder.cantidadadquirida.text.toString().toInt()
                )
            }
        }
        viewHolder.itemless.setOnClickListener {
            if (!viewHolder.cantidadadquirida.text.toString().isNullOrEmpty()) {
                viewHolder.cantidadadquirida.setText(
                    "" + (viewHolder.cantidadadquirida.text.toString().toInt() - 1)
                )
                Constants.listado.put(
                    position,
                    validaciondata(
                        listado!![position],
                        viewHolder.cantidadadquirida.text.toString()
                    )
                )
                //este metodo se encarga de el inventario
                Constants.inventario.put(
                    listado!![position].claveproducto,
                    viewHolder.cantidadadquirida.text.toString().toInt()
                )
            } else if (viewHolder.cantidadadquirida.text.toString().isEmpty()) {
                viewHolder.cantidadadquirida.setText("0")
                Constants.listado.put(
                    position,
                    validaciondata(
                        listado!![position],
                        viewHolder.cantidadadquirida.text.toString()
                    )
                )
                //este metodo se encarga de el inventario
                Constants.inventario.put(
                    listado!![position].claveproducto,
                    viewHolder.cantidadadquirida.text.toString().toInt()
                )
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemClaveprod: TextView
        var itemTitle: TextView
        var itemPrice: TextView
        var itemQuantity: TextView
        var itemLinear: ConstraintLayout;
        var itemContext: Context
        var cantidadadquirida: EditText
        var itemadd: ImageView
        var itemless: ImageView

        init {
            itemContext = itemView.context
            itemLinear = itemView.findViewById(R.id.compra)
            itemImage = itemView.findViewById(R.id.imagenFoto)
            itemClaveprod = itemView.findViewById(R.id.tclaveprod)
            itemTitle = itemView.findViewById(R.id.txt_nombre)
            itemPrice = itemView.findViewById(R.id.txt_precio)
            itemQuantity = itemView.findViewById(R.id.txt_cantidad)
            cantidadadquirida = itemView.findViewById(R.id.cantidadadquirida)
            itemadd = itemView.findViewById(R.id.add)
            itemless = itemView.findViewById(R.id.less)
        }
    }

    override fun getItemCount(): Int {
        return listado!!.size
    }

    fun validaciondata(productos: Productos, s: String): Productos {
        val objetoprod = Productos(
            productos.claveproducto,
            productos.nombreproducto,
            productos.precio,
            s.toInt()
        )
        return objetoprod
    }
}