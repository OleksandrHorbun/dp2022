import { Component } from '@angular/core';
import { Iweather } from './interfaces/iweather';
import { HttpService } from './services/httpservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {

  title = "lab1front";
  router: any;
  
}
