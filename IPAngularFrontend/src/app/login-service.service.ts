import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  isLogged:boolean;
  loggedUser:any;
  constructor() {
    this.loggedUser=null;
    this.isLogged=false;
   }

  login(user:any)
  {
    this.isLogged=true;
    this.loggedUser=user;
  }

  logout()
  {
    this.isLogged=false;
    this.loggedUser=null;
  }
}
