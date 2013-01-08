(ns faiz.api
  (:require [datomic.api :as d]
            [faiz.datomic :as dt])
  (:use [clojure.pprint]))

(def uri (atom "datomic:mem://faiz"))

(def schema-path "src/faiz/schema.clj")
(def data-path "src/faiz/sample-date.clj")


;; "datomic:free://localhost:4334/faiz"
;; "datomic:mem://faiz"

(dt/init @uri)

(dt/refresh-schema schema-path)
(dt/refresh-schema data-path)

(def tempid (atom nil))

(defn get-tempid
  []
  (reset! tempid (d/tempid :db.part/user)))

(defn cr-en
  [m temp-id]
  (let [{:keys [db-after tempids]} (dt/trans [(assoc m :db/id temp-id)])
        id (d/resolve-tempid db-after tempids temp-id)
        en (d/entity db-after id)]
    {:id id :entity en}))

(def m {:thaali/address 17592186045430
  :thaali/size :thaali.size/half
  :thaali/num "21"
  :common/hijri-year 1434
  :common/hijri-month "Rabi ul Awwal"
  :common/gregorian-year 2013
  :common/gregorian-month "December"})

(def e (cr-en m
              (d/tempid :db.part/user)))

(println (-> e :entity :common/hijri-month))

(println (:entity e))

(println (-> e :entity :thaali/address :address/flat))
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