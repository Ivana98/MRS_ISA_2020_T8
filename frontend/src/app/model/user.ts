export interface IUser {
    policyholder:string,
        email:string,
        name:string,
        surname:string,
        adress:string,
        city:string,
        country:string,
        phone:string
}

export class User{
    constructor(
        public policyholder:string,
        public email:string,
        public name:string,
        public surname:string,
        public adress:string,
        public city:string,
        public country:string,
        public phone:string,
    ) {} 
}