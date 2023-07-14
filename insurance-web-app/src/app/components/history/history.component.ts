import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { InsuranceService } from 'src/app/services/insurance.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css'],
})
export class HistoryComponent {
  historyForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private insuranceService: InsuranceService) {
    this.historyForm = this.formBuilder.group({
      option: ['1', Validators.required],
      inputValue: ['', Validators.required],
    });
  }

  get form() {
    return this.historyForm.controls;
  }

  onSubmit() {
    this.historyForm.markAllAsTouched();

    if (this.historyForm.invalid) {
      return;
    }

    console.log(this.historyForm.value);

    let inputValue = this.form['inputValue'].value;
    if (this.form['option'].value === "1") {
      this.insuranceService.getQuoteByReference(inputValue).subscribe((res) => {
        console.log(res);
      });
    } else {
      this.insuranceService.getQuoteByLicenseNo(inputValue).subscribe((res) => {
        console.log(res);
      });
    }
  }
}
