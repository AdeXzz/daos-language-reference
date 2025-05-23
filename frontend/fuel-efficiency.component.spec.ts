import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelEfficiencyComponent } from './fuel-efficiency.component';

describe('FuelEfficiencyComponent', () => {
  let component: FuelEfficiencyComponent;
  let fixture: ComponentFixture<FuelEfficiencyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FuelEfficiencyComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FuelEfficiencyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
