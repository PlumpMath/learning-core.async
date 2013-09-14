(defproject learning-async "0.1.0-SNAPSHOT"
  :description "Playing with core.async"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1859"]
                 [org.clojure/core.async "0.1.222.0-83d0c2-alpha"]
                 [domina "1.0.1"]
                 ]
  :plugins [[lein-cljsbuild "0.3.3"]]
  :cljsbuild {:builds
              [{
                :source-paths ["src/cljs"]
                :compiler {
                           :output-to "resources/public/js/main.js"
                           :optimizations :whitespace
                           :pretty-print true}}]})
