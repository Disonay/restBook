import { TestBed } from '@angular/core/testing';

import { AuthorTableResolverService } from './author-table-resolver.service';

describe('AuthorTableResolverService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AuthorTableResolverService = TestBed.get(AuthorTableResolverService);
    expect(service).toBeTruthy();
  });
});
