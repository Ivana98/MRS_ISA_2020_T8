
export class AbsenceUser {
    constructor(
        public id: number,
        public beginDate: Date,
        public endDate: Date,
        public absenceType: string,
        public confirmed: boolean,
        public userId: number,  // id of user which are sending absence request
        public firstName: string,
        public lastName: string,
        public email: string
    ) {} 
}

export class AbsenceUserToDisplay {
    constructor(
        public id: number,
        public beginDate: string,
        public endDate: string,
        public absenceType: string,
        public confirmed: boolean,
        public userId: number,  // id of user which are sending absence request
        public firstName: string,
        public lastName: string,
        public email: string
    ) {} 
}