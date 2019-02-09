import {Component} from '@angular/core';
import {NewsService} from './news.service';
import {Article} from './article/article';
import {NEWS_COUNTRY} from '../../environments/environment';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss'],
  providers: [NewsService]
})
export class NewsComponent {
  articles: Array<Article>;

  constructor(private newsService: NewsService, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => this.selectCategory(params.get('category')));
  }

  selectCategory(key: string) {
    this.newsService.getNews(key, NEWS_COUNTRY)
      .subscribe(response => this.articles = response.articles);
  }
}
