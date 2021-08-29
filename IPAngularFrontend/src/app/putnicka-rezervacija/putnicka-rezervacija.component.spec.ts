import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PutnickaRezervacijaComponent } from './putnicka-rezervacija.component';

describe('PutnickaRezervacijaComponent', () => {
  let component: PutnickaRezervacijaComponent;
  let fixture: ComponentFixture<PutnickaRezervacijaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PutnickaRezervacijaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PutnickaRezervacijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
