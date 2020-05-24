export interface IFreeExaminationToDisplay {
    id: number,
    roomNumber: string,
    doctorName: string,
    duration: number,
    interventionType: string,
    specialisation: string,
    price: number,
    date: Date,
    formattedDate: string
}

export class FreeExaminationToDisplay {
    constructor(
        public id: number,
        public roomNumber: string,
        public doctorName: string,
        public duration: number,
        public interventionType: string,
        public specialisation: string,
        public price: number,
        public date: Date,
        public formattedDate: string
    ) {} 

    /* If any of fields are empty return false */
    public filled(): boolean {
        //TODO:
        return true;
    }
}