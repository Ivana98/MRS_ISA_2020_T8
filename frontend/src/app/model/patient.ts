import { ClinicMark } from './clinicMark';
import { DoctorMark } from './doctorMark';
import { Examination } from './examination';

export class Patient{

    constructor(

        public id: number,
        public policyHolder: string,
        public height : number ,
        public width : number,
        public bloodType : string,
        public alergy : number,
        public diopter : string ,  
        public clinicalCenter_name: string,
        public email : string,
        public name : string,
        public surname : string,
        public city : string,
        public country : string,
        public street : string,
        public phone: string,
        public clinicMarks : Set<ClinicMark>,
        public doctorMarks : Set<DoctorMark>,
        public examinations : Set<Examination>


    ){}

}