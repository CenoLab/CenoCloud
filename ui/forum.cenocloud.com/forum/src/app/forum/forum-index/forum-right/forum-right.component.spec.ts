import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumRightComponent } from './forum-right.component';

describe('ForumRightComponent', () => {
  let component: ForumRightComponent;
  let fixture: ComponentFixture<ForumRightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumRightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumRightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
