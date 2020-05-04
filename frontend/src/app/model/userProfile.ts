export interface IUserProfile {
    id: number,
    email: string,
    name: string,
    surname: string,
    street: string,
    city: string,
    country: string,
    phone: string,
    password: string
}

export class UserProfile {
    constructor(
        public id: number,
        public email: string,
        public name: string,
        public surname: string,
        public street: string,
        public city: string,
        public country: string,
        public phone: string,
        public password: string
    ) {} 
}