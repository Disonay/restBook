import {Command} from "../command";
import {BookService} from "../../service/book/book.service";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Filter} from "../../model/filter/filter";

@Injectable({
  providedIn: 'root'
})
export class FilterBookCommand implements Command {
  private filter: Filter;

  constructor(private bookService: BookService) {
  }

  payload(filter: Filter): Command {
    this.filter = filter;
    return this;
  }

  execute(): Observable<any> {
    return this.bookService.filter(this.filter)
  }
}
