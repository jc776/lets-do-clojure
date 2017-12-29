(ns app.systems
  (:require 
    [system.core :refer [defsystem]]
    (system.components
      [jetty :refer [new-web-server]])
    [app.routes :refer [routes]]))

(defsystem base-system
  [:web (new-web-server 3000 routes)])
