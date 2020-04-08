import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Config } from '../common/config';
import { AuthenticationObj } from '../model/authenticationObj';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private currentUserSubject: BehaviorSubject<AuthenticationObj>;
  public currentUser: AuthenticationObj;

  constructor(private http: HttpClient,
              private cookeiService: CookieService) {
    this.currentUserSubject = new BehaviorSubject<AuthenticationObj>(JSON.parse(localStorage.getItem('currentUser')));
  }

  login(username: string, password: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    return this.http.post<AuthenticationObj>(Config.ZUUL_SERVICE + '/pos/login', { username, password }, httpOptions);
  }

  storeCurrentUserInfo(authObj: AuthenticationObj) {
    this.cookeiService.set('currentUser', JSON.stringify(authObj.userInfo));
    localStorage.setItem('currentUser', JSON.stringify(authObj));
    this.currentUserSubject.next(authObj);
  }

  logout() {
    // remove user from local storage and set current user to null
    this.cookeiService.delete('currentUser');
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }

  isLoggedIn(): boolean {
    if (localStorage.getItem('currentUser') != null) {
      return true;
    }
    return false;
  }

  getCurrentUser() {
    return localStorage.getItem('currentUser');
  }

}
