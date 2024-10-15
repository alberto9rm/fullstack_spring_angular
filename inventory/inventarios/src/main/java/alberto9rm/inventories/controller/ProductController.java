package alberto9rm.inventories.controller;

import alberto9rm.inventories.exception.ResourcesException;
import alberto9rm.inventories.model.Producto;
import alberto9rm.inventories.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // Indica que esta clase es un controlador REST y sus métodos devolverán respuestas en formato JSON
@RequestMapping("inventory") // Mapea las solicitudes HTTP a la URL base "/inventory"
@CrossOrigin(value = "http://localhost:4200") // Permite solicitudes CORS desde el dominio especificado (Angular en puerto 4200)

public class ProductController {

    // Logger para registrar mensajes en el sistema (depuración e información)
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    // Inyección de dependencias para el servicio de productos
    @Autowired
    private ProductService productService;

    // Método para obtener una lista de todos los productos disponibles en el inventario
    @GetMapping("/productos") // Mapea las solicitudes GET a la URL "/inventory/productos"
    public List<Producto> obtenerProduct(){

        // Obtiene la lista de productos desde el servicio
        List<Producto> productos = this.productService.listProduct();
        logger.info("Sourced Products: ");

        // Itera y registra cada producto en el log
        productos.forEach((producto -> logger.info(producto.toString())));
        // Devuelve la lista de productos
        return productos;
    }

    // Método para crear un nuevo producto en el inventario
    @PostMapping("/productos") // Mapea las solicitudes POST a la URL "/inventory/productos"
    public Producto newProduct(@RequestBody Producto producto){

        // Registra el producto que se va a agregar en el log
        logger.info("Product to Be Added:  " + producto);

        // Llama al servicio para guardar el nuevo producto en la base de datos
        return this.productService.saveProduct(producto);
    }

    // Método para obtener un producto específico por su ID
    @GetMapping("/productos/{id}") // Mapea las solicitudes GET para obtener un producto por su ID
    public ResponseEntity<Producto> fetchProductId(@PathVariable int id){

        // Busca el producto por su ID
        Producto producto = this.productService.searchProductId(id);

        // Si el producto existe, se devuelve con un estado 200 OK
        if(producto != null)
            return ResponseEntity.ok(producto);
        else
            // Si no se encuentra, lanza una excepción personalizada
            throw new ResourcesException("ID not recognized: " + id);
    }

    // Método para actualizar los detalles de un producto existente
    @PutMapping("/productos/{id}") // Mapea las solicitudes PUT para actualizar un producto por su ID
    public ResponseEntity<Producto> updateProduct(
            @PathVariable int id, // Captura el ID desde la URL
            @RequestBody Producto productReceived ){ // Recibe los nuevos datos del producto en el cuerpo de la solicitud

        // Busca el producto por su ID
        Producto producto = this.productService.searchProductId(id);

        // Si el producto no existe, lanza una excepción
        if(producto == null)
            throw new ResourcesException("ID not recognized: " + id);

        // Actualiza los campos del producto con los nuevos valores recibidos
        producto.setDescription(productReceived.getDescription());
        producto.setPrice(productReceived.getPrice());
        producto.setStock(productReceived.getStock());

        // Guarda los cambios en la base de datos
        this.productService.saveProduct(producto);

        // Devuelve el producto actualizado con un estado 200 OK
        return ResponseEntity.ok(producto);
    }

    // Método para eliminar un producto por su ID
    @DeleteMapping("/productos/{id}") // Mapea las solicitudes DELETE para eliminar un producto por su ID
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable int id){

        // Busca el producto por su ID
        Producto producto = productService.searchProductId(id);

        // Si no se encuentra el producto, lanza una excepción
        if (producto == null)
            throw new ResourcesException("ID not recognized:  " + id);

        // Elimina el producto de la base de datos
        this.productService.deleteProductId(producto.getIdProduct());

        // Crea un mapa para devolver la respuesta de éxito de eliminación
        Map<String, Boolean> result = new HashMap<>();

        result.put("Deleted", Boolean.TRUE); // Indicador de que la eliminación fue exitosa
        // Devuelve el mapa con un estado 200 OK
        return ResponseEntity.ok(result);
        
    }

}
