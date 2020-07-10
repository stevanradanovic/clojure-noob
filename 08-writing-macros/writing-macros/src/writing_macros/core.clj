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

(defmacro code-critic
  "Phrases are courtesy Hermes Conrad from Futurama"
  [bad good]
  `(do (println "Great squid of Madrid, this is bad code:"
                (quote ~bad))
       (println "Sweet gorilla of Manila, this is good code:"
                (quote ~good))))

(defn criticize-code
  [criticism code]
  `(println ~criticism (quote ~code)))

(defmacro code-critic-2
  [bad good]
  `(do ~(criticize-code "Cursed bacteria of Liberia, this is bad code:" bad)
       ~(criticize-code "Sweet sacred boa of Western and Eastern Samoa, this is good code:" good)))

(defmacro code-critic-3
  [{:keys [bad good]}]
  `(do ~@(map #(apply criticize-code %)
              [["Great squid of Madrid, this is bad code:" bad]
               ["Sweet gorilla of Manila, this is good code:" good]])))


(defn -main
  "I don't do a whole lot... but a few macros."
  []
  (println "Let's try macroing (1 + 2):" (basic-infix (1 + 2)))
  (println "Let's try another (1 + 2):" (basic-infix-2 (1 + 2)))
  (println (code-critic (1 + 2) (+ 1 2))))
