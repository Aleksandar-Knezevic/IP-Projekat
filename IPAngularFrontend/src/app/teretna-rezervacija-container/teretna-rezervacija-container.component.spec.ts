import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeretnaRezervacijaContainerComponent } from './teretna-rezervacija-container.component';

describe('TeretnaRezervacijaContainerComponent', () => {
  let component: TeretnaRezervacijaContainerComponent;
  let fixture: ComponentFixture<TeretnaRezervacijaContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeretnaRezervacijaContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeretnaRezervacijaContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
