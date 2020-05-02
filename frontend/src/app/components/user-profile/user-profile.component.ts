import { Component, OnInit } from '@angular/core';
import { IUserProfile, UserProfile } from 'src/app/model/userProfile';
import { UserProfileService } from 'src/app/services/user-profile-service/user-profile.service';
import { UserPassword, IUserPassword } from 'src/app/model/userPassword';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  user: IUserProfile = new UserProfile(0,"","","", "", "", "", "", "");
  userPassword: IUserPassword = new UserPassword(0, "", "", "");

  constructor(
    private _httpUserService: UserProfileService
  ) { }

  ngOnInit(): void {
    this._httpUserService.getUserData().subscribe(response => this.user = response);
  }

}
