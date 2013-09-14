(defproject learning-async "0.1.0-SNAPSHOT"
  :description "Playing with core.async"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :repositories {"sonatype-oss-public"
                 "https://oss.sonatype.org/content/groups/public/"}

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1878"]
                 [org.clojure/core.async "0.1.0-SNAPSHOT"]
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
