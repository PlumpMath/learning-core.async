(ns learning-async.core
  (:require [domina :as d]))

;; DOM

(defn show-philosopher [n]
  (d/append! (d/by-id "body") (str "<div id='phil-" n  "'>Philosopher-" n "</div>")))

(defn show-thinking [n]
  (-> (d/by-id (str "phil-" n))
      (d/set-classes! "thinking")))

(defn show-eating [n]
  (-> (d/by-id (str "phil-" n))
      (d/set-classes! "eating")))

;;

(defn philosopher [n]
  (show-philosopher n)
  (show-thinking n))

;;

(defn main []
  (doseq [i (range 1 6)]
    (philosopher i)))

(main)
