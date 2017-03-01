(ns cassiopeia.views
  (:require [re-frame.core :as re-frame]
            [cassiopeia.config :as conf]))

(defn relative-coord [c comp]
  (let [tot (comp conf/size)
        turt (comp conf/turtle-size)
        step (/ tot turt)
        mid (/ tot 2)]
    (+ mid (* c step))))

(defn xpx [x] (relative-coord x :width))
(defn ypx [y] (relative-coord y :height))

(defn turtle []
  (let [x (re-frame/subscribe [:x])
        y (re-frame/subscribe [:y])
        left (xpx @x)
        top (ypx @y)]
    [:div {:style {:width (str (:width conf/turtle-size) "px")
                   :height (str (:height conf/turtle-size) "px")
                   :background "#000"
                   :position "absolute"
                   :left (str left "px")
                   :top (str top "px")}}]))

(defn field []
  (let [width (str (:width conf/size) "px")
        height (str (:height conf/size) "px")]
    [:div {:style {:width width
                   :height height
                   :position "relative"
                   :background "#cdcdcd"}}
     [turtle]]))

(defn position []
  (let [pos (re-frame/subscribe [:pos])
        dir (re-frame/subscribe [:dir])
        x (re-frame/subscribe [:x])
        y (re-frame/subscribe [:y])]
    (fn []
      [:div
       [:p (str "Position: " @pos
                " Direction:" @dir)]
       [:p (str "x: " @x " y: " @y)]])))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div
       [:div "Hello from " @name]
       [position]
       [field]])))
