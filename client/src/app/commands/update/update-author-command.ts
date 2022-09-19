import {Injectable} from "@angular/core";
import {Command} from "../command";
import {Observable} from "rxjs";
import {Author} from "../../model/author/author";
import {AuthorService} from "../../service/author/author.service";

@Injectable({
  providedIn: 'root'
})
export class UpdateAuthorCommand implements Command {
  id: number
  author: Author

  constructor(private authorService: AuthorService) {
  }

  payload(id: number, author: Author): Command {
    this.author = author;
    this.id = id;

    return this
  }

  execute(): Observable<any> {
    return this.authorService.update(this.id, this.author)
  }
}
