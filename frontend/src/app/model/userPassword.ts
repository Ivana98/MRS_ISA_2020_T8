export interface IUserPassword {
    id: number,
    password: string,
    newPassword: string,
    confirmedPassword: string
}

export class UserPassword {
    constructor(
        public id: number,
        public password: string,
        public newPassword: string,
        public confirmedPassword: string
    ) {} 
}