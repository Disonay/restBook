import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {ListCommand} from "../commands/list/list-command";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TableResolverService implements Resolve<Observable<any>>{

  constructor(private allDataGetter: ListCommand) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> {
    return this.allDataGetter.execute()
  }
}
