import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DriverListComponent } from './modules/driver/components/driver-list/driver-list.component';
import { DriverFormComponent } from './modules/driver/components/driver-form/driver-form.component';

const routes: Routes = [
  { path: 'drivers', component: DriverListComponent },
  { path: 'adddriver', component: DriverFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
