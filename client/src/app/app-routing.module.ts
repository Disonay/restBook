import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BookListComponent} from "./book-list/book-list.component";
import {BookFormComponent} from "./book-form/book-form.component";
import {TableResolverService} from "./resolver/table-resolver.service";

const routes: Routes = [
  {path: '', component: BookListComponent, data: {animation: 'listPage'}, resolve: {table: TableResolverService}},
  {path: 'create', component: BookFormComponent, data: {animation: 'createPage'}},
  {path: 'update', component: BookFormComponent, data: {animation: 'updatePage'}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
