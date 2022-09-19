import {Command} from "../command";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {AuthorService} from "../../service/author/author.service";

@Injectable({
  providedIn: 'root'
})
export class ListAuthorCommand implements Command {
  constructor(private authorService: AuthorService) {
  }

  execute(): Observable<any> {
    return this.authorService.findAll()
  }
}
