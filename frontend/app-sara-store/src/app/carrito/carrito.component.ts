import { Component, OnInit } from '@angular/core';
import { CarritoService } from '../services/carrito.service';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-carrito',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './carrito.component.html',
  styleUrl: './carrito.component.css',
})
export class CarritoComponent implements OnInit {
  productos: any[] = [];

  constructor(private carritoService: CarritoService) {}

  ngOnInit() {
    this.productos = this.carritoService.obtenerProductos();
  }

  // Eliminar producto
  eliminarProducto(index: number) {
    this.carritoService.eliminarProducto(index);
    this.productos = this.carritoService.obtenerProductos(); // refresca
  }

  // Cambiar cantidad de producto
  cambiarCantidad(index: number, event: any) {
    const cantidad = Number(event.target.value);
    this.carritoService.actualizarCantidad(index, cantidad);
    this.productos = this.carritoService.obtenerProductos(); // refresca
  }

  // Calcular total
  calcularTotal() {
    return this.productos.reduce(
      (acc, p) => acc + p.precio * (p.cantidad || 1),
      0
    );
  }

  // Cambiar talla de producto
  cambiarTalla(index: number, nuevaTalla: string) {
    this.productos[index].tallaSeleccionada = nuevaTalla;
  }
}
