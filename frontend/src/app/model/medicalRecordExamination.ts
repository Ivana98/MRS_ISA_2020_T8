import { Disease } from './disease';
import { Prescription } from './prescription';

export class MedicalRecordExamination {
    constructor(
        public id: number,
        public date: Date,
        public specialisation: string,
        public interventionType: string,
        public staticPrice: number,
        public doctorName: string,
        public doctorSurname: string,
        public roomNumber: string,
        public wasOnExamination: boolean, 
        public diseases: Array<Disease>,
        public prescriptions: Array<Prescription>
    ) {} 
}