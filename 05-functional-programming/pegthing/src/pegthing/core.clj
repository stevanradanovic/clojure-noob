(ns pegthing.core
  (:require [clojure.set :as set])
  (:gen-class))

(declare successful-move prompt-move game-over query-rows)

(defn tri*
  "Generates lazy sequence of triangular numbers"
  ([] (tri* 0 1))
  ([sum n]
    (let [new-sum (+ sum n)]
      (cons new-sum (lazy-seq (tri* new-sum (inc n)))))))

(def tri (tri*))

(defn triangular?
  "Is the number triangular or not?"
  [number]
  (= number (last (take-while #(>= number %) tri))))

(defn row-tri
  "The triangular number at the end of n-th row"
  [n]
  (last (take n tri)))

(defn -main
  "I don't do a whole lot ... yet."
  []
  (println "Hello, World!"))
