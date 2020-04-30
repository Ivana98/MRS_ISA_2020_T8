export interface IMedicalRoom {
    number: string,
    inversionType: string
}

export class MedicalRoom {
    constructor(
        public number: string,
        public inversionType: string
    ) {} 
}