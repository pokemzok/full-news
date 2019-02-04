import {Tuple} from '../common/tuple';
import {Injectable} from '@angular/core';

@Injectable()
export class NewsTopicsService {

  getTopics(): Array<Tuple<string>> {
    return [
      new Tuple<string>('technology', 'topics.technology'),
      new Tuple<string>('sport', 'topics.sport'),
    ];
  }

}
