(ns writing-macros.core
  (:gen-class))

(defmacro basic-infix
  "Use this macro when you pine for the notation
   of your childhood"
  [infixed]
  (list (second infixed)
        (first infixed)
        (last infixed)))



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
