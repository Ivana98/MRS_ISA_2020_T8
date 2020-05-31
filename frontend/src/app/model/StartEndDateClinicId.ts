export interface IStartEndDateClinicId {
    startDate: Date,
    endDate: Date
    clinicId: number
}

export class StartEndDateClinicId {
    constructor (
        public startDate: Date,
        public endDate: Date,
        public clinicId: number
    ) {}
}