(ns faiz.datomic
  (:use [datomic.api :only [q db] :as d]
        [clojure.pprint]))

;; #DB Initializaion

(def conn (atom ()))

(defn create-db
  [uri]
  (d/create-database uri))

(defn connect-db
  [uri]
  (d/connect uri))

(defn set-conn
  [uri]
  (reset! conn (connect-db uri)))

(defn init
  [uri]
  (create-db uri)
  (set-conn uri))

;; # Utility Functions

(defn trans
  "Utility function for transacting data"
  [t]
  @(d/transact @conn t))

(defn refresh-schema
  "Refreshes the schema"
  [path]
  (let [schema (read-string (slurp path))]
    (trans schema)))

(defn create-entity
  [entity]
  (fn
    [m]
    (let[id (d/tempid :db.part/user)
       nm (assoc m :common/entity-type entity
                   :db/id id)]
       (trans [nm]))))

(defn new-entity
  [en k v]
  (let [m (zipmap k v)
        f (create-entity en)]
    (f m)))

;; #Functions for querying data
;;

(defn query
  "Function for querying"
  [query-vector params]
  (q query-vector
     (db @conn)
     params))

(defn find-entity
  [entity-type id-field id-num]
  (query '[:find ?id
           :in $ [?entity-type ?id-field ?id-num]
           :where
           [?id :common/entity-type ?entity-type]
           [?id ?id-field ?id-num]]
         [entity-type id-field id-num]))

(defn get-entity
  [entity-type id-field id-num]
  (let [entity-id (find-entity entity-type id-field id-num)
        entity (d/entity (db @conn) (ffirst entity-id))]
    entity))

(comment
 ;;testing


 )