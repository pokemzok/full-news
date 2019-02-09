import {MediaMatcher} from '@angular/cdk/layout';
import {ChangeDetectorRef, Component, OnDestroy} from '@angular/core';
import {NewsCategoryFactory} from './news-category.factory';
import {Tuple} from '../common/tuple';
import {NewsService} from './news.service';
import {Article} from './article/article';
import {NEWS_COUNTRY} from '../../environments/environment';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnDestroy {
  private readonly mobileQueryListener: () => void;
  mobileQuery: MediaQueryList;
  categories: Array<Tuple<string>>;
  articles: Array<Article>;

  constructor(
    changeDetectorRef: ChangeDetectorRef,
    media: MediaMatcher,
    private newsService: NewsService,
    private route: ActivatedRoute
  ) {
    this.mobileQuery = media.matchMedia('(max-width: 1200px)');
    this.mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addEventListener('screenResize', this.mobileQueryListener);
    this.categories = NewsCategoryFactory.categories();
    this.route.paramMap.subscribe( params => this.selectCategory(params.get('category')));
  }

  ngOnDestroy(): void {
    this.mobileQuery.removeEventListener('screenResize', this.mobileQueryListener);
  }

  selectCategory(key: string) {
    this.newsService.getNews(key, NEWS_COUNTRY)
      .subscribe(response => this.articles = response.articles);
  }
}
