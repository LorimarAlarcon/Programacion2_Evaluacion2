package cl.lorimaralarcon.evaluacion2_p2.ui.theme.state

import cl.lorimaralarcon.evaluacion2_p2.data.modelo.Producto

data class ProductosUIState (
    val mensaje:String = "",
    val productos:List<Producto> = emptyList(),
    val ordenAlfabetico: Boolean = false,
    val mostrarPrimeroNoEncontrados: Boolean = false
)