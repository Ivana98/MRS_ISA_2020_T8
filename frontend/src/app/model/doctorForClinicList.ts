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

/**
 * Same as above plus id.
 */
export interface IDoctorForClinicList2 {
    id: number,
    firstName: string,
    lastName: string,
    phone: string,
    clinic_id: number,
    specialisation: string,
    averageMark: number
}

export class DoctorForClinicList2 {
    constructor(
        public id: number,
        public firstName: string,
        public lastName: string,
        public phone: string,
        public clinic_id: number,
        public specialisation: string,
        public averageMark: number
    ) {} 
}