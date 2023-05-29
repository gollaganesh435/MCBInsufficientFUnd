import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { FundAvailabilityListComponent } from './fund-availability-list/fund-availability-list.component';
import { FundApprovalComponent } from './fund-approval/fund-approval.component';
import { FundApprovalAnsweredComponent } from './fund-approval-answered/fund-approval-answered.component';
import { AvilabilityDashboardComponent } from './avilability-dashboard/avilability-dashboard.component';
import { AuthGuard } from './service/auth-guard.service';

const routes: Routes = [
  {path: '', component: LoginComponent,canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'approval', component: FundApprovalComponent,canActivate: [AuthGuard]},
  {path: 'verified', component: FundApprovalAnsweredComponent,canActivate: [AuthGuard]},
  {path: 'fundsList', component: FundAvailabilityListComponent,canActivate: [AuthGuard]},
  {path: 'dashboard', component: AvilabilityDashboardComponent,canActivate: [AuthGuard]},
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
