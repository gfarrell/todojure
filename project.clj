(defproject todo "0.1.0-SNAPSHOT"
  :description "todo list app"
  :url "N/A"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot todo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
