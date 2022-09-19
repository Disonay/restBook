import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Book} from "../../model/book/book";
import {SaveBookCommand} from "../../commands/save/save-book-command";
import {UpdateBookCommand} from "../../commands/update/update-book-command";
import {Author} from "../../model/author/author";
import {ListAuthorCommand} from "../../commands/list/list-author-command";

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent implements OnInit {
  title: String
  bookForm: FormGroup
  book: Book = new Book()
  authors: Author[]
  loading: boolean = false
  isUpdate: boolean = false

  constructor(private route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder,
              private saver: SaveBookCommand,
              private updater: UpdateBookCommand,
              private allAuthorsGetter: ListAuthorCommand) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params["id"] && params["title"] && params["authorId"] && params["publicationDate"]) {
        this.isUpdate = true
        this.book = new Book(params["id"], params["title"], params["authorId"], params["publicationDate"])
      }
    });

    this.allAuthorsGetter.execute().subscribe(data => {
      this.authors = data
    })

    if (this.isUpdate) {
      this.title = "Редактировать книгу"
    } else {
      this.title = "Добавить книгу"
    }

    this.bookForm = this.fb.group({
      authorId: ['', Validators.required],
      title: ['', Validators.required],
      publicationDate: ['', Validators.required],
    });
  }

  onSubmit() {
    this.loading = true

    if (this.isUpdate) {
      this.updater.payload(this.book.id, this.bookForm.value).execute().subscribe(result => this.gotoBookList())
    } else {
      this.saver.payload(this.bookForm.value).execute().subscribe(result => this.gotoBookList())
    }

  }

  gotoBookList() {
    this.router.navigate(['books'])
  }
}
