import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {NewsComponent} from './news.component';
import {ArticleComponent} from './article/article.component';
import {MockComponent, MockModule} from 'ng-mocks';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {ActivatedRoute} from '@angular/router';
import {of} from 'rxjs';


describe('NewsComponent tests', () => {

  let component: NewsComponent;
  let fixture: ComponentFixture<NewsComponent>;

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
            paramMap: of({
              get: function get() {
                return 'technology';
              }
            })
          }
        },
        {
          provide: HttpClient,
          useValue: {
            get: function get() {
              return of(
                {
                  country: 'pl',
                  category: 'technology',
                  articles: []
                }
              );
            }
          }
        }
      ]
    });
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewsComponent);
    component = fixture.debugElement.componentInstance;
  });

  it('should create news component', () => {
    expect(component).toBeTruthy();
  });

  it('should get an empty array of articles from service', () => {
    expect(component.articles).toEqual([]);
  });
});
