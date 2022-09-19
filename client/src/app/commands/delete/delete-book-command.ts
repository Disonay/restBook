import {Command} from "../command";
import {BookService} from "../../service/book/book.service";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class DeleteBookCommand implements Command {
  private id: number;

  constructor(private bookService: BookService) {
  }

  payload(id: number): Command {
    this.id = id;
    return this;
  }

  execute(): Observable<any> {
    return this.bookService.delete(this.id)
  }
}
