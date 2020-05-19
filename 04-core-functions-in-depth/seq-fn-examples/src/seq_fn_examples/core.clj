(ns seq-fn-examples.core
  (:gen-class))

;; Map list of functions onto collection
(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

;; Implement map, filter and some using reduce
(defn my-map
  "Map implemented using reduce"
  [func coll]
  (reduce (fn [new-coll elem]
            (conj new-coll (func elem)))
          []
          coll))


(defn -main
  "I don't do a whole lot ... yet."
  []
  (println "Sum, count and avg for [42 0 7]:" (stats [42 0 7]))
  (println "My-map increment [1 2 3]:" (my-map inc [1 2 3])))
