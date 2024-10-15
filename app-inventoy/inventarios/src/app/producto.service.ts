import {HttpClient } from '@angular/common/http';  // Importa HttpClient para realizar peticiones HTTP
import { Injectable } from '@angular/core';        // Importa el decorador Injectable
import { Observable } from 'rxjs';                 // Importa Observable para manejar operaciones asíncronas
import { Producto } from './producto';             // Importa la interfaz o clase Producto

@Injectable({                                      // Decorador que marca la clase como un servicio inyectable
  providedIn: 'root'                               // Hace que el servicio esté disponible en toda la aplicación
})
export class ProductService {                      // Definición de la clase del servicio

  private urlBase = "http://localhost:8080/inventory/productos";  // URL base para las peticiones API

  constructor(private clienteHttp: HttpClient) { } // Constructor que inyecta HttpClient

  FetchProductList(): Observable<Producto[]>{      // Método para obtener lista de productos
    return this.clienteHttp.get<Producto[]>(this.urlBase);
  }

  newProduct(producto: Producto): Observable<Object>{  // Método para crear un nuevo producto
    return this.clienteHttp.post(this.urlBase, producto);
  }

  fetchProductId(id: number){                      // Método para obtener un producto por ID
    return this.clienteHttp.get<Producto>(`${this.urlBase}/${id}`);
  }

  updateProduct(id: number, producto: Producto): Observable<Object>{  // Método para actualizar un producto
    return this.
    clienteHttp.put(`${this.urlBase}/${id}`, producto);
  }

  deleteProduct(id: number): Observable<Object>{   // Método para eliminar un producto
    return this.clienteHttp.delete(`${this.urlBase}/${id}`);
  }
}
