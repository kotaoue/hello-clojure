(ns hanoi.core)

(defn hanoi
  [n from to via]
  (when (pos? n)
    (hanoi (dec n) from via to)
    (println (str "Move disk " n " from " from " to " to))
     (hanoi (dec n) via to from))
   ; 移動回数を返す
   (if (pos? n) (dec (Math/pow 2 n)) 0))

(defn -main
  [& args]
     (let [n (if (seq args) (Integer/parseInt (first args)) 3)
       total-moves (hanoi n "A" "C" "B")]
    (println)
    (println (str "Total moves: " (int total-moves)))))
