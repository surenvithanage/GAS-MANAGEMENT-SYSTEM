import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { LoginModel } from '../../../models/login.model';
import { ServiceService } from '../../service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  @ViewChild('f')
  f: NgForm;

  public loginModel = new LoginModel('','');

  constructor(
    private service: ServiceService,
    private toastr: ToastrService,
    private router: Router
  ) { }

  onSubmit() {
    this.service.login(this.loginModel).then(
      data => {
        this.service.changePrivilege(data.roles[0]['name']);
        localStorage.setItem('USER_INFO', JSON.stringify(data));
        localStorage.setItem('USER_ID', JSON.stringify(data.id));
        localStorage.setItem('USER_ROLE', JSON.stringify(data.roles[0]['name']));
        this.toastr.success('Successfully Authenticated.', 'Confirmation');
        this.router.navigate(['/dashboard']);
      }, err => {
        this.toastr.error('Invalid Credentials.', 'OOPS!');
      }
    )
  }
    

}
