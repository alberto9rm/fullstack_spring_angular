package alberto9rm.inventories.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Anotación que indica que cuando se lanza esta excepción, se devolverá un estado HTTP 404 (NOT FOUND)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesException extends RuntimeException {

    // Constructor que acepta un mensaje como parámetro y lo pasa a la clase RuntimeException
    public ResourcesException(String message) {
        super(message); // Llama al constructor de la clase base con el mensaje proporcionado
    }
}
