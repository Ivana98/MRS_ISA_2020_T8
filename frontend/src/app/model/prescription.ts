export class Prescription{

    constructor(

        public id: number,
        public validated : boolean,
        public quantity : number,
        public date : Date,
        public nurse_id : string ,
        public nurse_name : string ,
        public medication_id : string ,
        public medication_name: string,
        public description : string

    ){}

}