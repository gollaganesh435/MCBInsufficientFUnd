import { Component } from '@angular/core';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'MCB Insufficient funds';
  constructor(public router : Router){

    
  }
  ngOnInit(): void {
  //   if(this.router.url === "/"){
     
  //     this.router.navigateByUrl("/login");
  //   }
  }

}
