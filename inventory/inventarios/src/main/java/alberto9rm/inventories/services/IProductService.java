package alberto9rm.inventories.services;

import alberto9rm.inventories.model.Producto;
import java.util.List;

// Interfaz que define los métodos CRUD (Crear, Leer, Actualizar, Eliminar) para los productos
public interface IProductService {

    // Método para obtener una lista de todos los productos
    public List<Producto> listProduct();

    // Método para buscar un producto específico por su ID
    public Producto searchProductId(Integer idProduct);

    // Método para guardar (crear o actualizar) un producto
    public Producto saveProduct(Producto producto);

    // Método para eliminar un producto por su ID
    public void deleteProductId(Integer idProduct);
}
