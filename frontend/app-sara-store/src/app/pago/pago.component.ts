import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-pago',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './pago.component.html',
  styleUrl: './pago.component.css',
})
export class PagoComponent {
  metodoSeleccionado: 'tarjeta' | 'nequi' | 'contraentrega' | null = null;
  formTarjeta!: FormGroup;
  pagoExitoso = false;
  pagoNequiConfirmado = false;
  pedidoContraentrega = false;

  constructor(private fb: FormBuilder) {
    this.formTarjeta = this.fb.group({
      numeroTarjeta: [
        '',
        [Validators.required, Validators.pattern(/^\d{16}$/)],
      ],
      nombre: ['', Validators.required],
      vencimiento: [
        '',
        [Validators.required, Validators.pattern(/^(0[1-9]|1[0-2])\/\d{2}$/)],
      ],
      cvv: ['', [Validators.required, Validators.pattern(/^\d{3,4}$/)]],
    });
  }

  // Seleccionar método de pago y resetear formularios y carrito
  seleccionarMetodo(metodo: 'tarjeta' | 'nequi' | 'contraentrega') {
    this.metodoSeleccionado = metodo;

    // resetear banderas
    this.pagoExitoso = false;
    this.pagoNequiConfirmado = false;
    this.pedidoContraentrega = false;

    if (metodo === 'contraentrega') {
      localStorage.removeItem('carrito');
      this.pedidoContraentrega = true;
    }
  }

  // Pagar con tarjeta remueve el carrito
  pagarConTarjeta() {
    if (this.formTarjeta.valid) {
      localStorage.removeItem('carrito');
      this.pagoExitoso = true;
    } else {
      this.formTarjeta.markAllAsTouched();
    }
  }

  confirmarNequi() {
    localStorage.removeItem('carrito');
    this.pagoNequiConfirmado = true;
  }
}
