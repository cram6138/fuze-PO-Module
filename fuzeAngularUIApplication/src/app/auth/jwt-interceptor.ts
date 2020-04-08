import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { AuthService } from '../services/auth.service';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationObj } from '../model/authenticationObj';


@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    currentUserSubject = new BehaviorSubject<AuthenticationObj>(JSON.parse(localStorage.getItem('currentUser')));
    constructor(private authService: AuthService,
                private router: Router) { }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with jwt token if available
        console.log('current user from jwt interceptor :::: ');
        if (this.authService.isLoggedIn()) {
            request = request.clone({
                setHeaders: {
                    Authorization: 'Bearer' + this.currentUserSubject.value.accessToken
                }
            });
        }
        console.log(`Bearer ${this.currentUserSubject.value}`);
        return next.handle(request);
    }
}
