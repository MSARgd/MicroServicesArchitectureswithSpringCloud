import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit{
  customers :  any;
  constructor(private http:HttpClient,private  router : Router) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8080/customer-service/customers?projection=fullCustomer").subscribe({
      next : (data) => {
        this.customers = data;
      },
      error : () => {}
    })
  }



  getOrders(c: any) {
    this.router.navigateByUrl("/orders/"+c.id);

  }
}
