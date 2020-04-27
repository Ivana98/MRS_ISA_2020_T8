import { Component } from '@angular/core';
import { NgwWowService } from 'ngx-wow';
import { SomeLogicService } from './some-logic.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  constructor(private wowService: NgwWowService,private _someLogic: SomeLogicService) {
    this.wowService.init();
  }

  sentUser() {
    this._someLogic.sentType('Good Morning');
  }

}
