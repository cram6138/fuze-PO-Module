import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { PanelBarItemModel } from '@progress/kendo-angular-layout';
import { customers } from '../po/customers';
import { UserInfo } from '../../models/user-info';
import { ContainerInfo } from '../../models/container-info';
import { ReservationService } from '../../services/reservation-service';
import { ContainerForm } from '../../models/container-form';


@Component({
    selector: 'app-Reservations',
    templateUrl: './reservations.component.html',
    styleUrls: ['./reservations.component.scss'],
    animations: [routerTransition()]
})
export class ReservationsComponent implements OnInit {
    
    //public MyReservations: any[] = customers;
    // public ContainerSearch: any[] = customers;
    // public ContainerDetails: any[] = customers;
    // public listItems: Array<string> = ["X-Small", "Small", "Medium", "Large", "X-Large", "2X-Large"];
    // public listItems2: Array<string> = ["X-Small", "Small", "Medium", "Large", "X-Large", "2X-Large"];
    // public listItems3: Array<string> = ["X-Small", "Small", "Medium", "Large", "X-Large", "2X-Large"];
    // public listItems4: Array<string> = ["X-Small", "Small", "Medium", "Large", "X-Large", "2X-Large"];
    // private baseSportsIconUrl: string = "https://demos.telerik.com/kendo-ui/content/shared/icons/sports/";
    // private baseIconUrl: string = "https://demos.telerik.com/kendo-ui/content/shared/icons/16/";

    // private sportsIconUrl(imageName: string): string {
    //     return this.baseSportsIconUrl + imageName + ".png";
    // }

    // private iconUrl(imageName: string): string {
    //     return this.baseIconUrl + imageName + ".png";
    // }

    constructor(private reservationService:ReservationService) {
        console.log("Reservation...");
    }
    userInfo = new UserInfo(6,"TTR121","");
    public containerInfoDetails:any[];
    public containers:any;
    public territoryList: Array<String> = [];
    public territoryListData: Array<{name:String,id:String}> = [];
    public defaultTerritory: { name: string, id: String } = { name: "Territory...", id: null };
    public dataMarkets: Array<{ name: string, marketId: String,territoryId:String }> = [];
    public defaultMarket: { name: string, id: String } = { name: "Market...", id: null };
    public dataSubMarkets: Array<{ name: string,subMarketId:String, marketId: String }> = [];
    public defaultSubMarket: { name: string, id: String } = { name: "SubMarket...", id: null };

    public isDisabledMarket: boolean = true;
    public isDisabledSubMarket: boolean = true;

    public selectedTerritory: { territoryName: string, territoryId: String};
    public selectedMarket: { name: string, id: String};
    public selectedSubMarket: { name: string, id: String};

    public dataResultMarkets: Array<{ name: string, marketId: String,territoryId:String }>;
    
    public dataResultSubMarkets: Array<{ name: string,subMarketId:String, marketId: String }>;

    containerForm = new ContainerForm(null,null,null,null,null,null,null,null);
    
    ngOnInit() {
        this.getTerritories();
    }
    getmsg(){
        console.log("container details triggered...");
    }
   // public listItems: Array<string> = ["X-Small", "Small", "Medium", "Large", "X-Large", "2X-Large"];
   
    containerDetails(){
        console.log("containerDetails invoked...");
           let response = this.reservationService.containerDetails(this.userInfo);
          response.subscribe(data =>{
            console.log("Container Details::"+data);
            this.containerInfoDetails=data.containerInfoDetails;
          });
        }

    getTerritories(){
        let response = this.reservationService.getTerritories();
        response.subscribe(data =>{
            console.log("All Territories::"+ data[0].name);
            for(var territory of data){
                console.log(territory.name);
                this.territoryList.push(territory.name);
                this.territoryListData.push({'name':territory.name,'id':territory.id});
                for(var market of territory.markets ){
                    this.dataMarkets.push({'name':market.name,'marketId':market.id,'territoryId':territory.id});
                    console.log(market.name);
                    for(var subMarket of market.subMarkets){
                        this.dataSubMarkets.push({'name':subMarket.name,'subMarketId':subMarket.id,'marketId':market.id});
                        console.log(subMarket.name);
                    }
                }
                
            }
        });
    }

    handleTerritoryChange(territoryValue:any) {
        console.log("handleTerritoryChange");
        this.selectedTerritory = territoryValue;
        this.selectedMarket = this.defaultMarket;
        this.selectedSubMarket = undefined;
        if(territoryValue.id == this.defaultTerritory.id){
            this.isDisabledMarket = true;
            this.dataResultMarkets = [];
            this.containerForm.territory=null;
            this.containerForm.market = null;
            this.containerForm.subMarket = null;
          } else {
            this.containerForm.territory=territoryValue.name;
            this.isDisabledMarket = false;
            this.dataResultMarkets = this.dataMarkets.filter((s) => s.territoryId === territoryValue.id )
          }
    
          this.isDisabledSubMarket = true;
          this.dataResultSubMarkets = [];
    }

    handleMarketChange(marketValue:any) {
        console.log("handleMarketChange::"+marketValue.marketId);
        this.selectedMarket = marketValue;
        this.selectedSubMarket = this.defaultSubMarket;
  
        if(marketValue.marketId == this.defaultMarket.id){
          console.log("desable..");
          this.isDisabledSubMarket = true;
          this.dataResultSubMarkets = [];
          this.containerForm.market = null;
          this.containerForm.subMarket = null;
        } else {
          this.containerForm.market = marketValue.name;
          this.isDisabledSubMarket = false;
          this.dataResultSubMarkets = this.dataSubMarkets.filter((s) => s.marketId === marketValue.marketId )
        }
      }
      handleSubMarketChange(subMarketValue:any){
            this.selectedSubMarket = subMarketValue;
            if(subMarketValue.subMarketId == this.defaultSubMarket.id){
                this.containerForm.subMarket=null;
            }else{
                this.containerForm.subMarket = subMarketValue.name;
            }
      }
      containerSearch(){
        console.log("containerSearch()");
        if(this.containerForm.containerCode == ""){
           this.containerForm.containerCode=null;
        }
        let response = this.reservationService.getContainer(this.containerForm);
        response.subscribe(data =>{
            console.log("Container Details::"+JSON.stringify(data));
            this.containers= data;
          });
    }
       
}
