import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {ActivatedRoute, Router} from "@angular/router";
import {Author} from "../../model/author/author";
import {DeleteAuthorCommand} from "../../commands/delete/delete-author-command";

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.css']
})
export class AuthorListComponent implements AfterViewInit, OnInit {

  displayedColumns: string[] = ['id', 'surname', 'name', 'middleName', 'menu'];
  dataSource: MatTableDataSource<Author> = new MatTableDataSource<Author>()
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  deletingAuthorId: number

  constructor(private route: ActivatedRoute,
              private router: Router,
              private deleter: DeleteAuthorCommand) {
  }

  ngOnInit(): void {
    this.dataSource.data = this.route.snapshot.data.table
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  onDelete(id: number) {
    this.deletingAuthorId = id
    this.deleter.payload(id).execute().subscribe(result => {
      this.dataSource.data = this.dataSource.data.filter(item => item.id != id)
    })
  }

  onUpdate(author: Author) {
    this.router.navigate(['authors/update', {
      id: author.id,
      name: author.name,
      surname: author.surname,
      middleName: author.middleName
    }])
  }
}
