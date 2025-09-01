import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-realizar-compra',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule, ReactiveFormsModule],
  templateUrl: './realizar-compra.component.html',
  styleUrl: './realizar-compra.component.css',
})
export class RealizarCompraComponent {
  formEnvio!: FormGroup;

  constructor(private fb: FormBuilder, private router: Router) {}

//Inicialización del formulario
  ngOnInit(): void {
    this.formEnvio = this.fb.group({
      nombre: ['', Validators.required],
      celular: ['', Validators.required],
      tipoDoc: ['', Validators.required],
      numDoc: ['', Validators.required],
      departamento: ['', Validators.required],
      municipio: ['', Validators.required],
      direccion: ['', Validators.required],
    });
  }

  //Dirige a pagar
  onSubmit(): void {
    this.router.navigate(['/pago']);
  }
}
