
export class ExaminationRequest {
    constructor(
        public clinicId: number,
        public doctorId: number,
        public patientId: number,
        public interventionType: string,
        public date: Date
    ) {} 
}

export class ExaminationRequestDisplay {
    constructor(
        public id: number,  // Examination id
        public clinicId: number,
        public doctorId: number,
        public doctorName: string,
        public doctorSurname: string,
        public doctorSpecialisation: string,
        public patientId: number,
        public patientName: string,
        public patientSurname: string,
        public interventionType: string,
        public date: Date
    ) {} 
}

/**
 * here is date STRING, no Date()
 */
export class ExaminationRequestDisplay2 {
    constructor(
        public id: number,  // Examination id
        public clinicId: number,
        public doctorId: number,
        public doctorName: string,
        public doctorSurname: string,
        public doctorSpecialisation: string,
        public patientId: number,
        public patientName: string,
        public patientSurname: string,
        public interventionType: string,
        public date: string
    ) {} 
}

export class ApprovedExaminationRequest {
    constructor(
        public id: number,
        public medicalRoomId: number,
        public clinicId: number,
        public newDate: Date
    ) {} 
}