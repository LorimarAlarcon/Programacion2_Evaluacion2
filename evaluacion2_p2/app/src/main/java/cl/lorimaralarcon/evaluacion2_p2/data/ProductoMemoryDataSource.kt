package cl.lorimaralarcon.evaluacion2_p2.data

import android.util.Log
import cl.lorimaralarcon.evaluacion2_p2.data.modelo.Producto
import java.util.UUID

class ProductoMemoryDataSource {
    private val _productos = mutableListOf<Producto>()

    init {
        _productos.addAll(productosDePrueba())
    }

    fun obtenerTodos():List<Producto> {
        return _productos
    }

    fun insertar(vararg productos: Producto) {
        _productos.addAll( productos.asList())
    }

    fun eliminar(producto: Producto) {
        _productos.remove(producto)
        Log.v("DataSource", _productos.toString())
    }

    fun marcarProductoEncontrado(productoId: String, encontrado: Boolean) {
        val producto = _productos.find { it.id == productoId }
        producto?.encontrado = encontrado
    }

    private fun productosDePrueba():List<Producto> = listOf(
        /*
        Producto(UUID.randomUUID().toString(), "Arroz"),
        Producto(UUID.randomUUID().toString(), "Salsa de Tomate"),
        Producto(UUID.randomUUID().toString(), "Sal"),
        Producto(UUID.randomUUID().toString(), "Queso")
         */
    )


}