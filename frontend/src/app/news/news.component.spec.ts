import {async, TestBed} from '@angular/core/testing';
import {NewsComponent} from './news.component';
import {ArticleComponent} from './article/article.component';
import {MockComponent, MockModule} from 'ng-mocks';
import {HttpClientModule} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';
import { of} from 'rxjs';


describe('NewsComponent tests', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        MockModule(HttpClientModule)
      ],
      declarations: [
        NewsComponent, MockComponent(ArticleComponent)
      ],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: {
            paramMap: of({category: 'technology'})
          }
        }
      ]
    });
  }));

  it('should create news component', () => {
    const fixture = TestBed.createComponent(NewsComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

});
