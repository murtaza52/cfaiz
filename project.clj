(defproject faiz "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5" :exclusions [org.clojure/tools.macro]]
                 ;[me.shenfeng/mustache "0.0.7"]
                 ;[com.cemerick/friend "0.1.2"]
                 [ring-json-response "0.2.0"]
                 [ring-serve "0.1.2"]
                 ;[ring-mock "0.1.3"]
                 ;[clj-airbrake "2.0.0"]
                 [com.datomic/datomic-free "0.8.3941"]]
  :plugins [[lein-ring "0.7.5" :exclusions [org.clojure/clojure]]]
  :ring {:handler faiz.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]
                        [midje "1.4.0" :exclusions [org.clojure/clojure]]]}})
