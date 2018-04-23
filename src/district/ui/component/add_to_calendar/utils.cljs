(ns district.ui.component.add-to-calendar.utils
  (:require [cljsjs.filesaverjs]))

(defn file-write [filename content & [mime-type]]
  (js/saveAs (new js/Blob
                  (clj->js [content])
                  (clj->js {:type (or mime-type (str "application/json;charset=UTF-8"))}))
             filename))
