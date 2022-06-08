import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  login_url: string;
  register_url: string;
  user_list_url: string;
  shop_list_url: string;
  order_list_url: string;
  order_list_user_url: string;
  stock_list_url: string;

  user_create_url: string;
  user_update_url: string;
  user_delete_url: string;

  order_create_url: string;
  order_update_url: string;
  order_delete_url: string;

  shop_create_url: string;
  shop_update_url: string;
  shop_delete_url: string;

  stock_create_url: string;
  stock_update_url: string;
  stock_delete_url: string;

  public privilegeType = new BehaviorSubject<any>('ADMIN');
  cast = this.privilegeType.asObservable();

  constructor(
    public http: HttpClient
  ) {
    this.login_url = `http://localhost:8080/auth/login`;
    this.register_url = `http://localhost:8080/auth/register`;
    this.user_list_url = `http://localhost:8080/user`;
    this.shop_list_url = `http://localhost:8080/shop`;
    this.order_list_url = `http://localhost:8080/order`;
    this.order_list_user_url = `http://localhost:8080/order/find/user/`;
    this.stock_list_url = `http://localhost:8080/stock`;

    this.user_create_url = `http://localhost:8080/user`;
    this.user_update_url = `http://localhost:8080/user`;
    this.user_delete_url = `http://localhost:8080/user`;
    
    this.order_create_url = `http://localhost:8080/order`;
    this.order_update_url = `http://localhost:8080/order`;
    this.order_delete_url = `http://localhost:8080/order`;
    
    this.stock_create_url = `http://localhost:8080/stock`;
    this.stock_update_url = `http://localhost:8080/stock`;
    this.stock_delete_url = `http://localhost:8080/stock`;
    
    this.shop_create_url = `http://localhost:8080/shop`;
    this.shop_update_url = `http://localhost:8080/shop`;
    this.shop_delete_url = `http://localhost:8080/shop`;
  }

  changePrivilege(type: any){
    this.privilegeType.next(type);
  }

  creatShop(payload: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.post(`${this.shop_create_url}`, payload).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  updateShop(id: any, payload: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.put(`${this.shop_update_url}/` + id, payload).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  deleteShop(id: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.delete(`${this.shop_delete_url}/` + id).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  creatStock(payload: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.post(`${this.stock_create_url}`, payload).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  updateStock(id: any, payload: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.put(`${this.stock_update_url}/` + id, payload).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  deleteStock(id: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.delete(`${this.stock_delete_url}/` + id).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  creatOrder(payload: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.post(`${this.order_create_url}`, payload).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  updateOrder(id: any, payload: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.put(`${this.order_update_url}/` + id, payload).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  deleteOrder(id: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.delete(`${this.order_delete_url}/` + id).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  creatUser(user: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.post(`${this.user_create_url}`, user).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  updateUser(userId: any, user: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.put(`${this.user_update_url}/` + userId, user).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  deleteUser(userId: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.delete(`${this.user_delete_url}/` + userId).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  login(model: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.post(`${this.login_url}`, model).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  register(model: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.post(`${this.register_url}`, model).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  userList() {
    return new Promise((resolve, reject) => {
      this.http.get(`${this.user_list_url}`).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  shopList() {
    return new Promise((resolve, reject) => {
      this.http.get(`${this.shop_list_url}`).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  orderList() {
    return new Promise((resolve, reject) => {
      this.http.get(`${this.order_list_url}`).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  orderListByUser(id) {
    return new Promise((resolve, reject) => {
      this.http.get(`${this.order_list_user_url}` + Number(id)).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }

  stockList() {
    return new Promise((resolve, reject) => {
      this.http.get(`${this.stock_list_url}`).subscribe(
        data => {
          return resolve(data);
        },
        err => {
          return reject(err);
        }
      );
    });
  }
}
