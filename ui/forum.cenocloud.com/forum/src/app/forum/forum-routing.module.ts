import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForumIndexComponent } from './forum-index/forum-index.component';
import { ForumComponent } from './forum.component';
import { ForumArticleComponent } from './forum-article/forum-article.component';
import { ForumNewComponent } from './forum-new/forum-new.component';
import { ForumQuestionComponent } from './forum-question/forum-question.component';
import { AuthGuardService } from '../service/auth-guard.service';
import { ForumQuestionDetailComponent } from './forum-question-detail/forum-question-detail.component';


const routes: Routes = [
  { path: 'forum', component: ForumComponent,
    children:[
        {
            path:"",
            redirectTo:"index", 
            pathMatch:'full',
        },
        {
            path:"index",
            component:ForumIndexComponent
        },
        {
            path:"article/:id",
            component:ForumArticleComponent,
        },
        {
            path:"new",
            canActivate:[AuthGuardService],
            component:ForumNewComponent
        },
        {
            path:"question",
            canActivate:[AuthGuardService],
            component:ForumQuestionComponent
        },
        {
            path:"questionDetail/:id",
            canActivate:[AuthGuardService],
            component:ForumQuestionDetailComponent
        }
    ]
}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ],
})
export class ForumRoutingModule {}