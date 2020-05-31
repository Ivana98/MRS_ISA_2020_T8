export interface IUserPassword {
    password: string,
    newPassword: string,
    confirmedPassword: string
}

export class UserPassword {
    constructor(
        public password: string,
        public newPassword: string,
        public confirmedPassword: string
    ) {} 
}