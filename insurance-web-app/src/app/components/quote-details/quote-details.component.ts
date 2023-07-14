import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Quote } from 'src/app/models/quote';
import { InsuranceService } from 'src/app/services/insurance.service';

@Component({
  selector: 'app-quote-details',
  templateUrl: './quote-details.component.html',
  styleUrls: ['./quote-details.component.css'],
})
export class QuoteDetailsComponent {
  referenceForm: FormGroup;
  quote?: Quote;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private insuranceService: InsuranceService
  ) {
    this.referenceForm = this.formBuilder.group({
      reference: ['', [Validators.required, Validators.minLength(16), Validators.maxLength(16)]],
    });
    this.route.queryParams.subscribe((params) => {
      let reference = params['reference'];
      if (!reference) {
        return;
      }
      this.insuranceService.getQuoteByReference(reference).subscribe((res: Quote) => {
        if (!res) {
          return;
        }
        this.quote = res;
      });
    });
  }

  get form() {
    return this.referenceForm.controls;
  }

  onSubmit() {
    this.referenceForm.markAllAsTouched();
    if (this.referenceForm.invalid) {
      return;
    }
    this.router.navigate([], {
      relativeTo: this.route,
      queryParams: {
        reference: this.form['reference'].value,
      },
    });
  }
}
