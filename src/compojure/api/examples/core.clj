(ns compojure.api.examples.core
   (:require [compojure.api.examples.handler :refer :all]
             [compojure.handler :refer [site]]
             [ring.adapter.jetty :as jetty]
             [environ.core :refer [env]]))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))

