(ns faiz.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [me.shenfeng.mustache :as mustache]
            [cemerick.friend :as friend]
            (cemerick.friend [workflows :as workflows]
                             [credentials :as creds]
                             [openid :as openid])))

(mustache/deftemplate index (slurp "public/index-async.html"))

(def index-data {:title "Invoize." :brand "Faiz" :links [{:url "#/students" :text "Students"} {:url "#/thaalis" :text "Thaalis"}]})

(defroutes app-routes
  (GET "/" [] (resp/redirect "/login"))
  (ANY "/login" [] (resp/file-response "landing.html" {:root "public"}))
  (GET "/landing" [] (resp/file-response "landing.html" {:root "public"}))
  (GET "/index" [] (friend/authenticated (index index-data)))
  (route/files "/" {:root "public"})
  (route/not-found "Not Found"))

(def app-routes-with-auth
  (-> app-routes
      (friend/authenticate
       {:workflows [(openid/workflow :openid-uri "/openid" :realm "http://invoize.com" :credential-fn identity)]})))

(def app
  (handler/site app-routes-with-auth))
