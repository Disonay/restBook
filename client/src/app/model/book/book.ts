export class Book {
  constructor(id?: number, title?: string, authorId?: number, publicationDate?: Date) {
    this.id = id
    this.title = title
    this.authorId = authorId
    this.publicationDate = publicationDate
  }

  id: number;
  title: string;
  authorId: number;
  publicationDate: Date;
}
