import { ExaminationForPatient } from './examinationForPatient';

export interface IMedicalRecords {
    name: string,
    surname: string,
    policyholder: string,
	height: number,
	weight: number,
	bloodType: string,
	allergies: string,
    diopter: string,
    examinations: ExaminationForPatient[]
}

export class MedicalRecords {
    constructor(
        public name: string,
        public surname: string,
        public policyholder: string,
        public height: number,
        public weight: number,
        public bloodType: string,
        public allergies: string,
        public diopter: string,
        public examinations: ExaminationForPatient[]
    ) {} 
}