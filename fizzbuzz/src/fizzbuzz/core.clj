(ns fizzbuzz.core)

(defn fizzbuzz [n]
  (cond
    (zero? (mod n 15)) "FizzBuzz"
    (zero? (mod n 3))  "Fizz"
    (zero? (mod n 5))  "Buzz"
    :else              (str n)))

(defn -main
  [& args]
  (let [n (if (seq args) (Integer/parseInt (first args)) 20)]
    (doseq [x (map fizzbuzz (range 1 (inc n)))]
      (println x))))
