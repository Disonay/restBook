import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Author} from "../../model/author/author";
import {UpdateAuthorCommand} from "../../commands/update/update-author-command";
import {SaveAuthorCommand} from "../../commands/save/save-author-command";

@Component({
  selector: 'app-author-form',
  templateUrl: './author-form.component.html',
  styleUrls: ['./author-form.component.css']
})
export class AuthorFormComponent implements OnInit {
  title: String
  authorForm: FormGroup
  author: Author = new Author()
  loading: boolean = false
  isUpdate: boolean = false

  constructor(private route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder,
              private saver: SaveAuthorCommand,
              private updater: UpdateAuthorCommand) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params["id"] && params["surname"] && params["name"] && params["middleName"]) {
        this.isUpdate = true
        this.author = new Author(params["id"], params["surname"], params["name"], params["middleName"])
      }
    });

    if (this.isUpdate) {
      this.title = "Редактировать данные автора"
    } else {
      this.title = "Добавить автора"
    }

    this.authorForm = this.fb.group({
      surname: ['', Validators.required],
      name: ['', Validators.required],
      middleName: ['', Validators.required],
    });
  }

  onSubmit() {
    this.loading = true

    if (this.isUpdate) {
      this.updater.payload(this.author.id, this.authorForm.value).execute().subscribe(result => this.gotoAuthorList())
    } else {
      this.saver.payload(this.authorForm.value).execute().subscribe(result => this.gotoAuthorList())
    }

  }

  gotoAuthorList() {
    this.router.navigate(['authors'])
  }

}
