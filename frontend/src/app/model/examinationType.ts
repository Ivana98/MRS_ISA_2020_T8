export interface IExaminationType {
    price: number,
    duration: number,
    interventionType: string,
    specialisation: string
}

export class ExaminationType {
    constructor(
        public price: number,
        public duration: string,
        public interventionType: string,
        public specialisation: string
    ) {} 

    /* If any of fields are empty return false */
    public filled(): boolean {
        
        if (this.interventionType == "" || this.specialisation == "" || this.duration == "")
        {
            return false;
        }
        return true;
    }
}