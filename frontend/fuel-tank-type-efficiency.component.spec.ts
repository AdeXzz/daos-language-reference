import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelTankTypeEfficiencyComponent } from './fuel-tank-type-efficiency.component';

describe('FuelTankTypeEfficiencyComponent', () => {
  let component: FuelTankTypeEfficiencyComponent;
  let fixture: ComponentFixture<FuelTankTypeEfficiencyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FuelTankTypeEfficiencyComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FuelTankTypeEfficiencyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
