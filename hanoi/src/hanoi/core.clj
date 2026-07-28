(ns hanoi.core)

(defn hanoi
  [n from to via]
  (when (pos? n)
    (hanoi (dec n) from via to)
    (println (str "Move disk " n " from " from " to " to))
    (hanoi (dec n) via to from)))

(defn -main
  [& _args]
  (hanoi 3 "A" "C" "B"))
