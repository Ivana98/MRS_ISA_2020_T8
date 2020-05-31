export interface IRegisterRequest {
    email: string,
    name: string,
    surname: string,
    street: string,
    city: string,
    country: string,
    phone: string,
    password: string,
    policyholder: string
}

export class RegisterRequest {
    constructor(
        public email: string,
        public name: string,
        public surname: string,
        public street: string,
        public city: string,
        public country: string,
        public phone: string,
        public password: string,
        public policyholder: string
    ) {} 
}