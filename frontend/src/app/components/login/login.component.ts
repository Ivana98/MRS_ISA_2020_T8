import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { IUserLogin, UserLogin } from 'src/app/model/userLogin';
import { LoginService } from 'src/app/services/login-service/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  //simpleForm: FormGroup;
  user : IUserLogin = new UserLogin("", "");
  response : any;
/*
  constructor(public fb: FormBuilder) {
    this.simpleForm = fb.group({
      simpleFormEmailEx: ['', [Validators.required, Validators.email]],
      simpleFormPasswordEx: ['', Validators.required],
    });
   }*/
   constructor(private httpService: LoginService) {}

  ngOnInit(): void {
  }

  loginClicked() {
    console.log("Request sent!");
    console.log(this.user);

    this.httpService.userLogin(this.user)
      .subscribe(
        data => {
          this.response = data;
          console.log(this.response);
        }
      )
  }

}
