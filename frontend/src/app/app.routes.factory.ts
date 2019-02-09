import {Route} from '@angular/router';
import {NewsComponent} from './news/news.component';
import {NewsCategoryFactory} from './news/news-category.factory';

export class AppRoutesFactory {

  routes(): Route[] {
    return [
      {path: ':category', component: NewsComponent},
      {path: '', redirectTo: this.mainCategoryRoute(), pathMatch: 'full'},
// { path: '**', component: PageNotFoundComponent } FIXME page not found
    ];
  }

  private mainCategoryRoute(): string {
    return '/' + NewsCategoryFactory.mainCategory().key;
  }
}
