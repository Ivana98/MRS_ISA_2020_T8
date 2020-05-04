export interface ICLinicToDisplay {
    id: string,
    name: string
}

export class CLinicToDisplay {
    constructor(
        public id: string,
        public name: string
    ) {} 
}