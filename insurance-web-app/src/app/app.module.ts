import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DriverListComponent } from './modules/driver/components/driver-list/driver-list.component';
import { DriverFormComponent } from './modules/driver/components/driver-form/driver-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DriverService } from './modules/driver/services/driver.service';

@NgModule({
  declarations: [AppComponent, DriverListComponent, DriverFormComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule, ReactiveFormsModule],
  providers: [DriverService],
  bootstrap: [AppComponent],
})
export class AppModule {}
