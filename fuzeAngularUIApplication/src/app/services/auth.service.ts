import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { UserModel } from '../model/user-model';
import { Config } from '../common/config';
import { AuthenticationObj } from '../model/authenticationObj';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private currentUserSubject: BehaviorSubject<AuthenticationObj>;
  public currentUser: AuthenticationObj;

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<AuthenticationObj>(JSON.parse(localStorage.getItem('currentUser')));
  }

  login(username: string, password: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    return this.http.post<AuthenticationObj>(Config.ui2_service + '/ang/login', { username, password }, httpOptions);
  }

  storeCurrentUserInfo(authObj: AuthenticationObj) {
    localStorage.setItem('currentUser', JSON.stringify(authObj));
    this.currentUserSubject.next(authObj);
  }

  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }

}
