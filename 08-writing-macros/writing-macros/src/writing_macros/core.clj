(ns writing-macros.core
  (:gen-class))

(defmacro basic-infix
  "Use this macro when you pine for the notation
   of your childhood"
  [infixed]
  (list (second infixed)
        (first infixed)
        (last infixed)))

(defmacro basic-infix-2
  [[operand-1 op operand-2]]
  (list op operand-1 operand-2))

(defn -main
  "I don't do a whole lot... but a few macros."
  []
  (println "Let's try macroing (1 + 2):" (basic-infix (1 + 2)))
  (println "Let's try another (1 + 2):" (basic-infix-2 (1 + 2))))
