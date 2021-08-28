import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PorukeContainerComponent } from './poruke-container.component';

describe('PorukeContainerComponent', () => {
  let component: PorukeContainerComponent;
  let fixture: ComponentFixture<PorukeContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PorukeContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PorukeContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
