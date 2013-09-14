(ns learning-async.core
  (:require [domina :as d]
            [cljs.core.async :refer [chan put! >! <! timeout]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

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

(defn rand-time [a b]
  (+ a (rand-int (- b a))))

(defn make-fork []
  (let [c (chan 1)]
    (go (>! c :fork))
    c))

(defn philosopher [id left right]
  (go
   (show-philosopher id)
   (while true
     (show-thinking id)
     (<! (timeout (rand-time 500 1000)))
     (<! left) (<! right)
     (show-eating id)
     (<! (timeout (rand-time 500 1000)))
     (>! left :fork) (>! right :fork))))

;;

(def n 5)

(def forks (into [] (take n (repeatedly make-fork))))

(defn main []
  (doseq [i (range n)]
    (philosopher i (forks i) (forks (mod (inc i) n)))))

(main)
