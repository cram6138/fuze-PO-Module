import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InputsModule } from '@progress/kendo-angular-inputs';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { PurchaseOrderComponent } from './components/purchase-order/purchase-order.component';
import { PurchaseOrderReservationComponent } from './components/purchase-order-reservation/purchase-order-reservation.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './components/header/header.component';

import { MatSliderModule } from '@angular/material/slider';
import { MatOptionModule } from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatCardModule} from '@angular/material/card';
import {CookieService} from 'ngx-cookie-service';
import { ProjectSearchComponent } from './components/purchase-order/project-search/project-search.component';
import { SiteProjectDetailsComponent } from './components/purchase-order/site-project-details/site-project-details.component';
import { PoRequestDetailsComponent } from './components/purchase-order/po-request-details/po-request-details.component';
import { MyReservationsComponent } from './components/purchase-order-reservation/my-reservations/my-reservations.component';
import { ContainerSearchReserveComponent } from './components/purchase-order-reservation/container-search-reserve/container-search-reserve.component';
import { ContainerDetailsComponent } from './components/purchase-order-reservation/container-details/container-details.component';
import { ContainerReserveUnreserveComponent } from './components/purchase-order-reservation/container-reserve-unreserve/container-reserve-unreserve.component';
import { JwtInterceptor } from './auth/jwt-interceptor';
import {MatExpansionModule} from '@angular/material/expansion';


@NgModule({
  declarations: [
    AppComponent,
    PurchaseOrderComponent,
    PurchaseOrderReservationComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    ProjectSearchComponent,
    SiteProjectDetailsComponent,
    PoRequestDetailsComponent,
    MyReservationsComponent,
    ContainerSearchReserveComponent,
    ContainerDetailsComponent,
    ContainerReserveUnreserveComponent
  ],
  imports: [
    BrowserModule,
    MatCheckboxModule,
    MatSlideToggleModule,
    MatCardModule,
    MatSelectModule,
    MatRadioModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    InputsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatSliderModule,
    MatOptionModule,
    MatInputModule,
    MatFormFieldModule,
    MatExpansionModule
  ],
  providers: [CookieService,
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
