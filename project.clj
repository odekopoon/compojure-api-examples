(defproject metosin/compojure-api-examples "0.21.0"
  :description "Compojure-api-examples"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-time "0.9.0"] ;; needed as `lein ring` is broken.
                 [metosin/compojure-api "0.21.0"]
                 [environ "1.0.0"]]
  :min-lein-version "2.0.0"
  :plugins [[environ/environ.lein "0.3.1"]]
  :hooks [environ.leiningen.hooks]
  :ring {:handler compojure.api.examples.handler/app}
  :uberjar-name "examples.jar"
  :uberwar-name "examples.war"
  :profiles {:uberjar {:resource-paths ["swagger-ui"]
                       :aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[lein-ring "0.9.4"]]}
             :production {:env {:production true}}})

