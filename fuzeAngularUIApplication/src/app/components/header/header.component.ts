import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthService,
              private router: Router,
              private appComponent: AppComponent) { }

  ngOnInit(): void {
  }

  logout() {
    this.authService.logout();
    this.appComponent.user = null;
    this.router.navigate(['/']);
  }

  poReservation() {
    this.router.navigate(['/po-reservation']);
  }

  purchaseOrder() {
    this.router.navigate(['/purchase-order']);
  }

  home() {
    this.router.navigate(['/home']);
  }
}
