package cl.lorimaralarcon.evaluacion2_p2.data

import cl.lorimaralarcon.evaluacion2_p2.data.modelo.Producto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.io.FileInputStream
import java.io.FileOutputStream

class ProductosRepository (
    private val productoMemoryDataSource: ProductoMemoryDataSource = ProductoMemoryDataSource(),
    private val productoDiskDataSource: ProductoDiskDataSource = ProductoDiskDataSource()
) {
    private val _productosStream = MutableStateFlow(listOf<Producto>())

    fun getProductosEnDisco(fileInputStream: FileInputStream) {
        val productos = productoDiskDataSource.obtener(fileInputStream)
        insertar(*productos.toTypedArray())
    }

    fun guardarProductosEnDisco(fileOutputStream: FileOutputStream) {
        productoDiskDataSource.guardar(fileOutputStream, productoMemoryDataSource.obtenerTodos())
    }

    fun getProdcutosStream():StateFlow<List<Producto>> {
        _productosStream.update {
            ArrayList(productoMemoryDataSource.obtenerTodos())
        }
        return _productosStream.asStateFlow()
    }

    fun insertar(vararg productos:Producto) {
        productoMemoryDataSource.insertar(*productos)
        getProdcutosStream()
    }

    fun eliminar(producto: Producto) {
        productoMemoryDataSource.eliminar(producto)
        getProdcutosStream()
    }
}

