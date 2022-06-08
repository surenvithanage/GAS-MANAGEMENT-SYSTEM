export class ShopModel {
    public id: string;
    public name: string;
    public location: string;
    public telephone: string;
    public userId: string;
    public longitude: string;
    public latitude: string;
  
    public constructor(
        name: string,
        location: string,
        telephone: string,
        userId: string,
        latitude: string,
        longitude: string
    ) {
      this.name = name;
      this.location = location;
      this.telephone = telephone;
      this.userId = userId;
      this.latitude = latitude;
      this.longitude = longitude;
    }
  
  }
  