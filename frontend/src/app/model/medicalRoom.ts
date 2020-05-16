export interface IMedicalRoom {
    id: number,
    room_number: string,
    intervention_type: string,
    clinic_id: number
}

export class MedicalRoom {
    constructor(
        public id: number,
        public room_number: string,
        public intervention_type: string,
        public clinic_id: number
    ) {}
    
    /* If any of fields empty return false */
    public filled(): boolean {
        
        if (this.room_number == "" || this.intervention_type == "" || this.clinic_id == 0 || this.clinic_id == null) {
            return false;
        }
        return true;
    }
}