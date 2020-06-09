import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { RegisterRequest } from 'src/app/model/registerRequest';
import { RequestService } from 'src/app/services/request-service/request.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  constructor(private _requestService: RequestService) {

  }

  confirmedPass: string = "";
  request = new RegisterRequest("", "", "", "", "", "", "", "", "");
  passwordIsConfirmed = true;
  displaySuccessAlert: string;
  displayRejectRequestAlert: string;
  submitted = false;

  ngOnInit(): void { }

  onSubmitRequest() {
    this.displaySuccessAlert = undefined;
    this.displayRejectRequestAlert = undefined;
    this.submitted = true;

    if (this.request.password != this.confirmedPass) {
      this.passwordIsConfirmed = false;
    }
    else {
      this.passwordIsConfirmed = true;

      this._requestService.sendRegistrationRequest(this.request)
        .subscribe(data => {
          this.displaySuccessAlert = "You successfully send your registration request. Please, wait for our administrator to approve it. Response will be sent to your email address as soon as possible.";
        },
          error => {
            this.submitted = false;
            this.displayRejectRequestAlert = "This email address or policyholder is already in use. Please use another one.";
          });
    }
  }


}
