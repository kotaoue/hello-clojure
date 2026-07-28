(ns atom-example.core)

(def counter (atom 0))

(defn increment! []
  (swap! counter inc))

(defn -main
  [& args]
  (let [n (if (seq args) (Integer/parseInt (first args)) 5)]
    (dotimes [_ n]
      (increment!))
    (println (str "Counter: " @counter))))
