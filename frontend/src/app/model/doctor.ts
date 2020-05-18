export interface IDoctor {
    id: number,
    firstName: string,
    lastName: string,
    email: string,
    phone: string,
    password: string,
    country: string,
    city: string,
    street: string,
    clinic_id: string,
    specialisation: string
}

export class Doctor {
    constructor(
        public id: number,
        public firstName: string,
        public lastName: string,
        public email: string,
        public phone: string,
        public password: string,
        public country: string,
        public city: string,
        public street: string,
        public clinic_id: string,
        public specialisation: string
    ) {} 

    /* If any of fields are empty return false */
    public filled(): boolean {
        
        if (this.firstName == "" || this.lastName == "" || this.email == "" || this.phone == "" || this.password == "" || this.country == "" || this.city == "" || this.street == "" || this.clinic_id == "" || this.specialisation == "") 
        {
            return false;
        }
        return true;
    }
}