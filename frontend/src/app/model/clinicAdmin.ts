import { Address } from "./address";

export interface IClinicAdmin{

    firstName: string,
    lastName: string,
    email: string,
    phone: string,
    password: string,
    country: string,
    city: string,
    street: string
}

export class ClinicAdmin{
    constructor(
        public firstName: string,
        public lastName: string,
        public email: string,
        public phone: string,
        public password: string,
        public country: string,
        public city: string,
        public street: string
    ){}
}