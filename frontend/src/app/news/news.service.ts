import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {GET_NEWS} from '../../environments/environment';
import {Observable} from 'rxjs';
import {News} from './news';

@Injectable()
export class NewsService {
  constructor(private http: HttpClient) {
  }

  getNews(category: string, country: string): Observable<News>  {
    return this.http.get(
      GET_NEWS
        .replace('REPLACE_COUNTRY', country)
        .replace('REPLACE_CATEGORY', category)
    );
  }
}
