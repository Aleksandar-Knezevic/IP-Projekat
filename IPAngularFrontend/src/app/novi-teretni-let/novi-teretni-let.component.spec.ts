import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoviTeretniLetComponent } from './novi-teretni-let.component';

describe('NoviTeretniLetComponent', () => {
  let component: NoviTeretniLetComponent;
  let fixture: ComponentFixture<NoviTeretniLetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NoviTeretniLetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NoviTeretniLetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
