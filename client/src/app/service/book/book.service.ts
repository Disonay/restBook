import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Book} from "../../model/book/book";
import {environment} from "../../../environments/environment";
import {Service} from "../service";

@Injectable()
export class BookService implements Service<Book>{

  private readonly booksUrl: string;

  constructor(private http: HttpClient) {
    this.booksUrl = environment.booksBaseURL;
  }

  public findAll(): Observable<any> {
    return this.http.get(`${this.booksUrl}`);
  }

  public save(book: Book) {
    return this.http.post(`${this.booksUrl}`, book);
  }

  public delete(id: Number) {
    return this.http.delete(`${this.booksUrl}` + `${id}`)
  }

  public archive(id: Number) {
    return this.http.delete(`${this.booksUrl}` + 'soft/' + `${id}`)
  }

  public get(id: Number): Observable<Book> {
    return this.http.get<Book>(`${this.booksUrl}` +  `${id}`)
  }

  public update(id: number, book: Book) {
    return this.http.put(`${this.booksUrl}` + `${id}`, book)
  }

  public filter(search: String) {
    return this.http.get(`${this.booksUrl}` + "search/?search=" + search)
  }
}
