import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MisticketsComponent } from './mistickets.component';

describe('MisticketsComponent', () => {
  let component: MisticketsComponent;
  let fixture: ComponentFixture<MisticketsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MisticketsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MisticketsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
