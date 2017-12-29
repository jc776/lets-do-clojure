(ns app.client
  (:require [reagent.core :as r]))

(defn main []
  (r/render [:h2 "This is Reagent?"]
    (js/document.getElementById "app")))
