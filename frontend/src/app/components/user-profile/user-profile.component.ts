import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { IUserProfile, UserProfile } from 'src/app/model/userProfile';
import { UserProfileService } from 'src/app/services/user-profile-service/user-profile.service';
import { UserPassword, IUserPassword } from 'src/app/model/userPassword';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import { LoginService } from 'src/app/services/login-service/login.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  user = new UserProfile(1, "", "", "", "", "", "", "", "");
  userPassword = new UserPassword("", "", "");
  passwordConfirmed : boolean = true;
  changeDataSuccess: any; //boolean
  changePasswordMsg : string; //boolean
  displayPasswordAlertMsg: string = undefined;
  displayDataAlertMsg: string = undefined;

  constructor(private _httpUserService: UserProfileService, private _loginService: LoginService) { }

  ngOnInit(): void {
    this.user = this._loginService.currentUser;
  }

  saveChanges(event){
    this._httpUserService.setUserData(this.user)
        .subscribe( data => {
          this.changeDataSuccess = data;
        });
  }

  onSubmitData(){

  }

  onSubmitPassword(){
    this.changePasswordMsg = undefined;
    this.displayPasswordAlertMsg = undefined;
    this.displayDataAlertMsg = undefined;

    if(this.userPassword.newPassword != this.userPassword.confirmedPassword){
      this.passwordConfirmed = false;
    }
    else{
      this.passwordConfirmed = true;

      this._httpUserService.setUserPassword(this.userPassword)
        .subscribe( data => {
          this.displayPasswordAlertMsg = "You successfully changed your password.";
        },
        error => {
          this.changePasswordMsg = "This password does not match with your current password.";
      });
    }
  }

}
