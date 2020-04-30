import { IAddress } from './address';

export interface IDoctor {
    firstName: string,
    lastName: string,
    email: string,
    phone: string,
    password: string,
    address: IAddress //maybe just address i dont know
}

export class Doctor {
    constructor(
        public firstName: string,
        public lastName: string,
        public email: string,
        public phone: string,
        public password: string,
        public address: IAddress
    ) {} 
}

export interface IDoctor2 {
    firstName: string,
    lastName: string,
    email: string,
    phone: string,
    password: string,
    country: string,
    city: string,
    street: string
}

export class Doctor2 {
    constructor(
        public firstName: string,
        public lastName: string,
        public email: string,
        public phone: string,
        public password: string,
        public country: string,
        public city: string,
        public street: string
    ) {} 
}