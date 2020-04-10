import { UserModel } from './user-model';

export class AuthenticationObj {
    accessToken: string;
    message: string;
    userInfo: UserModel;
    sessionId: string;
}
