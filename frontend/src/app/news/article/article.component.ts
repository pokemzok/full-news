import {Component, Input, OnInit} from '@angular/core';
import {Article} from './article';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit {

  @Input() article: Article;

  constructor() {
  }

  // FIXME change layout when it is too small (picture should be on top)
  ngOnInit() {
  }

}
