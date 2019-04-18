(ns demo.bootstrap
  (:require [prevayler :refer :all]
            [demo.handlers :as handlers]))

(defn foo [initial-state handler]
  (with-open [world (transient-prevayler! handler initial-state)]
    (handle! world {:event "create-user"
                    :id    "123"
                    :data  {:email "123@mail.com"}})

    (handle! world {:event "create-user"
                    :id    "12323"
                    :data  {:email "123@mail.com"}})

    (handle! world {:event "update-user"
                    :id    "12323"
                    :data  {:email "123hhhhh@mail.com"}})

    (handle! world {:event "update-user"
                    :id    "12323"
                    :data  {:email "123hhh555%%%hh@mail.com"}})

    (handle! world {:event "create-user"
                    :id    "3333334"
                    :data  {:email "333333@mail.com"}})

    (handle! world {:event "delete-user"
                    :id    "3333334"})))

(foo {} handlers/handler)
