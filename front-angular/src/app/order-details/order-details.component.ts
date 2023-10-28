import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {
  orders: any; // Store the order data
  customerId: number;

  constructor(private http: HttpClient, private route: ActivatedRoute) {
    this.customerId = route.snapshot.params["customerId"];
  }

  ngOnInit(): void {
    this.http.get("http://localhost:8080/order-service/orders/search/ByCustomerId?projection=fullOrder&CustomerId=" + this.customerId)
      .subscribe((response: any) => {
        this.orders = response._embedded.orders; // Assuming the orders are stored as an array
      });
  }

  getStatusClass(status: string) {
    switch (status) {
      case 'DELIVERED':
        return 'delivered';
      case 'PENDING':
        return 'pending';
      case 'REGISTRED':
        return 'registered';
      case 'CANCELED':
        return 'canceled';
      default:
        return '';
    }
  }
}
