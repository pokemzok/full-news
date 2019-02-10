import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {TranslateLoader, TranslateModule, TranslateService} from '@ngx-translate/core';
import {NewsComponent} from './news/news.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialModule} from './material-module';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {ArticleComponent} from './news/article/article.component';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {HashLocationStrategy, LocationStrategy} from "@angular/common";


const ROUTES: Routes = [
  {path: ':category', component: NewsComponent},
  {path: '', redirectTo: '/technology', pathMatch: 'full'},
  {path: '**', redirectTo: '/technology', pathMatch: 'full'}
];

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    NewsComponent,
    ArticleComponent,
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
    RouterModule.forRoot(
      ROUTES
    )
  ],
  providers: [TranslateService ,{ provide: LocationStrategy, useClass: HashLocationStrategy }],
  bootstrap: [AppComponent]
})
export class AppModule {

  constructor(translate: TranslateService) {
    translate.setDefaultLang('pl');
    translate.use('pl');
  }
}
