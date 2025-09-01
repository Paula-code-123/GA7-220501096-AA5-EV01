import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CarritoService {
  constructor() {}

  private productos: any[] = [];
  obtenerProductos() {
    return this.productos;
  }

  agregarProducto(producto: any) {
    this.productos.push(producto);
  }

  eliminarProducto(index: number) {
    this.productos.splice(index, 1);
  }

  actualizarCantidad(index: number, cantidad: number) {
    if (cantidad > 0) {
      this.productos[index].cantidad = cantidad;
    }
  }

  vaciarCarrito() {
    this.productos = [];
  }
}
