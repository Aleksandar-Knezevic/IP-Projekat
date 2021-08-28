import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoviPutnickiLetComponent } from './novi-putnicki-let.component';

describe('NoviPutnickiLetComponent', () => {
  let component: NoviPutnickiLetComponent;
  let fixture: ComponentFixture<NoviPutnickiLetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NoviPutnickiLetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NoviPutnickiLetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
