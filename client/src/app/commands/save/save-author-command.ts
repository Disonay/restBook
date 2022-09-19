import {Injectable} from "@angular/core";
import {Command} from "../command";
import {Observable} from "rxjs";
import {AuthorService} from "../../service/author/author.service";
import {Author} from "../../model/author/author";

@Injectable({
  providedIn: 'root'
})
export class SaveAuthorCommand implements Command {
  author: Author

  constructor(private authorService: AuthorService) {
  }

  payload(author: Author): Command {
    this.author = author;
    return this
  }

  execute(): Observable<any> {
    return this.authorService.save(this.author)
  }
}
