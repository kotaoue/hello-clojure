(ns threading.core
  (:require [clojure.string :as str]))

(defn -main
  [& _args]
  (let [sentence "  Hello, Clojure World!  "
        result (-> sentence
                   str/trim
                   str/lower-case
                   (str/replace #"[,!]" "")
                   (str/split #"\s+"))]
    (println result))

  (let [numbers (range 1 11)
        result (->> numbers
                    (filter odd?)
                    (map #(* % %))
                    (reduce +))]
    (println (str "Sum of squares of odd numbers (1-10): " result))))
