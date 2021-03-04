import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizartemaComponent } from './visualizartema.component';

describe('VisualizartemaComponent', () => {
  let component: VisualizartemaComponent;
  let fixture: ComponentFixture<VisualizartemaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisualizartemaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisualizartemaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
