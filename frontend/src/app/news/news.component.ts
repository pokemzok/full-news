import {MediaMatcher} from '@angular/cdk/layout';
import {ChangeDetectorRef, Component, OnDestroy} from '@angular/core';
import {NewsTopicsService} from './news-topics.service';
import {Tuple} from '../common/tuple';
import {NewsService} from './news.service';
import {Article} from './article/article';

@Component({
  selector: 'app-root',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnDestroy {
  private readonly mobileQueryListener: () => void;
  mobileQuery: MediaQueryList;
  categories: Array<Tuple<string>>;
  articles: Array<Article>;

  // FIXME navbar always present for width = 1200 px
  // FIXME first navbar category is hiding on smaller screen
  // FIXME article is hiding under toolbar on smaller screen
  constructor(
    changeDetectorRef: ChangeDetectorRef,
    media: MediaMatcher,
    newsTopicsService: NewsTopicsService,
    newsService: NewsService
  ) {
    this.mobileQuery = media.matchMedia('(max-width: 768px)');
    this.mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addEventListener('screenResize', this.mobileQueryListener);
    this.categories = newsTopicsService.getTopics(); // FIXME make selected category shine (background color change)
    newsService.getNews('technology', 'pl') // FIXME change country and category on select
      .subscribe(response => this.articles = response.articles);
  }

  ngOnDestroy(): void {
    this.mobileQuery.removeEventListener('screenResize', this.mobileQueryListener);
  }

}
