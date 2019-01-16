import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumLeftComponent } from './forum-left.component';

describe('ForumLeftComponent', () => {
  let component: ForumLeftComponent;
  let fixture: ComponentFixture<ForumLeftComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumLeftComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumLeftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
