import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs";
import {ListAuthorCommand} from "../../commands/list/list-author-command";

@Injectable({
  providedIn: 'root'
})
export class AuthorTableResolverService implements Resolve<Observable<any>>{

  constructor(private allDataGetter: ListAuthorCommand) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> {
    return this.allDataGetter.execute()
  }
}
