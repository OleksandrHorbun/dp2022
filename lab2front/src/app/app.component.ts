import { Component } from '@angular/core';
import { Weather } from './weather';
import { Rest1 } from './rest1';

import { MainLogicService } from './main-logic.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {

  title:string="lab2front";
  itemsList:Weather[]=[];
  showForms:boolean=false;
  selectedItem?:Weather;
  id:number = 1;

  constructor(private service:MainLogicService) { }

  ngOnInit(): void {
    this.updateItems();
  }

  updateItems(){
    this.service.getItems().subscribe(
      (Rest1)=>{
        this.itemsList = Rest1._embedded.weathers;
      }
    );
  }

  addItem(item:Weather){
    this.service.postItem(item).subscribe(
      (item)=>{
        this.updateItems();
      }
    );
  }

  updateItem(item:Weather){
    
    item._links =this.selectedItem?._links!;

      this.service.putItem(item).subscribe(
      ()=>{
        this.updateItems();      
      }
    );

  }

  onSelect(item:Weather){
    console.log(item);
    if(this.selectedItem && item.id==this.selectedItem.id){
      this.selectedItem=undefined;
    } else {
      this.selectedItem=item;
    }
  }

  deleteItem(item:Weather){
    this.service.deleteItem(item).subscribe(
      ()=>{
        this.updateItems();

      }
    );
  }
  }
