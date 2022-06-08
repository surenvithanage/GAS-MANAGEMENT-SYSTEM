export class StockModel {
    public id: string;
    public type: string;
    public quantity: string;
    public shopId: string;
  
    public constructor(
        type: string,
        quantity: string,
        shopId: string
    ) {
      this.type = type;
      this.quantity = quantity;
      this.shopId = shopId;
    }
  
  }
  