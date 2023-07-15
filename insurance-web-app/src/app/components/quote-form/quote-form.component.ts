import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Driver } from '../../models/driver';
import { InsuranceService } from '../../services/insurance.service';

@Component({
  selector: 'app-driver-form',
  templateUrl: './quote-form.component.html',
  styleUrls: ['./quote-form.component.css'],
})
export class QuoteFormComponent {
  driverForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private insuranceService: InsuranceService) {
    this.driverForm = this.formBuilder.group({
      name: ['', Validators.required],
      age: ['', [Validators.required, Validators.min(18), Validators.max(150)]],
      experience: ['', [Validators.required, Validators.min(0), Validators.max(150)]],
      faults: ['', [Validators.required, Validators.min(0)]],
      insuranceCount: ['', [Validators.required, Validators.min(0)]],
      insuranceClaims: ['', [Validators.required, Validators.min(0)]],
      vehicleAge: ['', [Validators.required, Validators.min(0)]],
      vehiclePurchasePrice: ['', [Validators.required, Validators.min(0)]],
      vehicleAnnualMileage: ['', [Validators.required, Validators.min(0)]],
    });
  }

  get form() {
    return this.driverForm.controls;
  }

  falseSubmit() {
    var driverInfo: Driver = {
      id: 0,
      name: 'Harsh',
      age: 13,
      experience: 2,
      faults: 1,
      insuranceCount: 4,
      insuranceClaims: 3,
      vehicleAge: 4,
      vehiclePurchasePrice: 30000,
      vehicleAnnualMileage: 9000,
    };

    this.insuranceService.getNewQuote(driverInfo).subscribe((res: string) => {
      if (!res) {
        // show error message
      }
      this.router.navigate(['quotes'], { queryParams: { reference: res } });
    });
  }

  falseSubmit2() {
    var driverInfo: Driver = {
      id: 0,
      name: 'Harsh',
      age: 13,
      experience: 2,
      faults: 1,
      insuranceCount: 4,
      insuranceClaims: 3,
      vehicleAge: 4,
      vehiclePurchasePrice: 30000222,
      vehicleAnnualMileage: 9000,
    };

    this.insuranceService.getNewQuote(driverInfo).subscribe((res: string) => {
      if (!res) {
        // show error message
      }
      this.router.navigate(['quotes'], { queryParams: { reference: res } });
    });
  }

  onSubmit() {
    this.driverForm.markAllAsTouched();

    if (this.driverForm.invalid) {
      return;
    }

    var driverInfo: Driver = {
      name: this.form['name'].value,
      age: this.form['age'].value,
      experience: this.form['experience'].value,
      faults: this.form['faults'].value,
      insuranceCount: this.form['insuranceCount'].value,
      insuranceClaims: this.form['insuranceClaims'].value,
      vehicleAge: this.form['vehicleAge'].value,
      vehiclePurchasePrice: this.form['vehiclePurchasePrice'].value,
      vehicleAnnualMileage: this.form['vehicleAnnualMileage'].value,
    };

    this.insuranceService.getNewQuote(driverInfo).subscribe((res: string) => {
      if (!res) {
        // show error message
      }
      this.router.navigate(['quotes'], { queryParams: { reference: res } });
    });
  }
}
