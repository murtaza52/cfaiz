(ns faiz.utils
  (:use [clj-airbrake.core :only [notify]]
        [clj-airbrake.ring :only [request-to-message]]
        [ring.util.response :only [response status]]))

(defn wrap-logger
  [app flag]
  (fn [req]
    (when flag (do (println "******************************************** Request Map ***********************************************")
                   (println req)
                   (println "******************************************** Response Map ***********************************************")))
    (app req)))


(defn wrap-exception
  [app]
  (fn [req]
     (try (app req)
          (catch Exception e
            (do (.printStackTrace e)
                (notify "571bda5bb0d6ee4595b0432339a151fc"
                        "production"
                        (System/getProperty "user.dir")
                        e
                        (request-to-message req))
                (-> "Error Man" response (status 500)))))))