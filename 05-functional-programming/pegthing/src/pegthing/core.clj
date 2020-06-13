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

(defn blablabla [num] (println num))

(defn test [] (println "test"))

(defn blabla [num] (println "test" num))

(defn -main
  "I don't do a whole lot ... yet."
  []
  (println "Hello, World!"))
