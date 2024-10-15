package alberto9rm.inventories.services;

import alberto9rm.inventories.model.Producto;
import alberto9rm.inventories.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// Anotación que indica que esta clase es un servicio, y Spring la gestionará como un componente de la aplicación
@Service
public class ProductService implements IProductService {

    // Inyección de dependencias del repositorio de productos
    @Autowired
    private ProductRepository productRepository;

    // Método para obtener una lista de todos los productos
    @Override
    public List<Producto> listProduct() {
        
        // Llama al método del repositorio para obtener todos los productos
        return this.productRepository.findAll();
    }

    // Método para buscar un producto por su ID
    @Override
    public Producto searchProductId(Integer idProduct) {

        // Busca el producto en el repositorio utilizando su ID
        Producto producto = this.productRepository.findById(idProduct).orElse(null);

        // Devuelve el producto encontrado o null si no se encuentra
        return producto;
    }

    // Método para guardar un producto (crear o actualizar)
    @Override
    public Producto saveProduct(Producto producto) {

        // Llama al método del repositorio para guardar el producto en la base de datos
        return this.productRepository.save(producto);
    }

    // Método para eliminar un producto por su ID
    @Override
    public void deleteProductId(Integer idProduct) {

        // Llama al método del repositorio para eliminar el producto de la base de datos utilizando su ID
        this.productRepository.deleteById(idProduct);
    }
}
