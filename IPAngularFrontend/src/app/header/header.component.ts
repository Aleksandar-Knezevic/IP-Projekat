import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from '../login-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public loginService: LoginServiceService, private router:Router) { }

  ngOnInit(): void {
  }

   logout()
  {
    this.loginService.logout();
    this.router.navigate(['/login']);
  }

}
