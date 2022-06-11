import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Weather } from './weather';

@Injectable({
  providedIn: 'root'
})
export class MainLogicService {
  list = new BehaviorSubject<Weather[]>([])
  // url:string="http://localhost:4200/weather"
  url:string="http://localhost:8080/lab3/Servlet_first"

  constructor(private http:HttpClient) { }

  getItems():Observable<Weather[]>{
    return this.http.get<Weather[]>(this.url);
  }

  postItem(weather:Weather):Observable<Weather[]>{
    return this.http.post<Weather[]>(this.url, weather);
  }

  putItem(weather:Weather):Observable<Weather[]>{
    return this.http.put<Weather[]>(this.url+"/"+weather.id,weather);
  }

  deleteItem(weather:Weather):Observable<Weather[]>{
    return this.http.delete<Weather[]>(this.url+"/"+weather.id);
  }

  setList(list:Weather[]){
    this.list.next(list);
  }



  public inputs:string[] = ["", "", ""]
}
