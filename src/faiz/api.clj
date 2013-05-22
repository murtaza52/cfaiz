(ns faiz.api
  (:require [datomic.api :as d]
            [faiz.datomic :as dt])
  (:use [clojure.pprint]))

(def uri (atom "datomic:mem://faiz"))

(def schema-path "src/faiz/schema.clj")
(def data-path "src/faiz/sample-data.clj")

;; "datomic:free://localhost:4334/faiz"
;; "datomic:mem://faiz"

(dt/init @uri)

(dt/populate-data schema-path)
(dt/populate-data data-path)

(dt/cr-en {:contact/mobile "9923109052"})

(def e (dt/find-en '[:find ?e
                          :in $ ?num
                          :where
                          [?e :contact/mobile ?num]]
                   "9923589052"))

(map #(keys %) e)

(pprint (->
            keys))

(dt/update-datom {:db/id 17592186045465 :contact/email "c" :contact/mobile "9923589052" :person/watan "Rampura"})


(def active-students '[:find ?e
                       :in $ [?month ?year]
                       :where
                       [?e :common/entity-type :common.entity-type/person]
                       [?e :person/address ?a]
                       [?a :address/thaali-details ?t]
                       [?t :common/hijri-year ?year]
                       [?t :common/hijri-month ?month]])

(pprint (dt/en '[:find ?e
         :where [?e :common/entity-type :common.entity-type/address]]))

;; create a new student
;; change details of an existing student

;; for creation of new entities a map will be received from the client.
;; It will contain the appropriate :entity-type. Any ref will also contain the appropriate references.

;; any updates received from the client side will be in the following format {:db/id 1234 :field-name val :field2 val2}. Only the fields to be updated are provided.

(-> (dt/cr-en {:person/first-name "test1" :person/address 17592186045488}) :entity :person/address :address/flat)

(def find-active-students (partial dt/en active-students))

(find-active-students ["Rabi ul Awwal" 1434])



(dt/upsert-en {:})



(def add-id 17592186045430)

(def m  {
         :mumin/address add-id
         :mumin/thaali-details [17592186045428
                                17592186045426]
         :common/entity-type :common.entity-type/mumin
         :mumin/first-name "Murtaza"
         :mumin/middle-name "Fakhruddin"
         :mumin/last-name "Badri"
         :mumin/its "123456"})

(defn register-mumin [m]
  )

(def e (cr-en m
              (d/tempid :db.part/user)))

(println (-> e :entity :mumin/thaali-details))

(println (map :common/hijri-month (-> e :entity :mumin/thaali-details)))

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
(def thaali [
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
