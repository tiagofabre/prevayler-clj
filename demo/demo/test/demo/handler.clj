(ns demo.handler
  (:require [prevayler :refer :all]
            [demo.handlers :refer :all]
            [midje.sweet :refer :all]))

(fact "Handler"
  (with-open [world (transient-prevayler! handler {})]
    (handle! world {:event "create-user"
                    :id    "123"
                    :data  {:email "123@mail.com"}})

    @world => {"123" {:email "123@mail.com"}}

    (handle! world {:event "create-user"
                    :id    "12323"
                    :data  {:email "123@mail.com"}})

    @world => {"123"   {:email "123@mail.com"}
               "12323" {:email "123@mail.com"}}

    (handle! world {:event "update-user"
                    :id    "12323"
                    :data  {:email "123hhhhh@mail.com"}})

    @world => {"123"   {:email "123@mail.com"}
               "12323" {:email "123hhhhh@mail.com"}}

    (handle! world {:event "update-user"
                    :id    "12323"
                    :data  {:email "123hhh555%%%hh@mail.com"}})

    @world => {"123"   {:email "123@mail.com"}
               "12323" {:email "123hhh555%%%hh@mail.com"}}

    (handle! world {:event "create-user"
                    :id    "3333334"
                    :data  {:email "333333@mail.com"}})

    @world => {"123"   {:email "123@mail.com"}
               "12323" {:email "123hhh555%%%hh@mail.com"}
               "3333334" {:email "333333@mail.com"}}

    (handle! world {:event "delete-user"
                    :id    "3333334"})

    @world => {"123"   {:email "123@mail.com"}
               "12323" {:email "123hhh555%%%hh@mail.com"}}))
