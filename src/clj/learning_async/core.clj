(ns learning-async.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [resources not-found]]
            [compojure.handler :refer [site]]))

(defroutes app-routes
  (GET "/" [] "<p>Hello from learning core.async</p>")
  (resources "/")
  (not-found "<p>Page not found</p>"))

(def app (site app-routes))
