[
 ;;Mumin

 {:db/id #db/id[:db.part/db]
  :db/ident :mumin/first-name
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/fulltext true
  :db/doc "A person's name"
  :db.install/_attribute :db.part/db}

  {:db/id #db/id[:db.part/db]
  :db/ident :mumin/middle-name
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/fulltext true
  :db/doc "A person's name"
  :db.install/_attribute :db.part/db}

  {:db/id #db/id[:db.part/db]
  :db/ident :mumin/last-name
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/fulltext true
  :db/doc "A person's name"
  :db.install/_attribute :db.part/db}

 {:db/id #db/id[:db.part/db]
  :db/ident :mumin/its-jamaat
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Jamaat in which the ITS ID is registered"
  :db.install/_attribute :db.part/db}

 {:db/id #db/id[:db.part/db]
  :db/ident :mumin/watan
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Watan"
  :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
  :db/ident :mumin/its
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/unique :db.unique/identity
  :db/doc "ITS (Ejamaat) ID"
  :db.install/_attribute :db.part/db}

 {:db/id #db/id[:db.part/db]
  :db/ident :mumin/sabil
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Sabil Number"
  :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
  :db/ident :mumin/openid-token
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/many
  :db/doc "The id / token returned by the Open ID Provider"
  :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :mumin/address
 :db/valueType :db.type/ref
 :db/cardinality :db.cardinality/one
 :db/doc "Address of the person"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :mumin/thaali-details
 :db/valueType :db.type/ref
 :db/cardinality :db.cardinality/many
 :db/doc "Array of thaali details for each month for each thaali."
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :mumin/hub-details
 :db/valueType :db.type/ref
 :db/cardinality :db.cardinality/many
 :db/doc "Array of hub details for each month for each thaali."
 :db.install/_attribute :db.part/db}

;; ;;Address

 {:db/id #db/id[:db.part/db]
  :db/ident :address/city
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "City of Residence"
  :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
  :db/ident :address/area
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Area of Residence"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
  :db/ident :address/building
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Building Name"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
  :db/ident :address/flat
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Building Number and Flat Number"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
  :db/ident :address/landmark
  :db/valueType :db.type/string
  :db/cardinality :db.cardinality/one
  :db/doc "Landmark near the flat"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
  :db/ident :address/street
  :db/valueType :db.type/string
 :db/cardinality :db.cardinality/one
  :db/doc "Street Address"
 :db.install/_attribute :db.part/db}

;;education

{:db/id #db/id[:db.part/db]
 :db/ident :edu/start-year
 :db/valueType :db.type/string
 :db/cardinality :db.cardinality/one
 :db/doc "First Year of Education"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :edu/end-year
 :db/valueType :db.type/string
 :db/cardinality :db.cardinality/one
 :db/doc "Projected last Year of education"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :edu/field-of-study
 :db/valueType :db.type/ref
 :db/cardinality :db.cardinality/one
 :db/doc "Field of Study"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :edu/degree
 :db/valueType :db.type/ref
 :db/cardinality :db.cardinality/one
 :db/doc "Degree being Persued"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :edu/college
 :db/valueType :db.type/ref
 :db/cardinality :db.cardinality/one
 :db/doc "Degree being Persued"
 :db.install/_attribute :db.part/db}

;;thaali

{:db/id #db/id[:db.part/db]
 :db/ident :thaali/address
 :db/valueType :db.type/ref
 :db/cardinality :db.cardinality/one
 :db/doc "Delivery Address of the Thaali"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :thaali/size
 :db/valueType :db.type/ref
 :db/cardinality :db.cardinality/one
 :db/doc "Size of thaali"
 :db.install/_attribute :db.part/db}

;; thaali/size enum values
[:db/add #db/id[:db.part/user] :db/ident :thaali.size/half]
[:db/add #db/id[:db.part/user] :db/ident :thaali.size/full]

{:db/id #db/id[:db.part/db]
 :db/ident :thaali/num
 :db/valueType :db.type/string
 :db/cardinality :db.cardinality/one
 :db/unique :db.unique/identity
 :db/doc "Thaali Number"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :thaali/delivered-by
 :db/valueType :db.type/ref
 :db/cardinality :db.cardinality/one
 :db/doc "Delivery service provided by."
 :db.install/_attribute :db.part/db}

;; thaali/delivery-person enum values
[:db/add #db/id[:db.part/user] :db/ident :thaali.delivered-by/husain-bhai]
[:db/add #db/id[:db.part/user] :db/ident :thaali.delivered-by/qaizar-bhai]
[:db/add #db/id[:db.part/user] :db/ident :thaali.delivered-by/javed-bhai]
[:db/add #db/id[:db.part/user] :db/ident :thaali.delivered-by/saifi-bhai]

{:db/id #db/id[:db.part/db]
 :db/ident :common/entity-type
 :db/valueType :db.type/ref
 :db/cardinality :db.cardinality/one
 :db/doc "Type of Entity"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :common/hijri-year
 :db/valueType :db.type/long
 :db/cardinality :db.cardinality/one
 :db/doc "Hijri Year"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :common/hijri-month
 :db/valueType :db.type/string
 :db/cardinality :db.cardinality/one
 :db/doc "Hijri Month"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :common/gregorian-year
 :db/valueType :db.type/long
 :db/cardinality :db.cardinality/one
 :db/doc "Year"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :common/gregorian-month
 :db/valueType :db.type/string
 :db/cardinality :db.cardinality/one
 :db/doc "Month"
 :db.install/_attribute :db.part/db}

[:db/add #db/id[:db.part/user] :db/ident :common.entity-type/mumin]
[:db/add #db/id[:db.part/user] :db/ident :common.entity-type/thaali]

{:db/id #db/id[:db.part/db]
 :db/ident :thaali/is-active?
 :db/valueType :db.type/boolean
 :db/cardinality :db.cardinality/one
 :db/doc "Denotes if the thaali is active."
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :thaali/remarks
 :db/valueType :db.type/string
 :db/cardinality :db.cardinality/one
 :db/doc "Any relavent remarks"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :thaali/skip-dates
 :db/valueType :db.type/boolean
 :db/cardinality :db.cardinality/many
 :db/doc "Dates on which it was informed that thaali is not to be prepared."
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :thaali/not-picked-dates
 :db/valueType :db.type/boolean
 :db/cardinality :db.cardinality/many
 :db/doc "Dates on which thaali was not picked up."
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :thaali/started-on
 :db/valueType :db.type/boolean
 :db/cardinality :db.cardinality/one
 :db/doc "Date thaali was started in the current month"
 :db.install/_attribute :db.part/db}

;; Hub

{:db/id #db/id[:db.part/db]
 :db/ident :hub/pledged
 :db/valueType :db.type/long
 :db/cardinality :db.cardinality/one
 :db/doc "Hub Pledged"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :hub/amount-received
 :db/valueType :db.type/long
 :db/cardinality :db.cardinality/many
 :db/doc "Hub Amount Received"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :hub/received-on
 :db/valueType :db.type/string
 :db/cardinality :db.cardinality/many
 :db/doc "Hub Amount Received On"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :hub/received-by
 :db/valueType :db.type/string
 :db/cardinality :db.cardinality/many
 :db/doc "Hub Amount Received"
 :db.install/_attribute :db.part/db}

{:db/id #db/id[:db.part/db]
 :db/ident :hub/due-date
 :db/valueType :db.type/string
 :db/cardinality :db.cardinality/one
 :db/doc "Hub Due Date"
 :db.install/_attribute :db.part/db}
]
