import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Driver } from '../../models/driver';
import { DriverService } from '../../services/driver.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-driver-form',
  templateUrl: './driver-form.component.html',
  styleUrls: ['./driver-form.component.css'],
})
export class DriverFormComponent {
  driverForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private driverService: DriverService
  ) {
    this.driverForm = this.formBuilder.group({
      licenseNo: ['', Validators.required],
      name: ['', Validators.required],
      age: ['', [Validators.required, Validators.min(18)]],
      experience: ['', [Validators.required, Validators.min(0)]],
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
      licenseNo: 'ABCD123',
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

    this.driverService.calculateInsurance(driverInfo).subscribe((res) => {
      console.log(res);
    });
  }

  onSubmit() {
    this.driverForm.markAllAsTouched();

    if (this.driverForm.invalid) {
      return;
    }

    var driverInfo: Driver = {
      licenseNo: this.form['licenseNo'].value,
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

    this.driverService.calculateInsurance(driverInfo).subscribe((res) => {
      console.log(res);
      this.router.navigate(['/drivers']);
    });
  }
}
