import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { ServiceService } from '../service.service';
import { StockModel } from '../../models/stock.model';

@Component({
  selector: 'app-stock-management',
  templateUrl: './stock-management.component.html',
  styleUrls: ['./stock-management.component.scss']
})
export class StockManagementComponent implements OnInit {
  @ViewChild('f')
  f: NgForm;

  @ViewChild('createModal') private createModal: TemplateRef<object>;

  @ViewChild('updateModal') private updateModal: TemplateRef<object>;

  public mainModel = new StockModel('','','');

  public mainUpdateModel = new StockModel('','','');

  public stockList: any = [];
  public shopList: any = [];

  constructor(
    private service: ServiceService,
    private modalService: NgbModal,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.loadStockList();
  }

  loadStockList() {
    this.service.stockList().then(
      data => {
        this.stockList = data;
      }
    )
    this.service.shopList().then(
      data => {
        this.shopList = data;
      }
    )
  }

  openNewDialog() {
    this.modalService.open(this.createModal, {ariaLabelledBy: 'modal-basic-title', centered: true, backdrop: 'static'});
  }

  edit(payload: any) {
    this.mainUpdateModel.id = payload.id;
    this.mainUpdateModel.type = payload.type;
    this.mainUpdateModel.quantity = payload.quantity;
    this.mainUpdateModel.shopId = payload.shopId;
    this.modalService.open(this.updateModal, {ariaLabelledBy: 'modal-basic-title', centered: true, backdrop: 'static'});
  }

  delete(id: any) {
    this.service.deleteStock(id).then(
      data => {
        this.loadStockList();
        this.toastr.success("Record Deleted Successfully.","Confirmation");
      }, err => {
        this.toastr.error("Error occurred while processing.","OOPS");
      }
    )
  }

  onSubmit() {
    this.service.creatStock(this.mainModel).then(
      data => {
        this.modalService.dismissAll();
        this.loadStockList();
        this.toastr.success('Created Successfully.', 'Confirmation');
      }, err => {
        this.toastr.error('Error occurred while processing.', 'OOPS!');
      }
    )
  }

  onUpdate() {
    this.service.updateStock(this.mainUpdateModel.id, this.mainUpdateModel).then(
      data => {
        this.modalService.dismissAll();
        this.loadStockList();
        this.toastr.success('Updated Successfully.', 'Confirmation');
      }, err => {
        this.toastr.error('Error occurred while processing.', 'OOPS!');
      }
    )
  }
}
