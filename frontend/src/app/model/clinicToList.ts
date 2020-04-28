export interface IClinic {
    id:number,
    ame:string,
    addressStreet:string,
    averageMark:number
}

export class Clinic{
    constructor(
        public id:number,
        public name:string,
        public addressStreet:string,
        public averageMark:number,
    ) {} 
}