import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Weather } from './weather';
import { Rest1 } from './rest1';

@Injectable({
  providedIn: 'root'
})
export class MainLogicService {
  list = new BehaviorSubject<Weather[]>([])
  // url:string="http://localhost:4200/weather"
  //url:string="http://localhost:8080/lab3/Servlet_first"
  url:string="http://localhost:1155/weather"

  constructor(private http:HttpClient) { }

  getItems():Observable<Rest1>{
    return this.http.get<Rest1>(this.url);
  }

  postItem(weather:Weather):Observable<Weather[]>{
    return this.http.post<Weather[]>(this.url, weather);
  }

  putItem(weather:Weather):Observable<Weather[]>{
    return this.http.put<Weather[]>(this.url+"/"+weather._links.wweather.href,weather);
  }

  deleteItem(weather:Weather):Observable<Weather[]>{
    return this.http.delete<Weather[]>(weather._links.wweather.href);
  }

  setList(list:Weather[]){
    this.list.next(list);
  }



  public inputs:string[] = ["", "", ""]
}
