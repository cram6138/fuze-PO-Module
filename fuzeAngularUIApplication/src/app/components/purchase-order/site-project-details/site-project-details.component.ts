import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { AuthenticationObj } from 'src/app/model/authenticationObj';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-site-project-details',
  templateUrl: './site-project-details.component.html',
  styleUrls: ['./site-project-details.component.css']
})
export class SiteProjectDetailsComponent implements OnInit {

  private currentUserSubject: BehaviorSubject<AuthenticationObj>;
  constructor(private appComponent: AppComponent) {
    this.currentUserSubject = new BehaviorSubject<AuthenticationObj>(JSON.parse(localStorage.getItem('currentUser')));
  }

  ngOnInit(): void {
    if (!this.appComponent.user) {
      this.appComponent.user = this.currentUserSubject.value.userInfo;
    }
  }

}
