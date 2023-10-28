import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomerComponent} from "./customer/customer.component";
import {ProductsComponent} from "./products/products.component";
import {OrderComponent} from "./order/order.component";
import {CustomerOrdersComponent} from "./customer-orders/customer-orders.component";


const routes: Routes = [
  { path : "customers" , component : CustomerComponent },
  { path : "products" , component : ProductsComponent },
  { path : "orders" , component : OrderComponent},
  { path : "orders/:customerId" ,component : CustomerOrdersComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
