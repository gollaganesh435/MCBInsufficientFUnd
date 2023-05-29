import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FundAvailabilityListComponent } from './fund-availability-list/fund-availability-list.component';
import { SideNavComponent } from './side-nav/side-nav.component';
import { FundApprovalComponent } from './fund-approval/fund-approval.component';
import { FundApprovalAnsweredComponent } from './fund-approval-answered/fund-approval-answered.component';
import { AvilabilityDashboardComponent } from './avilability-dashboard/avilability-dashboard.component';
import { ViewItemComponent } from './view-item/view-item.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FundAvailabilityListComponent,
    SideNavComponent,
    FundApprovalComponent,
    FundApprovalAnsweredComponent,
    AvilabilityDashboardComponent,
    ViewItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
