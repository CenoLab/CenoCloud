import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumNewComponent } from './forum-new.component';

describe('ForumNewComponent', () => {
  let component: ForumNewComponent;
  let fixture: ComponentFixture<ForumNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
