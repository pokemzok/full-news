import {ChangeDetectorRef, Component, OnDestroy} from '@angular/core';
import {NewsCategoryFactory} from './common/news-category.factory';
import {MediaMatcher} from '@angular/cdk/layout';
import {Tuple} from './common/tuple';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnDestroy {

  private readonly mobileQueryListener: () => void;
  mobileQuery: MediaQueryList;
  categories: Array<Tuple<string>>;

  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher) {
    this.mobileQuery = media.matchMedia('(max-width: 1200px)');
    this.mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addEventListener('screenResize', this.mobileQueryListener);
    this.categories = new NewsCategoryFactory().createCategories();
  }

  ngOnDestroy(): void {
    this.mobileQuery.removeEventListener('screenResize', this.mobileQueryListener);
  }

}
