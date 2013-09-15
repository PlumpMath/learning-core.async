(defproject learning-async "0.1.0-SNAPSHOT"
  :description "Playing with core.async"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :repositories {"sonatype-oss-public"
                 "https://oss.sonatype.org/content/groups/public/"}

  :source-paths ["src/clj"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]

                 [org.clojure/clojurescript "0.0-1853"]
                 [org.clojure/core.async "0.1.222.0-83d0c2-alpha"]
                 [com.keminglabs/c2 "0.2.3"]
                 ]

  :plugins [[lein-cljsbuild "0.3.3"]
            [lein-ring "0.8.7"]]

  :profiles {:dev {:plugins [[com.cemerick/austin "0.1.1"]]}}

  :ring {:handler learning-async.core/app}

  :cljsbuild {:builds
              [{
                :source-paths ["src/cljs"]
                :compiler {
                           :output-to "resources/public/js/main.js"
                           :optimizations :whitespace
                           :pretty-print true}}]})
