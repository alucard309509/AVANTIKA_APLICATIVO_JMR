package com.twiekie.avantika_aplicativo_jmr.model

import com.google.gson.annotations.SerializedName

data class Productos(
    @SerializedName("claveproducto") val claveproducto: Int,
    @SerializedName("nombreproducto") val nombreproducto: String,
    @SerializedName("precio") val precio: Double,
    @SerializedName("canitidad") val canitidad: Int
)
