import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { InsuranceService } from 'src/app/services/insurance.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  constructor(private router: Router) {}
  
  getQuoteClicked() {
    this.router.navigate(['/calculate']);
  }
}
