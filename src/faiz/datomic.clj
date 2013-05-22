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

(defn populate-data
  "Populates data in the db"
  [path]
  (let [schema (read-string (slurp path))]
    (trans schema)))

(defn cr-en
  [m]
  (let [temp-id (d/tempid :db.part/user)
        {:keys [db-after tempids]} (trans [(assoc m :db/id temp-id)])
        id (d/resolve-tempid db-after tempids temp-id)
        en (d/entity db-after id)]
    {:id id :entity en}))

;; #Functions for querying data
;;

(defn qu
  "Function for querying"
  ([v]
     (q v
        (db @conn)))
  ([v & p]
     (apply q v
            (db @conn)
            p)))

(defn id->en
  [id]
  (-> @conn db (d/entity id)))

(defn find-en
  [& p]
  (map #(id->en (first %)) (apply qu p)))

(defn update-datom
  [m]
  (trans [m]))
