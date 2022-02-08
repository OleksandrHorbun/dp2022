import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Iweather } from '../interfaces/iweather';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  url:string = "/lab1/Servlet_first";  

  constructor(private http:HttpClient) { }

  getWeather():Observable<Iweather[]>{
    return this.http.get<Iweather[]>(this.url);
  }
}
