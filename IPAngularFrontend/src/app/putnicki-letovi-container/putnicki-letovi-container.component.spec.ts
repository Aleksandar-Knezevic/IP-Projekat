import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PutnickiLetoviContainerComponent } from './putnicki-letovi-container.component';

describe('PutnickiLetoviContainerComponent', () => {
  let component: PutnickiLetoviContainerComponent;
  let fixture: ComponentFixture<PutnickiLetoviContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PutnickiLetoviContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PutnickiLetoviContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
