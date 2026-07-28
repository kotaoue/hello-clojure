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
    (hanoi (dec n) via to from)))
; n-1個のディスクを経由地から目的地に移動（再帰）

(defn -main
; エントリーポイント（メイン関数）を定義
  [& args]
; コマンドライン引数を可変長パラメータとして受け取る

  (let [n (if (seq args) (Integer/parseInt (first args)) 3)
; 引数がある場合は整数に変換、ない場合はデフォルト値3を使用
        total-moves (- (Math/pow 2 n) 1)]
; 必要な移動回数を計算（2^n - 1）
    (hanoi n "A" "C" "B")
; ハノイ関数を呼び出して手順を出力
    (println)
; 空行を出力
    (println (str "Total moves: " (int total-moves)))))
; 合計移動回数を出力
```
