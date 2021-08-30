import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginServiceService } from '../login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  readonly LOGIN_URL = 'http://localhost:9000/login';
  validLogin:boolean;
  constructor(private fb: FormBuilder, private router: Router, private http: HttpClient, private loginService: LoginServiceService) {
    this.validLogin=false;
   }


  loginForm: FormGroup;

  ngOnInit(): void {
    this.initializeForm();
  }

  initializeForm():void{
    this.loginForm = this.fb.group(
      {
        username:'',
        password:''
      }
    );
  }

  async onSubmit()
  {
    let response:any;
    response = await this.http.post(this.LOGIN_URL, this.loginForm.value).toPromise();
    if(response!==null)
    {
      this.loginService.login(response);
      this.validLogin=false;
      this.router.navigate(['/']);
    }
    else
    {
      this.validLogin=true;
    }
    
  }

}
