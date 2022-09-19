import {Injectable} from '@angular/core';
import {Service} from "../service";
import {Author} from "../../model/author/author";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthorService implements Service<Author>{

  private readonly authorUrl: string;

  constructor(private http: HttpClient) {
    this.authorUrl = environment.authorsBaseURL;
  }

  findAll(): Observable<any> {
    return this.http.get(`${this.authorUrl}`);
  }

  get(id: Number): Observable<Author> {
    return this.http.get<Author>(`${this.authorUrl}` + `${id}`)
  }

  save(author: Author) {
    return this.http.post(`${this.authorUrl}`, author);
  }

  update(id: number, author: Author) {
    return this.http.put(`${this.authorUrl}` + `${id}`, author)
  }

  delete(id: Number) {
    return this.http.delete(`${this.authorUrl}` + `${id}`)
  }

}
