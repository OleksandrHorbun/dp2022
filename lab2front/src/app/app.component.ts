import { Component } from '@angular/core';
import { Weather } from './weather';

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

  id:number = 0;

  constructor(private service:MainLogicService) { }

  ngOnInit(): void {
    this.updateItems();
  }

  updateItems(){
    this.service.getItems().subscribe(
      (items)=>{
        this.itemsList=items;
        this.service.setList(items);
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
