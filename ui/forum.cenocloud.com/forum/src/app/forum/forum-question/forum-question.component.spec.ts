import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumQuestionComponent } from './forum-question.component';

describe('ForumQuestionComponent', () => {
  let component: ForumQuestionComponent;
  let fixture: ComponentFixture<ForumQuestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumQuestionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
