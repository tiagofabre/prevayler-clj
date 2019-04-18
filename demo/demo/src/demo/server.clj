(ns demo.server
  (:require [org.httpkit.server :refer [run-server]]
            [clj-time.core :as t]
            [compojure.core :refer :all]
            [compojure.route :as route]))

(defn get-time []
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (str (t/time-now))})

(defroutes app
  (GET "/" [] "<h1>Welcome</h1>")
  (GET "/get-time" [] (get-time))
  (route/not-found "<h1>Page not found</h1>"))

(defn -main [& args]
  (run-server app {:port 8080})
  (println "Server started on port 8080"))
