import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeretniLetComponent } from './teretni-let.component';

describe('TeretniLetComponent', () => {
  let component: TeretniLetComponent;
  let fixture: ComponentFixture<TeretniLetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeretniLetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeretniLetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
