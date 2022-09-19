import {Observable} from "rxjs";

export interface Service<Model> {
  findAll(): Observable<any>

  save(model: Model)

  get(id: Number): Observable<Model>

  update(id: number, model: Model)

  delete(id: Number)
}
