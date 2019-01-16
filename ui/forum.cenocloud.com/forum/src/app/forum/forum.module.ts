import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { ApiService } from '../service/api.service';
import { ForumComponent } from './forum.component';
import { ForumRoutingModule } from './forum-routing.module';
import { ForumLeftComponent } from './forum-index/forum-left/forum-left.component';
import { ForumRightComponent } from './forum-index/forum-right/forum-right.component';
import { ForumIndexComponent } from './forum-index/forum-index.component';
import { ForumArticleComponent } from './forum-article/forum-article.component';
import { ForumRightFunctionComponent } from './forum-right-function/forum-right-function.component';
import { ForumNewComponent } from './forum-new/forum-new.component';
import { QuillModule } from 'ngx-quill';
import { ForumQuestionComponent } from './forum-question/forum-question.component';
import { ModalLogComponent } from './modal-log/modal-log.component';
import { ForumQuestionDetailComponent } from './forum-question-detail/forum-question-detail.component';
import { RouteReuseStrategy } from '@angular/router';
import { SimpleReuseStrategy } from './SimpleReuseStrategy';

@NgModule({
  declarations: [
      ForumLeftComponent,
      ForumRightComponent,
      ForumIndexComponent,
      ForumArticleComponent,
      ForumRightFunctionComponent,
      ForumNewComponent,
      ForumQuestionComponent,
      ModalLogComponent,
      ForumQuestionDetailComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    ForumRoutingModule,
    QuillModule
  ],
  providers: [
    ApiService,
    { provide: RouteReuseStrategy, useClass: SimpleReuseStrategy }
  ],
  bootstrap: [ForumComponent]
})
export class ForumModule { }
