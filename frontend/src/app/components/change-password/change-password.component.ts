import { Component, OnInit } from '@angular/core';
import { UserProfile } from 'src/app/model/userProfile';
import { UserPassword } from 'src/app/model/userPassword';
import { UserProfileService } from 'src/app/services/user-profile-service/user-profile.service';
import { LoginService } from 'src/app/services/login-service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  user = new UserProfile(1, "", "", "", "", "", "", "", "");
  userPassword = new UserPassword("", "", "");
  passwordConfirmed : boolean = true;
  changeDataSuccess: any; //boolean
  changePasswordMsg : string; //boolean
  displayPasswordAlertMsg: string = undefined;
  displayDataAlertMsg: string = undefined;

  constructor(private _httpUserService: UserProfileService, private _loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  /**
   * 
   */
  onSubmitPassword(){
    this.changePasswordMsg = undefined;
    this.displayPasswordAlertMsg = undefined;

    if(this.userPassword.newPassword != this.userPassword.confirmedPassword){
      this.passwordConfirmed = false;
    }
    else{
      this.passwordConfirmed = true;

      this._httpUserService.setUserPassword(this.userPassword)
        .subscribe( data => {
          this.displayPasswordAlertMsg = "You successfully changed your password.";
          this.router.navigate(['/user-page']);
        },
        error => {
          this.changePasswordMsg = "This password does not match with your current password.";
      });
    }
  }

}
