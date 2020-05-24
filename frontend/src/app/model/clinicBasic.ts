export interface IClinicBasic {
    id: number,
    name: string,
    description: string,
    street: string,
    city: string,
    country: string,
    averageMark: number
}

export class ClinicBasic{
    constructor(
        public id: number,
        public name: string,
        public description: string,
        public street: string,
        public city: string,
        public country: string,
        public averageMark: number
    ) {} 
}