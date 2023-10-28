import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{
  products  : any;

  constructor(private http:HttpClient) {
    this.http.get("http://localhost:8080/inventory-service/products?projection=fullProduct").subscribe({
      next : (data) => {
        this.products = data;
      },
      error : () => {}
    })
  }

  ngOnInit(): void {
    // this.http.get("http://localhost:8080/customer-service/customers").subscribe(  {
    //   next : (data) =>{
    //     this.
    //   },
    //   error : () => {}
    //
    // });

  }

  updateProduct(p: any) {

  }

  deleteProduct(p: any) {

  }
}
