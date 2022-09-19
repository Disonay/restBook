import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs";
import {ListBookCommand} from "../../commands/list/list-book-command";

@Injectable({
  providedIn: 'root'
})
export class BookTableResolverService implements Resolve<Observable<any>>{

  constructor(private allDataGetter: ListBookCommand) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> {
    return this.allDataGetter.execute()
  }
}
