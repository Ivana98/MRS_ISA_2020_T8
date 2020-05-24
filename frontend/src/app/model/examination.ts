import { Prescription } from './prescription';
import { Disease } from './disease';

export class Examination{

    constructor(

        public id: number,
        public date : Date,
        public wasOnExamination : boolean,
        public description : string,
        public discount : number,
        
        public examination_type : string ,
        public prescriptions : Set<Prescription>,
        public diseases : Set<Disease> ,
        public doctor_id: string,
        public doctor_name : string,
        public doctor_surname : string,
        public doctor_email : string

    ){}

}