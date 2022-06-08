import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserModel } from '../../../models/user.model';
import { ServiceService } from '../../service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  @ViewChild('f')
  f: NgForm;

  public userModel = new UserModel('','','','','','','','','');

  public CUSTOMER_ROLE_ID = '3';

  constructor(
    private service: ServiceService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    
  }

  onSubmit() {
    this.userModel.roleId = this.CUSTOMER_ROLE_ID;
    this.service.register(this.userModel).then(
      data => {
        this.toastr.success('Registered Successfully.', 'Confirmation');
        this.router.navigate(['/login']);
      }, err => {
        this.toastr.error('Error occurred while processing.', 'OOPS!');
      }
    )
  }
    

}
