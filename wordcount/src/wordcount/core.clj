(ns wordcount.core
  (:require [clojure.string :as str]))

(defn count-words [text]
  (frequencies (str/split text #"\s+")))

(defn -main
  [& _args]
  (let [text "the quick brown fox jumps over the lazy dog the fox"
        counts (count-words text)]
    (doseq [[word cnt] (sort-by val > counts)]
      (println (str word ": " cnt)))))
