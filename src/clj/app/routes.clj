(ns app.routes
  (:require
    [compojure.route :as route]
    [compojure.core :refer [defroutes GET]]
    [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
    [ring.util.response :refer [resource-response response content-type]]))

(defroutes routes
  (GET "/hello/:name" [name] (-> (str "route - " name)
                                 (response)
                                 (content-type "text/plain; charset=UTF-8")))
  (GET "/" [] (resource-response "index.html" {:root "public"}))
  (route/resources "/")
  ;; boot-reload uses this path instead
  (route/resources "/public")
  (route/not-found "<h1>Page not found</h1>"))

(println (resource-response "index.html" {:root "public"}))
    
(def app
  (wrap-defaults routes site-defaults))
