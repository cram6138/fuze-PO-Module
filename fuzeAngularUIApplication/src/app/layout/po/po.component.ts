import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { customers } from './customers';
import { PanelBarItemModel } from '@progress/kendo-angular-layout';

@Component({
    selector: 'app-PO',
    templateUrl: './po.component.html',
    styleUrls: ['./po.component.scss'],
    animations: [routerTransition()]
})
export class POComponent implements OnInit {
    public gridData: any[] = customers;
    public gridData2: any[] = customers;
    public gridData3: any[] = customers;
    constructor() {}
   // private baseSportsIconUrl: string = "https://demos.telerik.com/kendo-ui/content/shared/icons/sports/";
   // private baseIconUrl: string = "https://demos.telerik.com/kendo-ui/content/shared/icons/16/";

    // private sportsIconUrl(imageName: string): string {
    //     return this.baseSportsIconUrl + imageName + ".png";
    // }

    // private iconUrl(imageName: string): string {
    //     return this.baseIconUrl + imageName + ".png";
    // }
    ngOnInit() {}
}
