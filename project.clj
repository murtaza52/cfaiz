(defproject faiz "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.3"]
                 [me.shenfeng/mustache "0.0.7"]
                 [com.cemerick/friend "0.1.2"]]
  :plugins [[lein-ring "0.7.5"]]
  :ring {:handler faiz.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
