
export class Absence {
    constructor(
        public id: number,
        public beginDate: Date,
        public endDate: Date,
        public absenceType: string,
        public confirmed: boolean,
        public userId: number // id of user which are sending absence request
    ) {} 
}