(ns clojure-alchemy.core
  (:gen-class))

(defmacro basic-infix
  [infixed]
  (list (second infixed)
        (first infixed)
        (last infixed)))

(defn -main
  "I don't do a whole lot... but I can infix."
  []
  (println "1 + 2 =" (basic-infix (1 + 2))))
