(ns setup-front.helper)

(defn indexed [data]
  (map vector (iterate inc 0) data))
