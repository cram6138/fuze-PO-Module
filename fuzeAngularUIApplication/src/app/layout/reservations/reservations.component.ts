import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { PanelBarItemModel } from '@progress/kendo-angular-layout';
import { customers } from '../po/customers';

@Component({
    selector: 'app-Reservations',
    templateUrl: './reservations.component.html',
    styleUrls: ['./reservations.component.scss'],
    animations: [routerTransition()]
})
export class ReservationsComponent implements OnInit {
    constructor() {}
    public MyReservations: any[] = customers;
    public ContainerSearch: any[] = customers;
    public ContainerDetails: any[] = customers;
    public listItems: Array<string> = ["X-Small", "Small", "Medium", "Large", "X-Large", "2X-Large"];
    public listItems2: Array<string> = ["X-Small", "Small", "Medium", "Large", "X-Large", "2X-Large"];
    public listItems3: Array<string> = ["X-Small", "Small", "Medium", "Large", "X-Large", "2X-Large"];
    public listItems4: Array<string> = ["X-Small", "Small", "Medium", "Large", "X-Large", "2X-Large"];
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
