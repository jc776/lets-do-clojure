(ns app.devcards
  (:require [devcards.core :as dc :include-macros true])
  (:require-macros
    [devcards.core :as dc :refer [defcard]]))
    
(enable-console-print!)

(defcard hello-world
  "um, hi...")

(defn main []
  (dc/start-devcard-ui!))
