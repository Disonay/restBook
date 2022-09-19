import {Injectable} from "@angular/core";
import {Command} from "../command";
import {Observable} from "rxjs";
import {AuthorService} from "../../service/author/author.service";

@Injectable({
  providedIn: 'root'
})
export class DeleteAuthorCommand implements Command {
  private id: number;

  constructor(private authorService: AuthorService) {
  }

  payload(id: number): Command {
    this.id = id;
    return this;
  }

  execute(): Observable<any> {
    return this.authorService.delete(this.id)
  }
}
