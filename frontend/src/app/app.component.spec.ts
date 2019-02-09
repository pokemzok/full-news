import {TestBed, async} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {MaterialModule} from './material-module';
import {TranslateModule} from '@ngx-translate/core';
import {MockComponent, MockModule} from 'ng-mocks';
import {NewsComponent} from './news/news.component';
import {RouterModule} from '@angular/router';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';

describe('AppComponent tests', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        MaterialModule,
        MockModule(TranslateModule),
        RouterModule.forRoot([]),
        NoopAnimationsModule
      ],
      declarations: [
        AppComponent, MockComponent(NewsComponent)
      ],
    });
  }));

  it('should create root app component', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });
});
