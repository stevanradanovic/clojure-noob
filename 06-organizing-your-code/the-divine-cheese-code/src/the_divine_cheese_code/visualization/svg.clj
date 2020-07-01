(ns the-divine-cheese-code.visualization.svg
  (:require [clojure.string :as string])
  (:refer-clojure :exclude [min max]))

(defn latlng->point
  "Convert lat/lng map to comma-separated string"
  [latlng]
  (str (:lat latlng) "," (:lng latlng)))

(defn points
  [locations]
  (string/join " " (map latlng->point locations)))

(defn comparator-over-maps
  [comparison-fn ks]
  (fn [maps]
    (zipmap ks
            (map (fn [k] (apply comparison-fn (map k maps)))
                 ks))))

(def min (comparator-over-maps clojure.core/min [:lat :lng]))

(def max (comparator-over-maps clojure.core/max [:lat :lng]))
