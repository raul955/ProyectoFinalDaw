import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizartodoComponent } from './visualizartodo.component';

describe('VisualizartodoComponent', () => {
  let component: VisualizartodoComponent;
  let fixture: ComponentFixture<VisualizartodoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisualizartodoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisualizartodoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
