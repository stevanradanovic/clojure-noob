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


(defn -main
  "I don't do a whole lot... But I can call few functions."
  []
  (println "I'm gonna add 100 to 42:" (exer02 42))
  (println "I'm gonna subtract 9 from 42:" (dec9 42)))
