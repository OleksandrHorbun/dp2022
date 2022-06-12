export interface Weather {

  id:number;
  city:string;
  date:string;
  temp:number; //double
  temp_min:number; //double
  temp_max:number; //double
  feels_like:number; //double
  description:string;
  "link" : string;
  "_links" : {
    "self" : {
      "href" : string;
    },
    "wweather" : {
      "href" : string;
    }
  }
}