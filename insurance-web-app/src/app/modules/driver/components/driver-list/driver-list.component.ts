import { Component } from '@angular/core';
import { DriverService } from '../../services/driver.service';
import { Driver } from '../../models/driver';

@Component({
  selector: 'app-driver-list',
  templateUrl: './driver-list.component.html',
  styleUrls: ['./driver-list.component.css'],
})
export class DriverListComponent {
  drivers: Driver[] = [];

  constructor(private driverService: DriverService) {}

  ngOnInit() {
    this.driverService.findAll().subscribe((data) => {
      this.drivers = data;
    });
  }
}
