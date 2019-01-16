import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumFooterComponent } from './forum-footer.component';

describe('ForumFooterComponent', () => {
  let component: ForumFooterComponent;
  let fixture: ComponentFixture<ForumFooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumFooterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
