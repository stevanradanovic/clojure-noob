(ns exercises.core
  (:gen-class))

(defn exer02
  "Function that takes a number and adds 100 to it"
  [num]
  (+ 100 num))

(defn -main
  "I don't do a whole lot... But I can call few functions."
  []
  (println "I'm gonna add 100 to 42:" (exer02 42)))
