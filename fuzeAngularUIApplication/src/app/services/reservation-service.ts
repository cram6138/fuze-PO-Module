
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserInfo } from '../models/user-info';
import { ContainerForm } from '../models/container-form';
import { ContainerInfo } from '../models/container-info';


@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  public containerDetails(user: UserInfo){
    return this.http.post<any>("http://localhost:8088/reservation/containersByUserInfo",user,{ responseType: 'json'});
   }

   public getTerritories(){
      return this.http.get<any>("http://localhost:8088/territories",{ responseType: 'json'});
   } 

   public getMarkets(){
    return this.http.get("http://localhost:8088/territories",{ responseType: 'json'});
  } 

  public getContainer(containerForm: ContainerForm){
    return this.http.post<any>("http://localhost:8088/reservation/search/container",containerForm);
 } 
}
