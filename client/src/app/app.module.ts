import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BookFormComponent} from './form/book-form/book-form.component';
import {BookListComponent} from './list/book-list/book-list.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {BookService} from './service/book/book.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatMenuModule} from '@angular/material/menu';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {CdkTableModule} from '@angular/cdk/table';
import {MatCardModule} from '@angular/material/card';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MenuComponent} from './menu/menu.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import { AuthorListComponent } from './list/author-list/author-list.component';
import { AuthorFormComponent } from './form/author-form/author-form.component';
import {MatSelectModule} from '@angular/material/select';
import { FilterFormComponent } from './form/filter-form/filter-form/filter-form.component';
import {LoginComponent} from './login/login.component';
import {AuthGuard} from './guard/auth-guard';
import {JwtInterceptor} from './interceptor/jwt-interceptor';

@NgModule({
  declarations: [
    AppComponent,
    BookFormComponent,
    BookListComponent,
    MenuComponent,
    AuthorListComponent,
    AuthorFormComponent,
    FilterFormComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatSortModule,
    MatInputModule,
    MatButtonModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    CdkTableModule,
    MatCardModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatTooltipModule,
    MatSelectModule
  ],
  providers: [BookService, AuthGuard, {
    provide: HTTP_INTERCEPTORS,
    useClass: JwtInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
