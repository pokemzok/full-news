
export class Tuple<T> {

  constructor(private aKey: string, private aValue: T) {}

  get key(): string {
    return this.aKey;
  }

  get value(): T {
    return this.aValue;
  }

}
