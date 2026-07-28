# hanoi

## 実行方法

```bash
cd hanoi
clojure -M -m hanoi.core

clojure -M -m hanoi.core 4
```

## コード説明

```clojure
(ns hanoi.core)
; 名前空間を定義。このファイルの関数のスコープを設定

(defn hanoi
; ハノイの塔を解く関数を定義
  [n from to via]
; n: ディスク枚数、from: 出発地、to: 目的地、via: 経由地

  (when (pos? n)
; nが正の数の場合のみ以下を実行
    (hanoi (dec n) from via to)
; n-1個のディスクを出発地から経由地に移動（再帰）
    (println (str "Move disk " n " from " from " to " to))
; 一番大きいディスクを出発地から目的地に移動
    (hanoi (dec n) via to from))
; n-1個のディスクを経由地から目的地に移動（再帰）
  (if (pos? n) (dec (Math/pow 2 n)) 0))
; 移動回数を返す（2^n - 1）

(defn -main
; エントリーポイント（メイン関数）を定義
  [& args]
; コマンドライン引数を可変長パラメータとして受け取る

  (let [n (if (seq args) (Integer/parseInt (first args)) 3)
; 引数がある場合は整数に変換、ない場合はデフォルト値3を使用
        total-moves (hanoi n "A" "C" "B")]
; ハノイ関数を呼び出し、戻り値（移動回数）を受け取る
    (println)
; 空行を出力
    (println (str "Total moves: " (int total-moves)))))
; 合計移動回数を出力
```

## Clojure文法の補足

- `defn`: 関数を定義する。`(defn 名前 [引数] 本体)` の形。
- `let`: ローカル変数を束縛する。`(let [a 1 b 2] ...)` の形。
- `if`: 条件分岐。`(if 条件 真の式 偽の式)`。
- `when`: `if` の簡易版。条件が真のときだけ本体を実行（偽の分岐は書かない）。
- `pos?`: 値が正の数かを判定する述語関数。
- `dec`: 数値を1減らす関数。`(dec 5)` は `4`。
- `seq`: コレクションが空でないかを判定する際によく使う。空なら `nil`。
- `first`: シーケンスの先頭要素を取得する。
- `str`: 文字列を連結して作る。
- `println`: 標準出力に表示して改行する（副作用）。
- `& args`: 可変長引数。コマンドライン引数のように任意個受け取れる。
- `Math/pow`: Javaの静的メソッド呼び出し。`(Math/pow 2 n)` は $2^n$。
