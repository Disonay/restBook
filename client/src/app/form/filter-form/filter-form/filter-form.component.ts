import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-filter-form',
  templateUrl: './filter-form.component.html',
  styleUrls: ['./filter-form.component.css']
})
export class FilterFormComponent implements OnInit {
  filterForm: FormGroup
  @Output() onFilter = new EventEmitter<any>();

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.filterForm = this.fb.group({
      title: ['', Validators.required],
      name: ['', Validators.required],
    });
  }

  onFiltered() {
    console.log(this.filterForm.value);
    this.onFilter.emit(this.filterForm.value);
  }
}
