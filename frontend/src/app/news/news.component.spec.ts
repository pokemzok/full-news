import { TestBed, async } from '@angular/core/testing';
import { NewsComponent } from './news.component';

describe('NewsComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        NewsComponent
      ],
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(NewsComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'Full News Frontend'`, () => {
    const fixture = TestBed.createComponent(NewsComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('Full News Frontend');
  });

  it('should render title in a h1 tag', () => {
    const fixture = TestBed.createComponent(NewsComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Welcome to Full News Frontend!');
  });
});
