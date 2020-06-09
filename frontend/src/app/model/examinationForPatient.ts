export interface IExaminationForPatient {
    dateOfExamination: Date,
    wasOnExamination: boolean,
    doctorsName: string,
    examinationType: string, 
    clinicName: string,
    price: string,
    description: string,
    diseases: string[],
    medications: string[]
}

export class ExaminationForPatient {
    constructor(
        public dateOfExamination: Date,
        public wasOnExamination: boolean,
        public doctorsName: string,
        public examinationType: string, 
        public clinicName: string,
        public price: string,
        public description: string,
        public diseases: string[],
        public medications: string[]
    ) {} 
}