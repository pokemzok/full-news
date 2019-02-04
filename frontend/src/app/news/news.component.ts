import {MediaMatcher} from '@angular/cdk/layout';
import {ChangeDetectorRef, Component, OnDestroy} from '@angular/core';
import {NewsTopicsService} from './news-topics.service';
import {Tuple} from '../common/tuple';
import {NewsService} from './news.service';

@Component({
  selector: 'app-root',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnDestroy {
  private readonly mobileQueryListener: () => void;
  mobileQuery: MediaQueryList;
  categories: Array<Tuple<string>>;

  articles = Array.from({length: 50}, () =>
    `Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
       labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
       laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
       voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
       cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.`);

  // FIXME navbar always present for width = 1200 px
  // FIXME first navbar category is hiding on smaller screen
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
    newsService.getNews('technology', 'pl')
      .subscribe(response => this.articles = response.articles); // FIXME test in erroneus conditions
  }

  ngOnDestroy(): void {
    this.mobileQuery.removeEventListener('screenResize', this.mobileQueryListener);
  }

}
