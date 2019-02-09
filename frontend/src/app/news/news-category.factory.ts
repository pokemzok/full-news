import {Tuple} from '../common/tuple';

export class NewsCategoryFactory {

  static categories(): Array<Tuple<string>> {
    return [
      new Tuple<string>('business', 'topics.business'),
      new Tuple<string>('entertainment', 'topics.entertainment'),
      new Tuple<string>('general', 'topics.general'),
      new Tuple<string>('health', 'topics.health'),
      new Tuple<string>('technology', 'topics.technology'),
      new Tuple<string>('science', 'topics.science'),
      new Tuple<string>('sport', 'topics.sport'),
    ];
  }

  static mainCategory(): Tuple<string> {
    return new Tuple<string>('technology', 'topics.technology');
  }
}
