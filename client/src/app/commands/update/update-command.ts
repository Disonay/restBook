import {Command} from "../command";
import {BookService} from "../../service/book.service";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Book} from "../../model/book";

@Injectable({
  providedIn: 'root'
})
export class UpdateCommand implements Command {
  id : number
  book: Book

  constructor(private bookService: BookService) {
  }

  payload(id: number, book: Book): UpdateCommand {
    this.book = book;
    this.id = id;

    return this
  }

  execute(): Observable<any> {
    return this.bookService.update(this.id, this.book)
  }
}
