export interface IAdmin {
    name: string,
    pass: string,
    
}

export class Admin{
    constructor(
        public name:string,
        public pass:string,
    ) {} 
}