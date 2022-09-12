import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Book} from "../model/book";
import {SaveCommand} from "../commands/save/save-command";
import {UpdateCommand} from "../commands/update/update-command";

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent {
  title: String
  bookForm: FormGroup
  book: Book = new Book()
  loading: boolean = false
  isUpdate: boolean = false

  constructor(private route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder,
              private saver: SaveCommand,
              private updater: UpdateCommand) {
    this.createForm()
  }

  private createForm() {
    this.route.params.subscribe(params => {
      if (params["id"] && params["name"] && params["author"] && params["publicationDate"]) {
        this.isUpdate = true
        this.book = new Book(params["id"], params["name"], params["author"], params["publicationDate"])
      }
    });

    if (this.isUpdate) {
      this.title = "Редактировать книгу"
    } else {
      this.title = "Добавить книгу"
    }

    this.bookForm = this.fb.group({
      author: ['', [Validators.required, Validators.pattern("[А-Я][а-я]+ [А-Я][.] [А-Я][.]")]],
      name: ['', Validators.required],
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
    this.router.navigate([''])
  }
}
