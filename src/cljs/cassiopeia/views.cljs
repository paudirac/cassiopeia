(ns cassiopeia.views
    (:require [re-frame.core :as re-frame]))

(defn position []
  (let [pos (re-frame/subscribe [:pos])
        dir (re-frame/subscribe [:dir])]
    (fn []
      [:div
       [:p (str "Position: " @pos
                " Direction:" @dir)]])))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div
       [:div "Hello from " @name]
       [position]])))
