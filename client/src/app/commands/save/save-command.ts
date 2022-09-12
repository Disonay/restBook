import {Command} from "../command";
import {BookService} from "../../service/book.service";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Book} from "../../model/book";

@Injectable({
  providedIn: 'root'
})
export class SaveCommand implements Command {
  book: Book

  constructor(private bookService: BookService) {
  }

  payload(book: Book): Command {
    this.book = book;
    return this
  }

  execute(): Observable<any> {
    return this.bookService.save(this.book)
  }
}
