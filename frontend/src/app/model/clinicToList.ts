import { DoctorForClinicList } from './doctorForClinicList';

export interface IClinic {
    id:number,
    name:string,
    addressStreet:string,
    addressCity:string,
    averageMark:number,
    doctors: DoctorForClinicList[],
    canRateClinic: boolean,
    givenMark: number
}

export class Clinic{
    constructor(
        public id: number,
        public name: string,
        public addressStreet: string,
        public addressCity: string,
        public averageMark: number,
        public doctors: DoctorForClinicList[],
        public canRateClinic: boolean,
        public givenMark: number
    ) {} 
}