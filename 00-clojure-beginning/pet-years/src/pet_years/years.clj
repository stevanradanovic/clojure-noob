(ns pet-years.years
  (:gen-class))

(def years-multiplier
  {:dog 7
   :cat 5
   :goldfish 10})

(defn how-old
  "Returns how old a pet is in human years"
  [pet-type pet-age]
  (* pet-age (pet-type years-multiplier)))
