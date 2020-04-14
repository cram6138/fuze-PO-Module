import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { ReservationsComponent } from './reservations.component';
import { PageHeaderModule } from './../../shared';
import { ReservationsRoutingModule } from './reservations-routing.module';
import { LayoutModule } from '@progress/kendo-angular-layout';
import { GridModule } from '@progress/kendo-angular-grid';

@NgModule({
    imports: [CommonModule, ReservationsRoutingModule, PageHeaderModule,LayoutModule,GridModule],
    declarations: [ReservationsComponent]
})
export class ReservationsModule {}
