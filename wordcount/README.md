# wordcount

## 実行方法

```bash
cd wordcount
clojure -M -m wordcount.core
```

## コード説明

```clojure
(ns wordcount.core
  (:require [clojure.string :as str]))
; clojure.string ライブラリを str という別名でインポート

(defn count-words [text]
; テキストを受け取り、単語の出現回数をマップで返す関数
  (frequencies (str/split text #"\s+")))
; str/split: 正規表現でテキストを分割してベクタを返す
; #"\s+": 1文字以上の空白にマッチする正規表現リテラル
; frequencies: シーケンス内の各要素の出現回数を数えたマップを返す

(defn -main
  [& _args]
  (let [text "the quick brown fox jumps over the lazy dog the fox"
        counts (count-words text)]
    (doseq [[word cnt] (sort-by val > counts)]
; sort-by: キー関数でソートする。ここでは val（マップの値）で降順ソート
; [word cnt]: マップのエントリを分解（分配束縛）
      (println (str word ": " cnt)))))
```

## Clojure文法の補足

- `:require`: 名前空間に外部ライブラリを読み込む。`:as` で別名をつけられる。
- `frequencies`: シーケンス内の要素の出現回数を `{要素 回数}` のマップで返す。
- `str/split`: `clojure.string/split` の別名呼び出し。文字列を正規表現で分割する。
- `#"..."`: 正規表現リテラル。Clojure では `java.util.regex.Pattern` として扱われる。
- `sort-by`: シーケンスを指定したキー関数の値でソートする。
- `val`: マップのエントリから値を取り出す関数。`key` は逆にキーを取り出す。
- `>`: 降順ソートの比較関数として使える。
- `[[word cnt] ...]`: 分配束縛（destructuring）。マップのエントリを `[キー 値]` の形に分解する。
