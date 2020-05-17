(ns seq-fn-examples.core
  (:gen-class))

;; Implement map, filter and some using reduce
(defn my-map
  "Map implemented using reduce"
  [func coll]
  (reduce (fn [new-coll first]
            (into new-coll (func first)))
          #()
          coll))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (println "My-map increment [1 2 3]:" (my-map inc [1 2 3])))
