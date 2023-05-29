import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginRequest } from '../models/login-request.model';
import { LoginServiceService } from '../service/login-service.service';
import { User } from '../models/user.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  request= new LoginRequest();

  loginForm: FormGroup;

  constructor(private formBuilder: FormBuilder,private loginService: LoginServiceService,private router: Router) { 
    this.loginForm = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  ngOnInit(): void {
    
  }

  submit() {
    if (this.loginForm.valid) {
      this.request.userName = this.loginForm.value.userName;
      this.request.password = this.loginForm.value.password;
      this.loginService.login(this.loginForm.value.userName, this.loginForm.value.password)
        .subscribe(response => {
          let user: User = response.body;
         // console.log(user);
          if (user) {
            this.router.navigateByUrl("/fundsList");
          } else {
            alert("Username Or Password incorrect");
          }
        },
        error => {
          
          alert("Username Or Password incorrect");
        });
    }
  }

}
