import { Component, OnInit } from '@angular/core';
import { ClinicService } from 'src/app/services/clinic-service/clinic.service';

@Component({
  selector: 'app-display-report',
  templateUrl: './display-report.component.html',
  styleUrls: ['./display-report.component.css']
})
export class DisplayReportComponent implements OnInit {

  averageMark: number = 123;

  constructor(
    private _httpClinicService: ClinicService
  ) { }

  ngOnInit(): void {
    this.loadClinicAverageMark();
  }

  loadClinicAverageMark() {
    this._httpClinicService.getClinicAverageMark()
      .subscribe(mark => {
        this.averageMark = mark;
      });
  }

}
