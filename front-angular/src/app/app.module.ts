import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import {HttpClientModule} from "@angular/common/http";
import { CustomerComponent } from './customer/customer.component';
import { OrderComponent } from './order/order.component';
import {NgxPaginationModule} from "ngx-pagination";
import { CustomerOrdersComponent } from './customer-orders/customer-orders.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    CustomerComponent,
    OrderComponent,
    CustomerOrdersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
