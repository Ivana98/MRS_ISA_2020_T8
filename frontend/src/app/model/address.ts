export interface IAddress {
    street: string,
    city: string,
    country: string
}

export class Address {
    constructor(
        public street: string,
        public city: string,
        public country: string
    ) {} 
}