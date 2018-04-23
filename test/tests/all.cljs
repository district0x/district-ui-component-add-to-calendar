(ns tests.all
  (:require [cljs.test :refer [deftest is testing run-tests async use-fixtures]]
            [cljs-time.core :as t]
            [cljs-react-test.simulate :as simulate]
            [cljs-react-test.utils :as test-utils]
            [hickory.core :as hickory]
            [day8.re-frame.test :refer [run-test-async run-test-sync wait-for]]
            [district.ui.reagent-render]
            [district.ui.component.add-to-calendar :as add-to-calendar]
            [mount.core :as mount :refer [defstate]]
            [re-frame.core :as re-frame]))

(def container (atom nil))

(defn mock-html []
  [:div#app [add-to-calendar/add-to-calendar {:title "Test"
                                              :url "https://district0x.io"
                                              :description "description"
                                              :start-time (t/now)
                                              :end-time (t/now)}]])

(use-fixtures :each
  {:before #(do (reset! container (test-utils/new-container!))
                (-> (mount/with-args {:reagent-render {:target @container
                                                       :component-var #'mock-html}})
                    (mount/start)))
   :after #(do (test-utils/unmount! @container)
               (mount/stop))})

(deftest tests
  (testing "test meta tags"
    (async done
           (.setTimeout js/window
                        (fn []
                          ;; TODO: test actions
                          (is (re-find #"Google Calendar" (.-innerHTML @container)))
                          (is (re-find #"Apple Calendar" (.-innerHTML @container)))
                          (done))
                        1000))))
