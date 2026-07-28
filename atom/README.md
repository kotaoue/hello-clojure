# atom

## 実行方法

```bash
cd atom
clojure -M -m atom-example.core

clojure -M -m atom-example.core 10
```

## コード説明

```clojure
(ns atom-example.core)
; 名前空間を定義（atom はClojureの組み込み関数と衝突するため atom-example を使用）

(def counter (atom 0))
; atom: 変更可能な状態を保持するコンテナを作成する
; 初期値は 0

(defn increment! []
; 末尾の ! は副作用のある関数を表す慣習
  (swap! counter inc))
; swap!: atom の現在の値に関数を適用して更新する
; inc: 値を1増やす関数

(defn -main
  [& args]
  (let [n (if (seq args) (Integer/parseInt (first args)) 5)]
    (dotimes [_ n]
; dotimes: n回繰り返す。ループ変数が不要なときは _ を使う慣習
      (increment!))
    (println (str "Counter: " @counter))))
; @: atom の現在の値を取り出す（deref の省略形）
```

## Clojure文法の補足

- `atom`: 変更可能な状態を安全に管理するための参照型。スレッドセーフ。
- `swap!`: `(swap! an-atom f)` の形で、atom の値に関数 `f` を適用して更新する。更新は原子的（atomic）に行われる。
- `reset!`: `(reset! an-atom new-val)` の形で、atom の値を直接新しい値に置き換える。
- `@`: `deref` の読者マクロ。`@counter` は `(deref counter)` と同じ意味で、現在の値を取り出す。
- `dotimes`: `(dotimes [i n] ...)` で0から n-1 まで繰り返す。副作用のためのループ。
- `_`: 使わない変数名の慣習。Clojure では任意の変数名として使えるが、「値を使わない」意図を示す。
- `!`（末尾）: 副作用や状態変更を伴う関数名に付ける命名慣習（`swap!`、`reset!`、`alter!` など）。I/O関数（`println` など）には付かない点に注意。
