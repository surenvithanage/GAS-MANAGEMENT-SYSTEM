import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { ServiceService } from '../service.service';
import { ShopModel } from '../../models/shop.model';

@Component({
  selector: 'app-shop-management',
  templateUrl: './shop-management.component.html',
  styleUrls: ['./shop-management.component.scss']
})
export class ShopManagementComponent implements OnInit {
  @ViewChild('f')
  f: NgForm;

  @ViewChild('createModal') private createModal: TemplateRef<object>;

  @ViewChild('updateModal') private updateModal: TemplateRef<object>;

  
  public mainModel = new ShopModel('','','','', '', '');

  public mainUpdateModel = new ShopModel('','','','', '', '');

  public shopList: any = [];

  constructor(
    private service: ServiceService,
    private modalService: NgbModal,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.loadList();
  }

  
  loadList() {
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
    this.mainUpdateModel.name = payload.name;
    this.mainUpdateModel.location = payload.location;
    this.mainUpdateModel.telephone = payload.telephone;
    this.mainUpdateModel.userId = payload.userId;
    this.modalService.open(this.updateModal, {ariaLabelledBy: 'modal-basic-title', centered: true, backdrop: 'static'});
  }

  delete(id: any) {
    this.service.deleteShop(id).then(
      data => {
        this.loadList();
        this.toastr.success("Record Deleted Successfully.","Confirmation");
      }, err => {
        this.toastr.error("Error occurred while processing.","OOPS");
      }
    )
  }

  onSubmit() {
    this.mainModel.userId = localStorage.getItem('USER_ID');
    this.service.creatShop(this.mainModel).then(
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
    this.service.updateShop(this.mainUpdateModel.id, this.mainUpdateModel).then(
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
