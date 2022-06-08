import { Component, OnInit, TemplateRef, ViewChild, ViewContainerRef } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { UserModel } from 'src/app/models/user.model';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent implements OnInit {
  @ViewChild('f')
  f: NgForm;

  @ViewChild('createModal') private createModal: TemplateRef<object>;

  @ViewChild('updateModal') private updateModal: TemplateRef<object>;

  public userModel = new UserModel('','','','','','','','','');

  public userUpdateModel = new UserModel('','','','','','','','','');

  public userList: any = [];

  constructor(
    private service: ServiceService,
    private modalService: NgbModal,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.loadUserList();
  }

  loadUserList() {
    this.service.userList().then(
      data => {
        this.userList = data;
      }
    )
  }

  openNewDialog() {
    this.modalService.open(this.createModal, {ariaLabelledBy: 'modal-basic-title', centered: true, backdrop: 'static'});
  }

  edit(payload: any) {
    this.userUpdateModel.id = payload.id;
    this.userUpdateModel.firstName = payload.firstName;
    this.userUpdateModel.lastName = payload.lastName;
    this.userUpdateModel.username = payload.username;
    this.userUpdateModel.email = payload.email;
    this.userUpdateModel.phone = payload.phone;
    this.userUpdateModel.nic = payload.nic;
    this.userUpdateModel.address = payload.address;
    this.userUpdateModel.roleId = payload.roles[0]['id'];
    this.modalService.open(this.updateModal, {ariaLabelledBy: 'modal-basic-title', centered: true, backdrop: 'static'});
  }

  delete(id: any) {
    this.service.deleteUser(id).then(
      data => {
        this.loadUserList();
        this.toastr.success("Record Deleted Successfully.","Confirmation");
      }, err => {
        this.toastr.error("Error occurred while processing.","OOPS");
      }
    )
  }

  onSubmit() {
    this.service.creatUser(this.userModel).then(
      data => {
        this.modalService.dismissAll();
        this.loadUserList();
        this.toastr.success('Created Successfully.', 'Confirmation');
      }, err => {
        this.toastr.error('Error occurred while processing.', 'OOPS!');
      }
    )
  }

  onUpdate() {
    this.service.updateUser(this.userUpdateModel.id, this.userUpdateModel).then(
      data => {
        this.modalService.dismissAll();
        this.loadUserList();
        this.toastr.success('Updated Successfully.', 'Confirmation');
      }, err => {
        this.toastr.error('Error occurred while processing.', 'OOPS!');
      }
    )
  }
}
