(defproject demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[prevayler-clj "3.0.1"]
                 [midje "1.9.8"]
                 [org.clojure/clojure "1.8.0"]
                 [nubank/matcher-combinators "0.9.0"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.1"]]
  :main ^{:skip-aot true} demo.server)
