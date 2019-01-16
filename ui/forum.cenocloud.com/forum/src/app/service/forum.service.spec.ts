import { TestBed, inject } from '@angular/core/testing';

import { ForumService } from './forum.service';

describe('ForumService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ForumService]
    });
  });

  it('should be created', inject([ForumService], (service: ForumService) => {
    expect(service).toBeTruthy();
  }));
});
