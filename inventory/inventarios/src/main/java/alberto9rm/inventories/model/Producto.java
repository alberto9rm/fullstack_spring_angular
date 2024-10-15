package alberto9rm.inventories.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Indica que esta clase es una entidad JPA y está mapeada a una tabla de la base de datos
@Entity
// Anotación de Lombok que genera automáticamente los métodos getters, setters, equals, hashCode y toString
@Data
// Genera un constructor sin argumentos
@NoArgsConstructor
// Genera un constructor con todos los campos de la clase
@AllArgsConstructor
// Genera un método toString para representar la clase como una cadena
@ToString
public class Producto {

    // Indica que este campo es la clave primaria de la entidad
    @Id
    // Especifica que el valor del campo será generado automáticamente, utilizando la estrategia de auto-incremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProduct; // ID único del producto, autogenerado por la base de datos

    // Descripción del producto
    String description;

    // Precio del producto
    Double price;

    // Cantidad en stock del producto
    Integer stock;
}
