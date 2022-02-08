import { Component, OnInit } from '@angular/core';
import { Iweather } from '../interfaces/iweather';
import { HttpService } from '../services/httpservice.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.sass']
})
export class MainPageComponent implements OnInit {

  title = "lab1front";
  weatherList:Iweather[] = [];

  constructor(private service:HttpService) { }

  getWeather():void{
    this.service.getWeather().subscribe(
      (weathers) => {
        this.weatherList = weathers;
      }
    );
  }

  ngOnInit(): void {
  }

}
