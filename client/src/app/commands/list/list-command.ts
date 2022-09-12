import {Command} from "../command";
import {BookService} from "../../service/book.service";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ListCommand implements Command {
  constructor(private bookService: BookService) {
  }

  execute(): Observable<any> {
    return this.bookService.findAll()
  }
}
