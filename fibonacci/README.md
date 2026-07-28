# fibonacci

## 実行方法

```bash
cd fibonacci
clojure -M -m fibonacci.core

clojure -M -m fibonacci.core 15
```

## コード説明

```clojure
(ns fibonacci.core)
; 名前空間を定義

(def fibs
; 無限フィボナッチ数列をトップレベルの値として定義
  (lazy-cat [0 1] (map + fibs (rest fibs))))
; lazy-cat: 遅延シーケンスを連結する。[0 1] の後ろに、fibs と (rest fibs) を足し合わせた遅延シーケンスが続く
; これにより fibs は無限数列になるが、必要な分だけしか評価されない

(defn -main
  [& args]
  (let [n (if (seq args) (Integer/parseInt (first args)) 10)]
; 引数があれば整数に変換、なければデフォルト値10を使用
    (println (take n fibs))))
; take: シーケンスの先頭からn個を取り出す
```

## Clojure文法の補足

- `def`: トップレベルの値（変数）を定義する。関数でない値にも使える。
- `lazy-cat`: 遅延シーケンスを連結する。要素は必要になるまで評価されない。
- `lazy-seq`: 遅延シーケンスを生成する低レベルな構文。`lazy-cat` はその上位版。
- `map`: シーケンスの各要素に関数を適用した新しいシーケンスを返す。
- `rest`: シーケンスの先頭以外の残りを返す。
- `take`: シーケンスの先頭からn個取り出す。無限シーケンスにも使える。
- `+`（2引数以上）: `(map + coll1 coll2)` のように複数コレクションに対して要素ごとに適用できる。
