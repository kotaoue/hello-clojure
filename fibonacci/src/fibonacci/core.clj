(ns fibonacci.core)

(def fibs
  (lazy-cat [0 1] (map + fibs (rest fibs))))

(defn -main
  [& args]
  (let [n (if (seq args) (Integer/parseInt (first args)) 10)]
    (println (take n fibs))))
