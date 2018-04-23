(ns district.ui.component.add-to-calendar
  (:require [district.ui.component.add-to-calendar.utils :as add-to-calendar-utils]
            [reagent.core :as r]
            [soda-ash.core :as ui]
            [clojure.string :as string]))

(defn add-to-calendar [{:keys [:start-time :end-time :description :title :url]}]
  (fn [{:keys [:start-time :end-time :description :title]}]
    (let [render-calendar-options (fn [items]
                                    (doall
                                     (map-indexed (fn [idx item]
                                                    {:key idx
                                                     :text item
                                                     :value item
                                                     :content (r/as-element (cond
                                                                              (= "Google Calendar" item)
                                                                              [:div.dropdown-item
                                                                               [:i.icon.google]
                                                                               [:a.label {:href (str "https://calendar.google.com/calendar/render"
                                                                                                     "?action=TEMPLATE"
                                                                                                     "&dates=" start-time
                                                                                                     "/" end-time
                                                                                                     "&text=" title
                                                                                                     "&details=" description)
                                                                                          :target "_blank"}
                                                                                item]]

                                                                              (= "Apple Calendar" item)
                                                                              (let [ics (string/join "\n" ["BEGIN:VCALENDAR" "VERSION:2.0" "BEGIN:VEVENT"
                                                                                                           (str "URL:" url)
                                                                                                           (str "DTSTART:" start-time)
                                                                                                           (str "DTEND:" end-time)
                                                                                                           (str "SUMMARY:" title)
                                                                                                           (str "DESCRIPTION:" description)
                                                                                                           "END:VEVENT" "END:VCALENDAR"])]
                                                                                [:div.dropdown-item
                                                                                 {:on-click #(add-to-calendar-utils/file-write "namebazaar.ics"
                                                                                                                               ics
                                                                                                                               "text/calendar;charset=utf-8")}
                                                                                 [:i.icon.apple]
                                                                                 [:a.label item]])

                                                                              :else [:a item]))})
                                                  items)))]
      [ui/Dropdown {:placeholder "Add to My Calendar"
                    :fluid true
                    :selection true
                    :options (render-calendar-options ["Google Calendar" "Apple Calendar"])}])))
