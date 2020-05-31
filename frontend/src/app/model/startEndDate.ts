export interface IStartEndDate {
    startDate: Date,
    endDate: Date
}

export class StartEndDate {
    constructor (
        public startDate: Date,
        public endDate: Date
    ) {}
}