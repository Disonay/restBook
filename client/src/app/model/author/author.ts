export class Author {
  constructor(id?: number, surname?: string, name?: string, middleName?: string) {
    this.id = id
    this.surname = surname
    this.name = name
    this.middleName = middleName
  }

  id: number;
  surname: string;
  name: string;
  middleName: string;
}
