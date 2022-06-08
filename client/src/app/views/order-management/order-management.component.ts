import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { ServiceService } from '../service.service';
import { OrderModel } from '../../models/order.model';

@Component({
  selector: 'app-order-management',
  templateUrl: './order-management.component.html',
  styleUrls: ['./order-management.component.scss']
})
export class OrderManagementComponent implements OnInit {
  @ViewChild('f')
  f: NgForm;

  @ViewChild('createModal') private createModal: TemplateRef<object>;

  @ViewChild('updateModal') private updateModal: TemplateRef<object>;

  public mainModel = new OrderModel('', '', '', '', '');

  public mainUpdateModel = new OrderModel('', '', '', '', '');

  public orderList: any = [];
  public shopList: any = [];

  constructor(
    private service: ServiceService,
    private modalService: NgbModal,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.mainModel.quantity = '1 Gas Cylinder';
    this.loadList();
  }

  loadList() {
    if (localStorage.getItem('USER_ROLE') === '"CUSTOMER"' ) {
      this.service.orderListByUser(localStorage.getItem('USER_ID')).then(
        data => {
          this.orderList = data;
        }
      )
    } else {
     this.service.orderList().then(
        data => {
          this.orderList = data;
        }
      )
    } 
  

    this.service.shopList().then(
      data => {
        this.shopList = data;
      }
    )
  }

  openNewDialog() {
    this.modalService.open(this.createModal, { ariaLabelledBy: 'modal-basic-title', centered: true, backdrop: 'static' });
  }

  edit(payload: any) {
    this.mainUpdateModel.id = payload.id;
    this.mainUpdateModel.shopId = payload.shopId;
    this.mainUpdateModel.userId = payload.userId;
    this.mainUpdateModel.email = payload.email;
    this.mainUpdateModel.mobileNumber = payload.mobileNumber;
    this.mainUpdateModel.quantity = payload.quantity;
    this.modalService.open(this.updateModal, { ariaLabelledBy: 'modal-basic-title', centered: true, backdrop: 'static' });
  }

  delete(id: any) {
    this.service.deleteOrder(id).then(
      data => {
        this.loadList();
        this.toastr.success("Record Deleted Successfully.", "Confirmation");
      }, err => {
        this.toastr.error("Error occurred while processing.", "OOPS");
      }
    )
  }

  onSubmit() {
    this.mainModel.quantity = '1';
    this.mainModel.userId = localStorage.getItem('USER_ID');
    this.service.creatOrder(this.mainModel).then(
      data => {
        this.modalService.dismissAll();
        this.loadList();
        this.toastr.success('Created Successfully.', 'Confirmation');
      }, err => {
        this.toastr.error('Error occurred while processing.', 'OOPS!');
      }
    )
  }

  onUpdate() {
    this.service.updateOrder(this.mainUpdateModel.id, this.mainUpdateModel).then(
      data => {
        this.modalService.dismissAll();
        this.loadList();
        this.toastr.success('Updated Successfully.', 'Confirmation');
      }, err => {
        this.toastr.error('Error occurred while processing.', 'OOPS!');
      }
    )
  }

}
