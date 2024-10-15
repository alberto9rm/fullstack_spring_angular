import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from '../producto';
import { ProductService } from '../producto.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html'
})
export class ProductListComponent {
  // Array para almacenar los productos
  productos: Producto[];

  // Constructor con inyección de dependencias
  constructor(private productService: ProductService,
    private enrutador: Router){}
  
  // Método que se ejecuta al inicializar el componente
  ngOnInit(){
    // Cargamos los productos al iniciar
    this.fetchProduct();
  }

  // Método privado para obtener la lista de productos
  private fetchProduct(){
    // Suscripción al observable que devuelve la lista de productos
    this.productService.FetchProductList().subscribe(
      (datos => {
        this.productos = datos;
      })
    );
  }

  // Método para navegar a la página de actualización de un producto
  updateProduct(id: number){
    this.enrutador.navigate(['update-product', id]);
  }

  // Método para eliminar un producto
  deleteProduct(id: number){
    this.productService.deleteProduct(id).subscribe(
      {
        next: (datos) => this.fetchProduct(), // Si se elimina correctamente, recarga la lista
        error: (errores) => console.log(errores) // Si hay un error, lo muestra en consola
      }
    );
  }
}
