(ns demo.handlers)

(defmulti handler (fn [_ context] (:event context)))

(defmethod handler "create-user"
  [state {data :data, id :id}]
  [(assoc state id data) "create-user"])

(defmethod handler "update-user"
  [state {data :data, id :id}]
  [(update state id #(merge % data)) "update-user"])

(defmethod handler "delete-user"
  [state {id :id}]
  [(dissoc state id) "delete-user"])
