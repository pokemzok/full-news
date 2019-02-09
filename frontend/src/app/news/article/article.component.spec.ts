import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ArticleComponent} from './article.component';
import {TranslateModule} from '@ngx-translate/core';
import {MockModule} from 'ng-mocks';


describe('ArticleComponent tests', () => {
  let component: ArticleComponent;
  let fixture: ComponentFixture<ArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [MockModule(TranslateModule)],
      declarations: [ArticleComponent]
    });
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleComponent);
    component = fixture.componentInstance;
    component.article = {
      articleUrl: 'url',
      author: 'Melon Ask',
      date: '2019-02-09',
      description: 'Tesla Model 3 is topping many lists these days like best-selling all-electric vehicles, best value retention..',
      imageUrl: 'url',
      sourceName: 'Electrek.co',
      title: 'Tesla Model 3 tops list of vehicles that ‘bring the most joy’ - Electrek'
    };
    fixture.detectChanges();
  });

  it('should create an article component', () => {
    expect(component).toBeTruthy();
  });
});
