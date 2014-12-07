(defproject metosin/compojure-api-examples "0.16.0"
  :description "Compojure-api-examples"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [metosin/ring-swagger "0.13.0"]
                 [metosin/compojure-api "0.16.0"]
                 [metosin/ring-http-response "0.5.0"]
                 [metosin/ring-swagger-ui "2.0.17"]
                 [clj-time "0.8.0"]
                 [environ "0.5.0"]]
  :min-lein-version "2.0.0"
  :plugins [[environ/environ.lein "0.2.1"]]
  :hooks [environ.leiningen.hooks]
  :ring {:handler compojure.api.examples.handler/app}
  :uberjar-name "examples.jar"
  :profiles {:uberjar {:resource-paths ["swagger-ui"]
                       :aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[lein-ring "0.8.11"]]}
             :production {:env {:production true}}})
