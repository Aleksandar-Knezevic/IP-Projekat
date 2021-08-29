import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeretnaRezervacijaComponent } from './teretna-rezervacija.component';

describe('TeretnaRezervacijaComponent', () => {
  let component: TeretnaRezervacijaComponent;
  let fixture: ComponentFixture<TeretnaRezervacijaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeretnaRezervacijaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeretnaRezervacijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
