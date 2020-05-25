export interface IDoctorForClinicList {
    firstName: string,
    lastName: string,
    phone: string,
    clinic_id: number,
    specialisation: string,
    averageMark: number
}

export class DoctorForClinicList {
    constructor(
        public firstName: string,
        public lastName: string,
        public phone: string,
        public clinic_id: number,
        public specialisation: string,
        public averageMark: number
    ) {} 
}