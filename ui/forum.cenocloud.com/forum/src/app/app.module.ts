import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ForumNavComponent } from './forum/forum-nav/forum-nav.component';
import { HttpModule } from '@angular/http';
import { ApiService } from './service/api.service';
import { ForumFooterComponent } from './forum/forum-footer/forum-footer.component';
import { AppRoutingModule } from './app-routing.module';
import { ForumComponent } from './forum/forum.component';
import { ForumModule } from './forum/forum.module';

@NgModule({
  declarations: [
    AppComponent,
    ForumNavComponent,
    ForumFooterComponent,
    ForumComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    ForumModule,
    AppRoutingModule,
  ],
  providers: [
    ApiService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
