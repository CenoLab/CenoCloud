import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HeaderComponent } from './cenocloud/header/header.component';
import { FooterComponent } from './cenocloud/footer/footer.component';
import { BannerComponent } from './cenocloud/banner/banner.component';
import { SuperiorityComponent } from './cenocloud/superiority/superiority.component';
import { ScenariosComponent } from './cenocloud/scenarios/scenarios.component';
import { DevicesComponent } from './cenocloud/devices/devices.component';
import { CollaborateComponent } from './cenocloud/collaborate/collaborate.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BannerComponent,
    SuperiorityComponent,
    ScenariosComponent,
    DevicesComponent,
    CollaborateComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
