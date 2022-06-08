import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { CordinateModel } from '../../models/cordinate';

@Component({
  templateUrl: 'dashboard.component.html',
  styleUrls: ['dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  lat = 6.939339630537849;
  long = 80.7718;
  zoom = 8;

  public model = new CordinateModel(0,0, '');

  markers = [];

  public shopList: any = [];

  constructor(
    private service: ServiceService
  ) {
  }

  ngOnInit(): void {
    this.loadShopsWithAvailableStocks();
  }

  loadShopsWithAvailableStocks() {
    this.service.shopList().then(
      data => {
        this.shopList = data;
        for (let i = 0; i < this.shopList.length; i++) {
          this.model = new CordinateModel(0,0, '');
          this.model.lng = Number(this.shopList[i]['longitude']);
          this.model.lat = Number(this.shopList[i]['latitude']);
          this.model.label = this.shopList[i]['location'] + ' - ' + this.shopList[i]['name'];
          this.markers.push(this.model);
        }
        console.log(JSON.stringify(this.markers));
      }
    )
  }

}
