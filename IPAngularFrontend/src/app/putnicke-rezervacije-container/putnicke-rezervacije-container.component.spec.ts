import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PutnickeRezervacijeContainerComponent } from './putnicke-rezervacije-container.component';

describe('PutnickeRezervacijeContainerComponent', () => {
  let component: PutnickeRezervacijeContainerComponent;
  let fixture: ComponentFixture<PutnickeRezervacijeContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PutnickeRezervacijeContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PutnickeRezervacijeContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
