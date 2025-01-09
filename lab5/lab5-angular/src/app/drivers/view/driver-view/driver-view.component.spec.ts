import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverViewComponent } from './driver-view.component';

describe('CharacterViewComponent', () => {
  let component: DriverViewComponent;
  let fixture: ComponentFixture<DriverViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DriverViewComponent]
    });
    fixture = TestBed.createComponent(DriverViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
