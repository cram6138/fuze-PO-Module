import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthGuard } from './shared';

import { LayoutModule } from '@progress/kendo-angular-layout';
import { ButtonsModule } from '@progress/kendo-angular-buttons';
import { GridModule } from '@progress/kendo-angular-grid';

import { ReservationService } from './services/reservation-service';



@NgModule({
    imports: [
        LayoutModule,
        CommonModule,
        BrowserModule,
        BrowserAnimationsModule,
        HttpClientModule,
        
        AppRoutingModule,
        
        ButtonsModule,
        
        GridModule,
         
    ],
    declarations: [AppComponent],
    providers: [AuthGuard,ReservationService],
    bootstrap: [AppComponent]
})
export class AppModule {}
