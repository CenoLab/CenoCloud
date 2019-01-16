import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumQuestionDetailComponent } from './forum-question-detail.component';

describe('ForumQuestionDetailComponent', () => {
  let component: ForumQuestionDetailComponent;
  let fixture: ComponentFixture<ForumQuestionDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumQuestionDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumQuestionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
