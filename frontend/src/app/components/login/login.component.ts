import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  simpleForm: FormGroup;

  constructor(public fb: FormBuilder) {
    this.simpleForm = fb.group({
      simpleFormEmailEx: ['', [Validators.required, Validators.email]],
      simpleFormPasswordEx: ['', Validators.required],
    });
   }

  ngOnInit(): void {
  }

}
