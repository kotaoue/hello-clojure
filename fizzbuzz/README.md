# fizzbuzz

## 実行方法

```bash
cd fizzbuzz
clojure -M -m fizzbuzz.core

clojure -M -m fizzbuzz.core 30
```

## コード説明

```clojure
(ns fizzbuzz.core)
; 名前空間を定義

(defn fizzbuzz [n]
; 1つの数値を受け取り FizzBuzz 文字列を返す関数
  (cond
; cond: 複数の条件を上から順に評価し、最初に真になった節の値を返す
    (zero? (mod n 15)) "FizzBuzz"
; 15の倍数なら "FizzBuzz"
    (zero? (mod n 3))  "Fizz"
; 3の倍数なら "Fizz"
    (zero? (mod n 5))  "Buzz"
; 5の倍数なら "Buzz"
    :else              (str n)))
; それ以外はそのまま数値を文字列に変換

(defn -main
  [& args]
  (let [n (if (seq args) (Integer/parseInt (first args)) 20)]
    (doseq [x (map fizzbuzz (range 1 (inc n)))]
; range: 連続した整数のシーケンスを生成する
; map: fizzbuzz 関数を各要素に適用する
; doseq: 副作用のためにシーケンスを繰り返す
      (println x))))
```

## Clojure文法の補足

- `cond`: 複数の条件式を順に評価し、最初に真になったものの値を返す。`if-else if` の代替。
- `zero?`: 値が0かどうかを判定する述語関数。
- `mod`: 剰余を計算する。`(mod 15 3)` は `0`。
- `range`: `(range 1 n)` で `1` から `n-1` までの整数シーケンスを生成する。
- `inc`: 数値を1増やす。`(inc 9)` は `10`。
- `map`: 関数をシーケンスの各要素に適用して新しいシーケンスを返す（遅延評価）。
- `doseq`: 副作用（println など）のためにシーケンスを逐次処理する。戻り値は `nil`。
- `:else`: `cond` の最後に書くデフォルト節。常に真になるキーワード。
