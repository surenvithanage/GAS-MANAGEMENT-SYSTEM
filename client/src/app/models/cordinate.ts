export class CordinateModel {
    public lat: number;
    public lng: number;
    public label: string;
  
    public constructor(
        lng: number,
        lat: number,
        label: string
    ) {
      this.lat = lat;
      this.lng = lng;
      this.label = label;
    }
  
  }
  