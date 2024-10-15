import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from '../producto';
import { ProductService } from '../producto.service';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html'
})
export class NewProductComponent {
  // Inicializa un nuevo objeto Producto
  producto: Producto = new Producto();

  // Constructor con inyección de dependencias
  constructor(private productService: ProductService,
    private enrutador: Router) {}

  // Método llamado cuando se envía el formulario
  onSubmit() {
    this.saveProduct();
  }

  // Método para guardar el nuevo producto
  saveProduct() {
    this.productService.newProduct(this.producto).subscribe(
      {
        next: (datos) => {
          // Si se guarda correctamente, navega a la lista de productos
          this.goListProduct();
        },
        error: (error: any) => {
          // Si hay un error, lo muestra en la consola
          console.log(error)
        }
      }
    );
  }

  // Método para navegar a la lista de productos
  goListProduct() {
    this.enrutador.navigate(['/productos']);
  }
}
