export class OfferedAppointmentClass {
    constructor(
        public dateOfExamination: Date, //date and time
        public examinationRoom: string,
        public doctorsName: string, // name and surname
        public examinationType: string, 
        public price: number,
        public discount: number,
        public doctorId: number,
        public clinicId: number,
        public examinationId: number,
        public patientId: number
    ) {} 
}