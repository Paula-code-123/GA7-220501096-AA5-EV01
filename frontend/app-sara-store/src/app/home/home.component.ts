import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CarritoService } from '../services/carrito.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  terminoBusqueda: string = '';
  carritoCount: number = 0;
  tallas = ['S', 'M', 'L', 'XL'];

  constructor(private carritoService: CarritoService) {}

  /**
   * Lista de productos disponibles en la tienda.
   */
  productos = [
    {
      nombre: 'Camiseta azul',
      precio: 50000,
      imagen: 'assets/camiseta_azul.webp',
      tallas: this.tallas,
      tallaSeleccionada: '',
    },
    {
      nombre: 'Camiseta polo',
      precio: 85000,
      imagen: 'assets/camiseta_polo.webp',
      tallas: this.tallas,
      tallaSeleccionada: '',
    },
    {
      nombre: 'Camiseta cuello v',
      precio: 80000,
      imagen: 'assets/camiseta_cuello_v.jpg',
      tallas: this.tallas,
      tallaSeleccionada: '',
    },
  ];

  productosFiltrados = [...this.productos];

  /**
   * Filtra los productos según el término de búsqueda.
   */
  filtrarProductos() {
    const termino = this.terminoBusqueda.toLowerCase();
    this.productosFiltrados = this.productos.filter((p) =>
      p.nombre.toLowerCase().includes(termino)
    );
  }

  /**
   * Agrega un producto al carrito.
   * @param producto El producto a agregar.
   */
  agregarAlCarrito(producto: any) {
    this.carritoCount++;
    this.carritoService.agregarProducto(producto);
    console.log('Añadido al carrito:', producto);
  }
}
