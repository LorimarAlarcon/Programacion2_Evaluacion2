package cl.lorimaralarcon.evaluacion2_p2.data.modelo

import java.io.Serializable

data class Producto(
    val id:String,
    val nombre:String,
    var encontrado: Boolean = false
) : Serializable