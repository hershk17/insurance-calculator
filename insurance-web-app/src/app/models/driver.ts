import { Quote } from "./quote";

export interface Driver {
  licenseNo: string;
  name: string;
  age: number;
  experience: number;
  faults: number;
  insuranceCount: number;
  insuranceClaims: number;
  vehicleAge: number;
  vehiclePurchasePrice: number;
  vehicleAnnualMileage: number;
  insuranceQuote?: Quote;
}
