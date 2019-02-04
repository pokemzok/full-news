import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialModule} from './material-module';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {NewsTopicsService} from './news-topics.service';
import {NewsService} from './news.service';

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: (createTranslateLoader),
        deps: [HttpClient]
      }
    }),
  ],
  providers: [TranslateService, NewsTopicsService, NewsService],
  bootstrap: [AppComponent]
})
export class AppModule {

  constructor(translate: TranslateService) {
    translate.setDefaultLang('pl');
    translate.use('pl');
  }
}
