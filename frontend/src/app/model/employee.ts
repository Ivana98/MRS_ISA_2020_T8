export interface IEmployee {
    empId: string,
    name: string,
    designation: string,
    salary: string
}

export class Employee{
    constructor(
        public empId:string,
        public name:string,
        public designation:string,
        public salary:string,
    ) {} 
}