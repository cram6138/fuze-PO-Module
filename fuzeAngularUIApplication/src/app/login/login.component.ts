import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { Config } from '../common/config';
import { AppComponent } from '../app.component';
import { BehaviorSubject } from 'rxjs';
import { AuthenticationObj } from '../model/authenticationObj';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  errorMsg: string;
  private currentUserSubject: BehaviorSubject<AuthenticationObj>;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private appComponent: AppComponent,
    private authService: AuthService
  ) {
    this.currentUserSubject = new BehaviorSubject<AuthenticationObj>(JSON.parse(localStorage.getItem('currentUser')));
    if (this.currentUserSubject.value) {
      this.router.navigate(['/home']);
    }
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;
    this.authService.login(this.f.username.value, this.f.password.value)
      .subscribe(
        data => {
          this.appComponent.user = data.userInfo;
          this.errorMsg = '';
          this.authService.storeCurrentUserInfo(data);
          this.router.navigate(['/home']);
          // window.location.href = Config.ui2_service + data.sessionId;
        },
        error => {
          if (error.status === 401) {
            this.errorMsg = 'Bad username or password';
          }
          this.loading = false;
          console.log(error);
        });
  }

}
