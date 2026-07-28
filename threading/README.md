# threading

## 実行方法

```bash
cd threading
clojure -M -m threading.core
```

## コード説明

```clojure
(ns threading.core
  (:require [clojure.string :as str]))

(defn -main
  [& _args]

  (let [sentence "  Hello, Clojure World!  "
        result (-> sentence
; ->（スレッドファースト）: 値を各関数の第1引数として順に渡していく
                   str/trim
; str/trim: 前後の空白を除去。-> により sentence が第1引数になる
                   str/lower-case
; str/lower-case: 小文字に変換
                   (str/replace #"[,!]" "")
; str/replace: 正規表現にマッチした部分を置換
                   (str/split #"\s+"))]
; str/split: 空白で分割してベクタにする
    (println result))

  (let [numbers (range 1 11)
        result (->> numbers
; ->>（スレッドラスト）: 値を各関数の最後の引数として順に渡していく
                    (filter odd?)
; filter: 奇数だけを残す
                    (map #(* % %))
; map: 各要素を二乗する。#(...) は無名関数リテラル、% は引数
                    (reduce +))]
; reduce: シーケンスを + で畳み込んで合計を求める
    (println (str "Sum of squares of odd numbers (1-10): " result))))
```

## Clojure文法の補足

- `->`: スレッドファーストマクロ。`(-> x f g h)` は `(h (g (f x)))` と同じ。値を各関数の **第1引数** に挿入する。オブジェクト操作（文字列変換など）に向く。
- `->>`: スレッドラストマクロ。`(->> x f g h)` は `(h (g (f x)))` と同じ。値を各関数の **最後の引数** に挿入する。コレクション操作（`filter`、`map`、`reduce` など）に向く。
- `filter`: 述語関数が真を返す要素だけを残した新しいシーケンスを返す。
- `odd?`: 奇数かどうかを判定する述語関数。
- `#(...)`: 無名関数リテラル。`%` が引数、`%1` `%2` で複数引数を参照できる。
- `reduce`: `(reduce f coll)` でシーケンスを左から順に関数で畳み込む。
- `str/trim` / `str/lower-case` / `str/replace`: `clojure.string` が提供する文字列操作関数。
