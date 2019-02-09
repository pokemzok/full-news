import {Tuple} from './tuple';


export class NewsCategoryFactory {

   createCategories(): Array<Tuple<string>> {
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


}
