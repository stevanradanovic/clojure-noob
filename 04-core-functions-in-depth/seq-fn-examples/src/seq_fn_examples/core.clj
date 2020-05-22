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
  "map implemented using reduce"
  [func coll]
  (reduce (fn [new-coll elem]
            (conj new-coll (func elem)))
          []
          coll))

(defn my-filter
  "filter implemented using reduce"
  [cond coll]
  (reduce (fn [new-coll elem]
            (when (cond elem)
              (conj new-coll elem)))
          []
          coll))

;; Implement conj using into, and vice-versa
(defn my-conj
  "conj implemented using into"
  [coll & additions]
  (into coll additions))

;; (defn my-into
;;   "into implemented using conj"
;;   [coll additions]
;;   (conj coll ))

(defn -main
  "I don't do a whole lot ... yet."
  []
  (println "Sum, count and avg for [42 0 7]:" (stats [42 0 7]))
  (println "My-map increment [1 2 3]:" (my-map inc [1 2 3]))
  (println "My-filter even from [1 2 3 4]:" (my-filter #(= (mod % 2) 0) [1 2 3 4]))
  (println "My-conj [1 2 3] and 4 5:" (my-conj [1 2 3] 4 5)))
