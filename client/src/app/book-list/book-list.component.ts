import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Book} from "../model/book";
import {ActivatedRoute, Router} from "@angular/router";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {DeleteCommand} from "../commands/delete/delete-command";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements AfterViewInit, OnInit {
  displayedColumns: string[] = ['id', 'name', 'author', 'publicationDate', 'menu'];
  dataSource: MatTableDataSource<Book> = new MatTableDataSource<Book>()
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  deletingBookId: number

  constructor(private route: ActivatedRoute,
              private router: Router,
              private deleter: DeleteCommand) {
  }

  ngOnInit(): void {
    this.dataSource.data = this.route.snapshot.data.table
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  onDelete(id: number) {
    this.deletingBookId = id
    this.deleter.payload(id).execute().subscribe(result => {
      this.dataSource.data = this.dataSource.data.filter(item => item.id != id)
    })
  }

  onUpdate(book: Book) {
    this.router.navigate(['update', {
      id: book.id,
      name: book.name,
      author: book.author,
      publicationDate: book.publicationDate
    }])
  }

}

