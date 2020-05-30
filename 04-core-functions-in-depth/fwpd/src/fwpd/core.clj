(ns fwpd.core)

(def filename "suspects.csv")

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions
  {:name identity :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Parse data from CSV into seq"
  [data]
  (map #(clojure.string/split % #",")
       (clojure.string/split data #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn validate
  "Validate that each map in collection contains name and glitter index"
  [coll]
  (every? #(and (:name %) (:glitter-index %)) coll))

(defn glitter-filter
  [minimum-glitter records]
  (map :name (filter #(>= (:glitter-index %) minimum-glitter) records)))

(defn append
  "Adds additional suspects to the list"
  [coll & suspects]
  (reduce (fn [coll suspect]
            (conj coll {:name (first suspect)
                        :glitter-index (second suspect)}))
          coll
          suspects))

(defn vec->csv
  "Converts vector of maps into CSV string"
  [coll]
  (clojure.string/join "\n"
    (map #(clojure.string/join ","
            [(:name %) (:glitter-index %)]) 
         coll)))

(defn -main
  "I find vampires!"
  []
  (println (glitter-filter 3 (mapify (parse (slurp filename))))))
