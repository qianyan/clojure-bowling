(defproject bowling "0.0.1-SNAPSHOT"
  :description "bowling scoring program"
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :profiles {:dev {:plugins [[refactor-nrepl "2.0.0-SNAPSHOT"]
                             [cider/cider-nrepl "0.10.0"]]
                   :dependencies [[midje "1.6.0"]]}})



  
