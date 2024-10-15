import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewProductComponent } from './new-product/new-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { ProductListComponent } from './list-product/list-product.component';

// Definición de las rutas de la aplicación
const routes: Routes = [
  // Ruta para la lista de productos
  {path:'productos', component: ProductListComponent},
  // Ruta por defecto, redirige a 'productos'
  {path:'', redirectTo: 'productos', pathMatch:'full'},
  // Ruta para crear un nuevo producto
  {path:'new-product', component: NewProductComponent},
  // Ruta para actualizar un producto específico
  {path: 'update-product/:id', component: UpdateProductComponent}
];

// @NgModule para definir este módulo de enrutamiento:
   // imports: [RouterModule.forRoot(routes)] configura el enrutador con las rutas definidas
   // exports: [RouterModule] hace que el RouterModule esté disponible en toda la aplicación 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
