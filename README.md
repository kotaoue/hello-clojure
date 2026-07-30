# hello-clojure

A small repository for learning Clojure.

## Environment setup

### Requirements

- Java

    ```sh
    java -version
    ```

- Clojure: <https://clojure.org/guides/install_clojure>

    ```sh
    clojure -Sdescribe
    ```

## Samples

| ディレクトリ | テーマ | 主なClojure機能 |
| --- | --- | --- |
| [helloworld](helloworld/) | Hello World | `defn`, `println` |
| [hanoi](hanoi/) | ハノイの塔 | 再帰, `when`, `let` |
| [fibonacci](fibonacci/) | フィボナッチ数列 | 遅延シーケンス (`lazy-cat`, `take`) |
| [fizzbuzz](fizzbuzz/) | FizzBuzz | `cond`, `map`, `range`, `doseq` |
| [wordcount](wordcount/) | 単語の出現回数 | `frequencies`, `sort-by`, 分配束縛 |
| [atom](atom/) | カウンター | `atom`, `swap!`, `deref` (`@`) |
| [threading](threading/) | データ変換パイプライン | スレッドマクロ (`->`, `->>`) |
