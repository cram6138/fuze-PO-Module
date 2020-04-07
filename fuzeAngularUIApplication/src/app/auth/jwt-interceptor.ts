import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';



export class JwtInterceptor implements HttpInterceptor {

    constructor(private authService: AuthService) { }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with jwt token if available
        const currentUser = this.authService.currentUser;
        console.log('current user from jwt interceptor :::: ' + currentUser);
        if (currentUser && currentUser.accessToken) {
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${currentUser.accessToken}`
                }
            });
        }

        return next.handle(request);
    }
}