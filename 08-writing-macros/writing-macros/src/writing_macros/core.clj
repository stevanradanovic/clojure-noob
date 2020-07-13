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

(def message "Good job!")

(defmacro with-mischief
  [& stuff-to-do]
  (concat (list 'let ['message "Oh, big deal!"])
          stuff-to-do))

(defmacro without-mischief
  [& stuff-to-do]
  (let [macro-message (gensym 'message)]
    `(let [~macro-message "Oh, big deal!"]
       ~@stuff-to-do
       (println "I still need to say: " ~macro-message))))

(defn -main
  "I don't do a whole lot... but a few macros."
  []
  (println "Let's try macroing (1 + 2):" (basic-infix (1 + 2)))
  (println "Let's try another (1 + 2):" (basic-infix-2 (1 + 2)))
  (println (code-critic (1 + 2) (+ 1 2)))
  ;; This would print "Oh, big deal!" instead of "Good job!"
  ;; because of variable capture
  ;; (with-mischief (println "How I feel about your success: " message))
  (without-mischief
    (println "How I feel about your success: " message)))
