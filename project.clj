(defproject district0x/district-ui-component-add-to-calendar "1.0.0"
  :description "district UI component for calendar reminders"
  :url "https://github.com/district0x/district-ui-component-add-to-calendar"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[soda-ash "0.76.0"]
                 [cljsjs/filesaverjs "1.3.3-0"]
                 [cljsjs/react-with-addons "15.2.0-0"]
                 [org.clojure/clojurescript "1.9.946"]]

  :exclusions [[org.clojure/clojure]
               [org.clojure/clojurescript]
               [cljsjs/react]]

  :doo {:paths {:karma "./node_modules/karma/bin/karma"}}

  :npm {:devDependencies [[karma "1.7.1"]
                          [karma-chrome-launcher "2.2.0"]
                          [karma-cli "1.0.1"]
                          [karma-cljs-test "0.1.0"]]}

  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[cljs-react-test "0.1.4-SNAPSHOT"]
                                  [day8.re-frame/test "0.1.5"]
                                  [district0x/district-ui-reagent-render "1.0.0"]
                                  [hickory "0.7.1"]
                                  [lein-doo "0.1.8"]
                                  [mount "0.1.11"]
                                  [org.clojure/clojure "1.8.0"]
                                  [com.andrewmcveigh/cljs-time "0.5.2"]]
                   :plugins [[lein-doo "0.1.8"]
                             [lein-npm "0.6.2"]
                             [lein-cljsbuild "1.1.7"]]}}

  :cljsbuild {:builds [{:id "tests"
                        :source-paths ["src" "test"]
                        :compiler {:output-to "tests-output/tests.js"
                                   :output-dir "tests-output"
                                   :main "tests.runner"
                                   :optimizations :none}}]})
