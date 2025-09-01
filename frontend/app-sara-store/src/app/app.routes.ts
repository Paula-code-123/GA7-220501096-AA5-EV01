import { Routes } from '@angular/router';
import { CarritoComponent } from './carrito/carrito.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

import { RegisterComponent } from './register/register.component';
import { RealizarCompraComponent } from './realizar-compra/realizar-compra.component';
import { PagoComponent } from './pago/pago.component';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent },
  { path: 'carrito', component: CarritoComponent },
  { path: 'realizar-compra', component: RealizarCompraComponent },
  { path: 'pago', component: PagoComponent },
];
