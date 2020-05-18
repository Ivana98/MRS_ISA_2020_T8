export interface IPatient {
    id: number,
    firstName: string,
    lastName: string,
    email: string,
    phone: string,
    password: string,
    country: string,
    city: string,
    street: string,
    allergy: string,
	blood_type: string,
	diopter: string,
	height: string,
	weight: string,
	policyholder: string,
	clinical_center_id: string

}

export class Patient {
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
        public allergy: string,
        public blood_type: string,
        public diopter: string,
        public height: string,
        public weight: string,
        public policyholder: string,
        public clinical_center_id: string
    ) {} 

    /* If any of fields are empty return false */
    public filled(): boolean {
        
        // if (this.firstName == "" || this.lastName == "" || this.email == "" || this.phone == "" || this.password == "" || this.country == "" || this.city == "" || this.street == "" || this.clinic_id == "" || this.specialisation == "") 
        // {
        //     return false;
        // }
        return true;
    }
}