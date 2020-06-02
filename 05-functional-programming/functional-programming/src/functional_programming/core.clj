(ns functional-programming.core
  (:gen-class))

(defn sum-regular
  "Regular sum"
  ([coll]
    (sum-regular coll 0))
  ([coll init-value]
    (if (empty? coll)
      init-value
      (sum-regular (rest coll) (+ (first coll) init-value)))))

(defn sum-recur
  "Sum using recursion mechanism"
  ([coll]
    (sum-recur coll 0))
  ([coll init-value]
    (if (empty? coll)
      init-value
      (recur (rest coll) (+ (first coll) init-value)))))

(defn my-comp
  "Implementation of the comp function"
  []
  ())

(def fib-mem
  "Fibonacci with memoization"
  (memoize (fn [num]
             (condp = num
               0 1
               1 1
               (+ (fib-mem (dec num)) (fib-mem (- num 2)))))))

(defn -main
  "I don't do a whole lot... exept showcase functional programming."
  []
  (println "Regular sum:" (sum-regular (range 1000)) "in" (time (sum-regular (range 1000))))
  (println "Recursive sum:" (sum-recur (range 1000000)) "in" (time (sum-recur (range 1000000)))))
