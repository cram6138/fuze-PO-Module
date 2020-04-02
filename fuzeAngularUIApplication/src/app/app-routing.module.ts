import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './components/home/home.component';
import { PurchaseOrderComponent } from './components/purchase-order/purchase-order.component';
import { PurchaseOrderReservationComponent } from './components/purchase-order-reservation/purchase-order-reservation.component';


const routes: Routes = [
  {path: '**', component:LoginComponent},
  {path: '/purchase-order', component:PurchaseOrderComponent},
  {path: 'purchase-order-reservation', component:PurchaseOrderReservationComponent},
  {path: '/home', component:HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
