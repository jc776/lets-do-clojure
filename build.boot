(set-env!
  :source-paths #{"src/clj" "src/cljs"}
  :resource-paths #{"resources"}
  :dependencies 
    '[[org.clojure/clojure "1.9.0" :scope "provided"]
      [org.clojure/clojurescript "1.9.293"]
      ;; frontend
      [reagent "0.7.0"]
      [devcards "0.2.4" :exclusions [cljsjs/react]]
      ;; build
      [adzerk/boot-cljs   "2.0.0" :scope "test"]
      [adzerk/boot-reload "0.5.1" :scope "test"]
      [pandeiro/boot-http "0.8.3" :scope "test"]])
      
(require
  '[adzerk.boot-cljs :refer [cljs]]
  '[adzerk.boot-reload :refer [reload]]
  '[pandeiro.boot-http :refer [serve]])
  
(deftask dev []
  (comp
    (serve :dir "target/public/")
    (watch :verbose true)
    (reload :on-jsload 'app.client/main)
    (cljs :optimizations :none)
    (target)))
