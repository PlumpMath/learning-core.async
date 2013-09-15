(ns learning-async.core
  (:require [cljs.core.async :refer [chan put! >! <! timeout]]
            [c2.dom :refer [append! attr select]])

  (:require-macros [cljs.core.async.macros :refer [go]]))

;;


(def n 10)

(def height 100)

(def width 500)

;; SVG

(defn create-svg []
  (-> (select "#content")
      (append! [:svg#svg {:height height :width width}])))

(defn show-philosopher [id]
  (let [w (/ width n)
        x (* id w)]
    (-> (select "#svg")
        (append! [:rect {:id (str "phil-" id) :x x :y 0 :height height :width w}]))))

(defn show-thinking [id]
  (-> (select (str "#phil-" id))
      (attr :class "thinking")))

(defn show-eating [id]
  (-> (select (str "#phil-" id))
      (attr :class "eating")))
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

(def forks (into [] (take n (repeatedly make-fork))))

(defn main []
  (create-svg)
  (doseq [i (range n)]
    (philosopher i (forks i) (forks (mod (inc i) n)))))

(main)
