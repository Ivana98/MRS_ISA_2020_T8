
export class ExaminationRequest {
    constructor(
        public clinicId: number,
        public doctorId: number,
        public patientId: number,
        public interventionType: string,
        public date: Date
    ) {} 
}