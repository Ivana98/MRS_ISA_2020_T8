import { Component, OnInit } from '@angular/core';
import { IUserProfile, UserProfile } from 'src/app/model/userProfile';
import { UserProfileService } from 'src/app/services/user-profile-service/user-profile.service';
import { UserPassword, IUserPassword } from 'src/app/model/userPassword';
import { FormGroup, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  user = new UserProfile(0,"","","", "", "", "", "", "lo");
  userPassword: IUserPassword = new UserPassword(0, "", "", "");
  currentPasswordMatched : boolean = true;
  passwordConfirmed : boolean = true;
  changeDataSuccess: any; //boolean
  changePasswordSuccess:any; //boolean

  constructor(
    private _httpUserService: UserProfileService
  ) { }

  ngOnInit(): void {
    //this._httpUserService.getUserData().subscribe(response => this.user = response);
  }

  saveChanges(event){
    this._httpUserService.setUserData(this.user)
        .subscribe( data => {
          this.changeDataSuccess = data;
        });
  }

  changePass(event){
    console.log(this.userPassword);
    if(this.userPassword.password != this.user.password){
      this.currentPasswordMatched = false;
    }
    else {
      this.currentPasswordMatched = true;
    }
    if(this.userPassword.newPassword != this.userPassword.confirmedPassword){
      this.passwordConfirmed = false;
    }
    else{
      this.passwordConfirmed = true;
    }
    if(this.currentPasswordMatched && this.passwordConfirmed){
      this._httpUserService.setUserPassword(this.userPassword)
        .subscribe( data => {
          this.changePasswordSuccess = data;
        });
      //ispisati da je uspesno
      //isprazniti polja
    }

  }

}
