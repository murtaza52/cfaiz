(ns faiz.api
  (:require [datomic.api :as datomic])
  (:use [faiz.datomic :as dt]
        [clojure.pprint]))

(def uri (atom "datomic:mem://faiz"))

(def schema-path "src/faiz/schema.clj")
(def data-path "src/faiz/sample-date.clj")


;; "datomic:free://localhost:4334/faiz"
;; "datomic:mem://faiz"

(dt/init @uri)

(dt/refresh-schema schema-path)
(dt/refresh-schema data-path)

(def t (dt/trans [{:db/id #db/id[:db.part/user -1000001]
                     :address/city "Poona"
                     :address/area "Salunke Vihaar"
                     :address/building "GV Gardens"
                     :address/flat "206"
                     }]))

(pprint t)

;; a mumin is related to a thaali and an address
;; An array of thaali-details and hub-details for each month
(def mumin [:mumin/first-name
            :mumin/middle-name
            :mumin/last-name
            :mumin/its-jamaat
            :mumin/watan
            :mumin/its
            :mumin/sabil
            :mumin/openid-token
            :mumin/address
            :mumin/thaali-details
            :mumin/hub-details
            :mumin/address])

(def address [:address/city
              :address/area
              :address/building
              :address/flat
              :address/landmark
              :address/flat])


;; 1) An array of thaali details is maintained for each mumin, one for
;; each month.
;; 2) A thali is related to an address.
;; 3) A thaali entity is created for each month for which the thaali
;; is active.
;; 4) A new entity will be created if the thaali size is changed. Thus
;; for a given month there could be muliple thaali entities for a
;; given person.
(def thaali [:thaali/address
             :thaali/size
             :thaali/num
             :thaali/delivered-by
             :thaali/remarks
             :common/year
             :common/month
             :thaali/isActive
             :thaali/skip-days
             :thaali/not-picked
             :thaali/start-date
             :thaali/stop-date])

;; where hub/received, received-on and received-by are arrays
;; a hub entity is created for each month for which hub is pledged. No
;; connection with thaali. If sum of amount received is less than
;; pledged then due.
(def hub [:hub/pledged
          :common/hijri-month
          :common/hijri-year
          :hub/amount-received
          :hub/received-on
          :hub/received-by
          :hub/due-date])

(defn new-address [] 1)

(defn new-thaali [] 1)

(defn new-hub [] 1)

(def register-mumin (partial dt/new-entity :common.entity-type/mumin mumin))

(def find-mumin (partial dt/get-entity :common.entity-type/mumin :mumin/its))

(comment
  (register-mumin ["Batul2" "M Murtaza2" "Rampurawala2" "Pune2" "Rampura2" "2035940257" "2" "1ac3"])
(-> (find-mumin "203594022") :mumin/its-jamaat)
)

(comment
  (def res (datomic/q '[:find ?id
                      :where [?id :common/entity-type]] (datomic/db @dt/conn)))

(def en (datomic/entity (datomic/db @dt/conn) (ffirst res)))

(:mumin/its en)


(def res2 (datomic/q '[:find ?id
                       :where
                       [?id :common/entity-type :common.entity-type/mumin]
                       [?id :mumin/its "203594022"]]
                (datomic/db @dt/conn)))

(def en2 (datomic/entity (datomic/db @dt/conn) (ffirst res2)))

(:mumin/its en2)

(def res3 (datomic/q '[:find ?id
                       :in $ [?entity-type ?id-field ?id-num]
                       :where
                       [?id :common/entity-type ?entity-type]
                       [?id ?id-field ?id-num]]
                     (datomic/db @dt/conn)
                     [:common.entity-type/mumin :mumin/its "203594022"]))

(def en3 (datomic/entity (datomic/db @dt/conn) (ffirst res3)))

(:mumin/its en3)

(def find-mumin (partial dt/find-entity :common.entity-type/mumin :mumin/its))

(def mumin (find-mumin "203594022"))

(pprint (ffirst mumin))
)