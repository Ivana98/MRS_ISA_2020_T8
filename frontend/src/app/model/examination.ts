export interface IExamination {
    id: number,
    date: Date,
    wasOnExamination: boolean,
    description: string,
    discount: number,
    medicalRoomId: number,
    doctorId: number,
    patientId: number,
    duration: string,
    specialisation: string,
    interventionType: string,
    priceId: number
}

export class Examination {
    constructor(
        public id: number,
        public date: Date,
        public wasOnExamination: boolean,
        public description: string,
        public discount: number,
        public medicalRoomId: number,
        public doctorId: number,
        public patientId: number,
        public duration: string,
        public specialisation: string,
        public interventionType: string,
        public priceId: number
    ) {} 

    /* If any of fields are empty return false */
    public filled(): boolean {
        //TODO:
        return true;
    }
}