import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Driver } from '../models/driver';
import { Quote } from '../models/quote';

@Injectable()
export class InsuranceService {
  baseUrl: string = 'http://localhost:8080';
  driversParam: string = '/drivers';
  calculateParam: string = '/calculate';
  quotesParam: string = '/quotes';

  constructor(private http: HttpClient) {}

  public getNewQuote(driver: Driver) {
    return this.http.post<Driver>(this.baseUrl + this.calculateParam, driver);
  }

  public getQuoteByReference(reference: string) {
    return this.http.get<Quote>(this.baseUrl + this.quotesParam, {
      params: {
        reference: reference,
      },
    });
  }

  public getQuoteByLicenseNo(licenseNo: string) {
    return this.http.get<Quote>(this.baseUrl + this.quotesParam, {
      params: {
        licenseNo: licenseNo,
      },
    });
  }
}
