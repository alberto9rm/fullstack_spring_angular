import { Component } from '@angular/core';  // Importa el decorador Component de Angular

@Component({                                // Decorador que define los metadatos del componente
  selector: 'app-root',                     // Selector CSS para usar este componente en HTML
  templateUrl: './app.component.html'       // Ruta al archivo de plantilla HTML del componente

})
export class AppComponent {                 // Definición de la clase del componente
  title = 'app-inventory';                  // Propiedad del componente (título de la aplicación)
}
