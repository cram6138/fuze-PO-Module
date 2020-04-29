import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import { ReservationsComponent } from './reservations.component';
import { PageHeaderModule } from './../../shared';
import { ReservationsRoutingModule } from './reservations-routing.module';
import { LayoutModule } from '@progress/kendo-angular-layout';
import { GridModule } from '@progress/kendo-angular-grid';

import { DropDownsModule } from '@progress/kendo-angular-dropdowns';
import { FormsModule } from '@angular/forms';

@NgModule({
    imports: [CommonModule, ReservationsRoutingModule, PageHeaderModule,LayoutModule,GridModule,DropDownsModule,FormsModule ],
    declarations: [ReservationsComponent]
})
export class ReservationsModule {}
