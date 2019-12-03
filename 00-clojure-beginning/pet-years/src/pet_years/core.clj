(ns pet-years.core
  (:gen-class))

(defn -main
  "I tell you how old is your pet in human years."
  [pet-type pet-age]
  (println "Your pet is" (how-old pet-type pet-age) "old."))
