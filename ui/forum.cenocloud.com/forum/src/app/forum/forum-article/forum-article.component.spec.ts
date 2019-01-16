import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumArticleComponent } from './forum-article.component';

describe('ForumArticleComponent', () => {
  let component: ForumArticleComponent;
  let fixture: ComponentFixture<ForumArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
