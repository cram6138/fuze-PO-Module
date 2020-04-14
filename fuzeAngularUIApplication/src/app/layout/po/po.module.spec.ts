import { POModule } from './po.module';

describe('TablesModule', () => {
  let poModule: POModule;

  beforeEach(() => {
    poModule = new POModule();
  });

  it('should create an instance', () => {
    expect(poModule).toBeTruthy();
  });
});
