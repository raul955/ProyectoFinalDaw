import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultartareasComponent } from './consultartareas.component';

describe('ConsultartareasComponent', () => {
  let component: ConsultartareasComponent;
  let fixture: ComponentFixture<ConsultartareasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultartareasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultartareasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
