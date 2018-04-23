# district-ui-component-add-to-calendar

[![Build Status](https://travis-ci.org/district0x/district-ui-component-add-to-calendar.svg?branch=master)](https://travis-ci.org/district0x/district-ui-component-add-to-calendar)

Clojurescript [mount](https://github.com/tolitius/mount) + [re-frame](https://github.com/Day8/re-frame) component for a district UI, that provides [reagent](https://github.com/reagent-project/reagent) UI component for adding calendar reminders. Works with [Google Calendar](www.calendar.google.com) and [Apple Calendar](https://www.icloud.com/#calendar).

## Installation

Add `[district0x/district-ui-add-to-calendar "1.0.0"]` into your project.clj.<br/>
Include `[district.ui.component.add-to-calendar]` in your CLJS file.

## Usage

#### <a name="district.ui.component.add-to-calendar"> `district.ui.component.add-to-calendar`
This namespace contains reagent UI component.<br/>
<br/>
Basic usage example:

```clojure
(ns my-district
  (:require [cljs-time.core :as t]
            [reagent.core :as r]
            [district.ui.component.add-to-calendar :as add-to-calendar]))

(defn main-panel []
  [:div#page1 [add-to-calendar/add-to-calendar {:title "Test"
                                                :url "https://district0x.io"
                                                :description "description"
                                                :start-time (t/now)
                                                :end-time (t/now)}]])

(defn ^:export init []
  (r/render [main-panel] (.getElementById js/document "app")))
```
