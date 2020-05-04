import { Component, OnInit } from '@angular/core';
import { ExaminationType } from 'src/app/model/examinationType';
import { ExaminationTypeService } from 'src/app/services/examination-type/examination-type.service';

@Component({
  selector: 'app-add-examination-type',
  templateUrl: './add-examination-type.component.html',
  styleUrls: ['./add-examination-type.component.css']
})
export class AddExaminationTypeComponent implements OnInit {

  labelValue: 'Operation' | 'Examination' = 'Examination';

  duration = 
  [
    '00:05',
    '00:10',
    '00:15',
    '00:20',
    '00:25',
    '00:30',
    '00:40',
    '00:50',
    '01:00',
    '01:15',
    '01:30',
    '01:45',
    '02:00',
    '02:30',
    '03:00',
    '03:30',
    '04:00',
    '04:30',
    '05:00',
    '06:00',
    '07:00',
    '08:00',
    '09:00',
    '10:00',
    '11:00',
    '12:00',
    '13:00',
    '14:00',
    '15:00',
    '16:00',
    '17:00',
    '18:00',
    '19:00',
    '20:00',
    '21:00',
    '22:00',
    '23:00',
    '24:00'
  ];
  public examination_type: ExaminationType = new ExaminationType(0, "", this.labelValue, "");
  specialisations: string[] = 
  [
    'OPHTALMOLOGY',
    'CARDIOLOGY',
    'LABORATORY',
    'PULMONOLOGY',
    'SYSTEMATIC_REVIEW',
    'GYNECOLOGY',
    'PSYHOLOGY',
    'OTOLARYNGOLOGY',
    'INTERNIST'
  ];

  constructor(
    private httpExeminationTypeService: ExaminationTypeService
  ) { }

  ngOnInit(): void {
  }

  addExaminationType(): void {
    
    if (this.examination_type.filled()) {
      // console.log("ve popunjeno");
      // console.log(this.examination_type.duration)
      // console.log(this.examination_type.interventionType)
      // console.log(this.examination_type.price)
      // console.log(this.examination_type.specialisation)
      this.httpExeminationTypeService.addExaminationType(this.examination_type)
      .subscribe(
        data => {
          alert("Room created successfully.");

          /* clean input fields */
          this.examination_type.price = 0;
        }
      )
    } else {
      alert("Fill other inputs.");
    }
  }

  onChange(inType): void {
    this.examination_type.interventionType = inType;
  }

}
