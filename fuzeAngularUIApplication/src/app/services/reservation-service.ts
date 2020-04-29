
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserInfo } from '../models/user-info';
import { ContainerForm } from '../models/container-form';
import { ContainerInfo } from '../models/container-info';


@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private GET_CONTAINER_DETAILS_SERVICE = "http://localhost:8888/por/reservation/containersByUserInfoV1plsql";
  private SEARCH_CONTAINER_DETAILS_SERVICE = "http://localhost:8888/por/reservation/search/containerV1plsql";
  private GET_TERRITORIES = "http://localhost:8888/por/territories";
  private GET_MARKETS = "http://localhost:8888/por/markets";

  constructor(private http: HttpClient) { }

  public containerDetails(user: UserInfo){
    return this.http.post<any>(this.GET_CONTAINER_DETAILS_SERVICE,user,{ responseType: 'json'});
   }

   public getTerritories(){
      return this.http.get<any>(this.GET_TERRITORIES,{ responseType: 'json'});
   } 

   public getMarkets(){
    return this.http.get(this.GET_TERRITORIES,{ responseType: 'json'});
  } 

  public getContainer(containerForm: ContainerForm){
    return this.http.post<any>(this.SEARCH_CONTAINER_DETAILS_SERVICE,containerForm);
 } 
}
