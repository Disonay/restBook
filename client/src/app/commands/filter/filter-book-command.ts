import {Command} from "../command";
import {BookService} from "../../service/book/book.service";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FilterBookCommand implements Command {
  private filter: String;

  constructor(private bookService: BookService) {
  }

  payload(filter: String): Command {
    this.filter = filter;
    return this;
  }

  execute(): Observable<any> {
    return this.bookService.filter(this.filter)
  }
}
