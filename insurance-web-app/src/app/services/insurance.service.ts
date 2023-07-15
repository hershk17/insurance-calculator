import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Driver } from '../models/driver';
import { Quote } from '../models/quote';

@Injectable()
export class InsuranceService {
  baseUrl: string = 'http://localhost:8080';
  calculateParam: string = '/calculate';
  quotesParam: string = '/quotes';

  constructor(private http: HttpClient) {}

  public getCarModels() {
    return this.http.get('https://storage.googleapis.com/connex-th/insurance_assignment/car_model.json');
  }

  public getNewQuote(driver: Driver) {
    return this.http.post(this.baseUrl + this.calculateParam, driver, { responseType: 'text' });
  }

  public getQuoteByReference(reference: string) {
    return this.http.get<Quote>(this.baseUrl + this.quotesParam, {
      params: {
        reference: reference,
      },
    });
  }
}
