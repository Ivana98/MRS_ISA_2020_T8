export interface IClinic {
    id:number,
    name:string,
    addressStreet:string,
    adressCity:string,
    averageMark:number
}

export class Clinic{
    constructor(
        public id:number,
        public name:string,
        public addressStreet:string,
        public addressCity:string,
        public averageMark:number,
    ) {} 
}