export class OrderModel {
    public id: string;
    public shopId: string;
    public userId: string;
    public email: string;
    public mobileNumber: string;
    public quantity: string;
  
    public constructor(
        shopId: string,
        userId: string,
        email: string,
        mobileNumber: string,
        quantity: string
    ) {
      this.shopId = shopId;
      this.userId = userId;
      this.email = email;
      this.mobileNumber = mobileNumber;
      this.quantity = quantity;
    }
  
  }
  