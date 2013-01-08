[
 ;;address
 {:db/id #db/id[:db.part/user -1000001]
  :address/city "Poona"
  :address/area "Salunke Vihaar"
  :address/building "GV Gardens"
  :address/flat "206"
  }

 ;;thaali
 {:db/id #db/id[:db.part/user -1000002]
  :thaali/address #db/id[:db.part/user -1000001]
  :thaali/size :thaali.size/half
  :thaali/num "21"
  :common/hijri-year 1434
  :common/hijri-month "Moharram"
  :common/gregorian-year 2013
  :common/gregorian-month "December"}

 {:db/id #db/id[:db.part/user -1000003]
  :thaali/address #db/id[:db.part/user -1000001]
  :thaali/size :thaali.size/half
  :thaali/num "21"
  :common/hijri-year 1434
  :common/hijri-month "Rabi ul Awwal"
  :common/gregorian-year 2013
  :common/gregorian-month "December"}

 ;;hub
 {:db/id #db/id[:db.part/user -1000004]
  :hub/pledged 3300
  :common/hijri-year 1434
  :common/hijri-month "Rabi ul Awwal"
  :hub/amount-received [3300]
  :hub/received-on ["12/1/2013"]
  :hub/received-by ["Sadiq Bhai"]
  :hub/due-date "21/1/2013"}

  {:db/id #db/id[:db.part/user -1000005]
  :hub/pledged 2100
  :common/hijri-year 1434
  :common/hijri-month "Moharram"
  :hub/amount-received [1000 500]
  :hub/received-on ["12/1/2013"]
  :hub/received-by ["Sadiq Bhai"]
  :hub/due-date "21/1/2013"}

  ;;mumin
  {:db/id #db/id[:db.part/user -1000010]
   :mumin/address #db/id[:db.part/user -1000001]
   :mumin/thaali-details [#db/id[:db.part/user -1000002]
                          #db/id[:db.part/user -1000003]]
   :mumin/hub-details [#db/id[:db.part/user -1000004]
                       #db/id[:db.part/user -1000004]]
   :common/entity-type :common.entity-type/mumin
   :mumin/first-name "Murtaza"
   :mumin/middle-name "Fakhruddin"
   :mumin/last-name "Badri"
   :mumin/its "123456"}
  ]

(comment
  (defn x
    []
    (let [{:keys [db-after tempids]}
          @(d/transact conn [{:db/id #db/id[:db.part/user -1000001]
                                                                  :community/name "a"}])

          entity(->> (d/resolve-tempid db-after tempids #db/id[:db.part/user -1000001]) (d/entity db-after))]
               entity))
 )