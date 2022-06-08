import { Component } from '@angular/core';

import { navItems } from './_nav';
import { navItemsShop } from './_nav';
import { navItemsCustomer } from './_nav';

@Component({
  selector: 'app-dashboard',
  templateUrl: './default-layout.component.html',
})
export class DefaultLayoutComponent {

  public navItems = navItems;
  public navItemShop = navItemsShop;
  public navItemCustomer = navItemsCustomer;

  public loggedAdmin: boolean;
  public loggedShop: boolean;
  public loggedCustomer: boolean;

  public perfectScrollbarConfig = {
    suppressScrollX: true,
  };

  constructor(
  ) {
    if (localStorage.getItem('USER_ROLE') === '"ADMIN"') {
      this.loggedAdmin = true;
      this.loggedShop = false;
      this.loggedCustomer = false;
    } else if (localStorage.getItem('USER_ROLE') === '"SHOP"') {
      this.loggedAdmin = false;
      this.loggedShop = true;
      this.loggedCustomer = false;
    } else if (localStorage.getItem('USER_ROLE') === '"CUSTOMER"') {
      this.loggedAdmin = false;
      this.loggedShop = false;
      this.loggedCustomer = true;
    } else {
      this.loggedAdmin = false;
      this.loggedShop = false;
      this.loggedCustomer = false;
    }
  }

}
