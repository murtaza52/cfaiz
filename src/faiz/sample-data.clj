[
 ;; add entities for transporters
 {:db/id #db/id[:db.part/user -1000011]
  :common/entity-type :common.entity-type/person
  :person/first-name "Juzer"
  :common/roles :common.roles/transporter}

 {:db/id #db/id[:db.part/user -1000012]
  :common/entity-type :common.entity-type/person
  :person/first-name "Husain"
  :common/roles :common.roles/transporter}

 {:db/id #db/id[:db.part/user -1000013]
  :common/entity-type :common.entity-type/person
  :person/first-name "Qaizar"
  :common/roles :common.roles/transporter}

 {:db/id #db/id[:db.part/user -1000014]
  :common/entity-type :common.entity-type/person
  :person/first-name "Abdeali"
  :common/roles :common.roles/transporter}

 {:db/id #db/id[:db.part/user -1000015]
  :common/entity-type :common.entity-type/person
  :person/first-name "Javed"
  :common/roles :common.roles/transporter}

 {:db/id #db/id[:db.part/user -1000016]
  :common/entity-type :common.entity-type/person
  :person/first-name "Saifi"
  :common/roles :common.roles/transporter}

 ;; contact details

 {:db/id #db/id[:db.part/user -1000021]
  :contact/mobile "8087416392"}

 ;; person entities for vendors

 {:db/id #db/id[:db.part/user -1000017]
  :common/entity-type :common.entity-type/person
  :person/first-name "Husain"
  :person/last-name "Firangi"
  :person/contact-details [#db/id[:db.part/user -1000021]]
  :common/roles :common.roles/caterer}

  {:db/id #db/id[:db.part/user -1000022]
   :contact/mobile "9823086312"}

 {:db/id #db/id[:db.part/user -1000018]
  :common/entity-type :common.entity-type/person
  :person/first-name "Zohair"
  :person/last-name "Rampurwala"
  :person/contact-details [#db/id[:db.part/user -1000022]]
  :common/roles :common.roles/caterer}

 ;; add entities for vendors
 {:db/id #db/id[:db.part/user -1000019]
  :common/entity-type :common.entity-type/vendor
  :vendor/name "Hakimee Caterers"
  :vendor/contact-persons [#db/id[:db.part/user -1000018]]}

  {:db/id #db/id[:db.part/user -1000020]
  :common/entity-type :common.entity-type/vendor
  :vendor/name "Firangi Caterers"
  :vendor/contact-persons [#db/id[:db.part/user -1000017]]}

  ;; add entities for khidmatguzaars

 ;;thaali
 {:db/id #db/id[:db.part/user -1000002]
  :thaali/size :thaali.size/half
  :thaali/num "21"
  :common/hijri-year 1434
  :common/hijri-month "Moharram"}

 {:db/id #db/id[:db.part/user -1000003]
  :thaali/size :thaali.size/half
  :thaali/num "21"
  :common/hijri-year 1434
  :common/hijri-month "Rabi ul Awwal"}

 {:db/id #db/id[:db.part/user -1000004]
  :thaali/size :thaali.size/full
  :thaali/num "22"
  :common/hijri-year 1434
  :common/hijri-month "Rabi ul Awwal"}

 ;;address
 {:db/id #db/id[:db.part/user -1000001]
  :address/city "Poona"
  :address/area "Salunke Vihaar"
  :address/building "GV Gardens"
  :address/flat "206"
  :address/thaali-details [#db/id[:db.part/user -1000002]
                           #db/id[:db.part/user -1000003]
                           #db/id[:db.part/user -1000003]]
  :common/entity-type :common.entity-type/address}

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

  {:db/id #db/id[:db.part/user -1000023]
   :contact/mobile "9923109052"}

  {:db/id #db/id[:db.part/user -1000010]
   :person/address #db/id[:db.part/user -1000001]
   :person/hub-details [#db/id[:db.part/user -1000004]
                        #db/id[:db.part/user -1000005]]
   :common/entity-type :common.entity-type/person
   :person/first-name "Murtaza"
   :person/middle-name "Fakhruddin"
   :person/last-name "Badri"
   :person/its 123456
   :person/contact-details [#db/id[:db.part/user -1000023]]}]

(comment
  (defn x
    []gett
    (let [{:keys [db-after tempids]}
          @(d/transact conn [{:db/id #db/id[:db.part/user -1000001]
                                                                  :community/name "a"}])

          entity(->> (d/resolve-tempid db-after tempids #db/id[:db.part/user -1000001]) (d/entity db-after))]
               entity))
 )
