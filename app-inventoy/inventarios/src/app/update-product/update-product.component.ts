import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Producto } from '../producto';
import { ProductService } from '../producto.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html'
})
export class UpdateProductComponent {
  // Inicializa un objeto Producto y una variable para el ID
  producto: Producto = new Producto();
  id: number;

  // Constructor con inyección de dependencias
  constructor(private productService: ProductService,
    private ruta: ActivatedRoute,
    private enrutador: Router){}

  // Método que se ejecuta al inicializar el componente
  ngOnInit(){
    // Obtiene el ID del producto de los parámetros de la ruta
    this.id = this.ruta.snapshot.params['id'];
    // Obtiene los datos del producto usando el ID
    this.productService.fetchProductId(this.id).subscribe(
      {
        next: (datos) => this.producto = datos,
        error: (errores: any) => console.log(errores)
      }
    );
  }  

  // Método llamado cuando se envía el formulario
  onSubmit(){
    this.saveProduct();
  }

  // Método para guardar los cambios del producto
  saveProduct(){
    this.productService.updateProduct(this.id, this.producto).subscribe(
      {
        next: (datos) => this.goListProduct(),
        error: (errores) => console.log(errores)
      }
    );
  }

  // Método para navegar a la lista de productos
  goListProduct(){
    this.enrutador.navigate(['/productos']);
  }
}
