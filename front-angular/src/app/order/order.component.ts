import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PaginationInstance} from "ngx-pagination";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit{
  orders : any;
  constructor(private http:HttpClient) {
    this.http.get("http://localhost:8080/order-service/orders").subscribe({
      next : (data) => {
        this.orders = data
      },
      error :() => {}
      // http://localhost:8080/order-service/orders/search/ByCustomerId?CustomerId=4&projection=fullOrder
    })
  }
  ngOnInit(): void {
  }



  detailsOfOrder(o: any) {

  }

  config: PaginationInstance = {
    id: 'custom',
    itemsPerPage: 10,
    currentPage: 1
  };



  onPageChange(pageNumber: number) {
    this.config.currentPage = pageNumber;
  }


}
