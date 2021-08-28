import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PutnickiLetComponent } from './putnicki-let.component';

describe('PutnickiLetComponent', () => {
  let component: PutnickiLetComponent;
  let fixture: ComponentFixture<PutnickiLetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PutnickiLetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PutnickiLetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
