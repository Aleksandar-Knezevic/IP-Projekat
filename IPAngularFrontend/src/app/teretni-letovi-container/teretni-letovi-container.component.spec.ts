import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeretniLetoviContainerComponent } from './teretni-letovi-container.component';

describe('TeretniLetoviContainerComponent', () => {
  let component: TeretniLetoviContainerComponent;
  let fixture: ComponentFixture<TeretniLetoviContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TeretniLetoviContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TeretniLetoviContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
