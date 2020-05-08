export interface IUserLogin {
    password: string,
    username: string
}

export class UserLogin {
    constructor(
        public password: string,
        public username: string
    ) {} 
}