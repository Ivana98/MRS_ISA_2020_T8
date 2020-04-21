import { Component, OnInit } from '@angular/core';
import {IAdmin , Admin} from 'src/app/model/admin';
import { AdminServiceService } from 'src/app/services/admin-service/admin-service.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  adm: IAdmin = new Admin("","");

  public adminAr:Array<IAdmin> = new Array<IAdmin>();

  constructor(
    private AdminServiceService: AdminServiceService
  ) { }

  ngOnInit(): void {
  }

  saveAdmin(namee:string  , pass: string):void{
    this.adm.name = namee;
    this.adm.pass = pass;
    this.saveChanges();
    this.AdminServiceService.getAll().subscribe(response =>this.adminAr= response);
    /*for(let adm of this.adminAr){
      console.log(adm)
    }*/
    // console.log(this.adminAr.length)
  }

  saveChanges(): void {
    // console.log(this.adm.name);
    // console.log(this.adm.pass);
    this.AdminServiceService.addOne(this.adm).subscribe( data => {
      alert("Changes saved!");
    });;

  };

}
