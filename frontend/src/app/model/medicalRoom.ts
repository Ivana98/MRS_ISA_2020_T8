export interface IMedicalRoom {
    room_number: string,
    intervention_type: string,
    clinic_id: string
}

export class MedicalRoom {
    constructor(
        public room_number: string,
        public intervention_type: string,
        public clinic_id: string
    ) {}
    
    /* If any of fields empty return false */
    public filled(): boolean {
        
        if (this.room_number == "" || this.intervention_type == "" || this.clinic_id == "") {
            return false;
        }
        return true;
    }
}