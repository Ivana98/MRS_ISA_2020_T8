import { Component, OnInit } from '@angular/core';
import { TransferPatientService } from 'src/app/services/transfer-patient-service/transfer-patient.service';
import { Patient } from 'src/app/model/patient';
import { ExaminationService } from 'src/app/services/examination-service/examination.service';
import { ExaminationRequest } from 'src/app/model/examinationRequest';

@Component({
  selector: 'app-start-examination',
  templateUrl: './start-examination.component.html',
  styleUrls: ['./start-examination.component.css']
})
export class StartExaminationComponent implements OnInit {

  patient: Patient = new Patient(-1, "","","","","","","","","","","","","","","");
  examinationRequest: ExaminationRequest = new ExaminationRequest(-1, -1, this.patient.id, "EXAMINATION", null);

  date = new Date();
  time: string;

  constructor(
    private _transferService: TransferPatientService,
    private _httpExaminationService: ExaminationService
  ) { }

  ngOnInit(): void {

    // Save patient from previous component
    this._transferService.patient$.subscribe(data => {
      this.patient = data;
    });
  }

  /**
   * Take date from date input on click.
   * 
   * @param event is choosen date
   */
  public onDate(event): void {
    this.date = event;
    console.log("Datum: " + this.date);
  }

  /**
   * Set new choosen intervention type.
   * 
   * @param data is intervention type
   */
  onChange(data){
    this.examinationRequest.interventionType = data;
  }

  /**
   * Send examination request.
   */
  sendExaminationRequest() {

    this.date.setHours(Number(this.time.substring(0,2)));
    this.date.setMinutes(Number(this.time.substring(3,5)));
    this.date.setSeconds(0);

    this.examinationRequest.date = this.date;
    this.examinationRequest.patientId = this.patient.id;

    this._httpExaminationService.sendExaminationRequest(this.examinationRequest)
      .subscribe(response => {
        if (response != null) alert("You successfuly sent request.");
        else alert("Doctor is bussy at this time.");
      });
  }

}
