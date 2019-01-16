import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumRightFunctionComponent } from './forum-right-function.component';

describe('ForumRightFunctionComponent', () => {
  let component: ForumRightFunctionComponent;
  let fixture: ComponentFixture<ForumRightFunctionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumRightFunctionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumRightFunctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
