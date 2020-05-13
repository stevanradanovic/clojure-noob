(ns exercises.core
  (:gen-class))

;;; Exercise 02

(defn exer02
  "Function that takes a number and adds 100 to it"
  [num]
  (+ 100 num))

;;; Exercise 03

(defn dec-maker
  "Makes decrementer function"
  [dec-by]
  (fn [num] (- num dec-by)))

(def dec9 (dec-maker 9))

;;; Exercise 04

(defn mapset
  "Map that returns a set"
  [func coll]
  (set (map func coll)))


(defn -main
  "I don't do a whole lot... But I can call few functions."
  []
  (println "I'm gonna add 100 to 42:" (exer02 42))
  (println "I'm gonna subtract 9 from 42:" (dec9 42))
  (println "I'm gonna inc and set on [42, 42, 1]:" (mapset inc [42, 42, 1])))
