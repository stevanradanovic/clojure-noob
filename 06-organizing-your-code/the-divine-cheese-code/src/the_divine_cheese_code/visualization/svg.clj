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
  [comparison-fn keys]
  (fn [maps]
    (zipmap keys
            (map (fn [key] (apply comparison-fn (map key maps)))
                 keys))))

(def min (comparator-over-maps clojure.core/min [:lat :lng]))

(def max (comparator-over-maps clojure.core/max [:lat :lng]))

(defn translate-to-00
  [locations]
  (let [mincoords (min locations)]
    (map #(merge-with - % mincoords) locations)))

(defn scale
  [width height locations]
  (let [maxcoords (max locations)
        ratio {:lat (/ height (:lat maxcoords))
               :lng (/ width (:lng maxcoords))}]
    (map #(merge-with * % ratio) locations)))
