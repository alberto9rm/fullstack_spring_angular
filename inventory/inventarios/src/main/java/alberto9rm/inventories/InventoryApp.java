package alberto9rm.inventories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotación que indica que esta clase es una aplicación Spring Boot
@SpringBootApplication
public class InventoryApp {

    // Método principal que se ejecuta al iniciar la aplicación
    public static void main(String[] args) {

        // Llama al método run de SpringApplication para iniciar la aplicación
        SpringApplication.run(InventoryApp.class, args);
    }
}
