import {Command} from "../command";
import {BookService} from "../../service/book/book.service";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Book} from "../../model/book/book";

@Injectable({
  providedIn: 'root'
})
export class UpdateBookCommand implements Command {
  id : number
  book: Book

  constructor(private bookService: BookService) {
  }

  payload(id: number, book: Book): Command {
    this.book = book;
    this.id = id;

    return this
  }

  execute(): Observable<any> {
    return this.bookService.update(this.id, this.book)
  }
}
