import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Book} from "../../model/book/book";
import {ActivatedRoute, Router} from "@angular/router";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {DeleteBookCommand} from "../../commands/delete/delete-book-command";
import {ArchiveBookCommand} from "../../commands/archive/archive-book-command";
import {FilterBookCommand} from "../../commands/filter/filter-book-command";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements AfterViewInit, OnInit {
  displayedColumns: string[] = ['id', 'name', 'author', 'publicationDate', 'menu'];
  dataSource: MatTableDataSource<Book> = new MatTableDataSource<Book>()
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  waitingBookId: number;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private deleter: DeleteBookCommand,
              private archiver: ArchiveBookCommand,
              private filter: FilterBookCommand) {
  }

  ngOnInit(): void {
    this.dataSource.data = this.route.snapshot.data.table
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  onDelete(id: number) {
    this.waitingBookId = id
    this.deleter.payload(id).execute().subscribe(result => {
      this.dataSource.data = this.dataSource.data.filter(item => item.id != id)
    })
  }

  onArchive(id: number) {
    this.waitingBookId = id

    this.archiver.payload(id).execute().subscribe(result => {
      this.dataSource.data = this.dataSource.data.filter(item => item.id != id)
    })
  }

  onUpdate(book: Book) {
    this.router.navigate(['books/update', {
      id: book.id,
      title: book.title,
      author: book.author,
      publicationDate: book.publicationDate
    }])
  }

  onFilter(filter) {
    this.filter.payload(filter).execute().subscribe(data => {
      this.dataSource.data = data
    })
  }
}

