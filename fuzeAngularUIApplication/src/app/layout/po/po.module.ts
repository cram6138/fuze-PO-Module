import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PORoutingModule } from './po-routing.module';
import { POComponent } from './po.component';
import { PageHeaderModule } from './../../shared';
import { LayoutModule } from '@progress/kendo-angular-layout';
import { GridModule } from '@progress/kendo-angular-grid';

@NgModule({
    imports: [CommonModule, PORoutingModule, PageHeaderModule,LayoutModule,GridModule],
    declarations: [POComponent]
})
export class POModule {}
