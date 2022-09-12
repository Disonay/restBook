export class Book {
  constructor(id?: number, name?: string, author?: string, publicationDate?: Date) {
    this.id = id
    this.name = name
    this.author = author
    this.publicationDate = publicationDate
  }

  id: number;
  name: string;
  author: string;
  publicationDate: Date;
}
