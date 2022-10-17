import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BookListComponent} from './list/book-list/book-list.component';
import {BookFormComponent} from './form/book-form/book-form.component';
import {BookTableResolverService} from './resolver/book/book-table-resolver.service';
import {AuthorTableResolverService} from './resolver/author/author-table-resolver.service';
import {AuthorFormComponent} from './form/author-form/author-form.component';
import {AuthorListComponent} from './list/author-list/author-list.component';
import {AuthGuard} from './guard/auth-guard';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  {path: '', redirectTo: 'books', pathMatch: 'full', canActivate: [AuthGuard]},
  {
    path: 'books',
    component: BookListComponent,
    data: {animation: 'bookListPage'},
    resolve: {table: BookTableResolverService},
    canActivate: [AuthGuard]
  },
  {path: 'books/create', component: BookFormComponent, data: {animation: 'createBookPage'}, canActivate: [AuthGuard]},
  {path: 'books/update', component: BookFormComponent, data: {animation: 'updateBookPage'}, canActivate: [AuthGuard]},

  {
    path: 'authors',
    component: AuthorListComponent,
    data: {animation: 'authorListPage'},
    resolve: {table: AuthorTableResolverService},
    canActivate: [AuthGuard]
  },
  {path: 'authors/create', component: AuthorFormComponent, data: {animation: 'createAuthorPage'}, canActivate: [AuthGuard]},
  {path: 'authors/update', component: AuthorFormComponent, data: {animation: 'updateAuthorPage'}, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent, data: {animation: 'updateAuthorPage'}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
