import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './list-product/list-product.component';
import { NewProductComponent  } from './new-product/new-product.component';
import { FormsModule } from '@angular/forms';
import { UpdateProductComponent } from './update-product/update-product.component';

@NgModule({
  declarations: [                           // Componentes, directivas y pipes del módulo
    AppComponent,                           // Componente raíz
    ProductListComponent,                   // Componente para listar productos
    NewProductComponent,                    // Componente para crear nuevos productos
    UpdateProductComponent                  // Componente para actualizar productos
  ],
  imports: [                                // Módulos necesarios para este módulo
    BrowserModule,                          // Esencial para aplicaciones en navegador
    HttpClientModule,                       // Para realizar peticiones HTTP
    AppRoutingModule,                       // Módulo de enrutamiento personalizado
    FormsModule                             // Para trabajar con formularios
  ],
  providers: [],                            // Proveedores de servicios (vacío en este caso)
  bootstrap: [AppComponent]                 // Componente de arranque de la aplicación
})
export class AppModule { }                  // Definición del módulo principal
