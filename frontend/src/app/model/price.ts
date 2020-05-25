export interface IPrice {
    id: number,
    price: number,
    examination_type_id: number
}

export class Price {
    constructor(
        public id: number,
        public price: number,
        public examination_type_id: number
    ) {}
    
    /* If any of fields empty return false */
    public filled(): boolean {
        
        // if (this.room_number == "" || this.intervention_type == "" || this.clinic_id == 0 || this.clinic_id == null) {
        //     return false;
        // }
        return true;
    }
}

export class FullPrice {
    constructor(
        public id: number,
        public clinic_id: number,
        public price: number,
        
        // Examination type attributes, instead of examination_type_id
        public intervention_type: string,
        public specialisation: string,
        public duration: number
    ) {}
}