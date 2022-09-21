import {Author} from "../author/author";

export class Book {
  constructor(id?: number, title?: string, author?: Author, publicationDate?: Date) {
    this.id = id
    this.title = title
    this.author = author
    this.publicationDate = publicationDate
  }

  id: number;
  title: string;
  author: Author;
  publicationDate: Date;
}
