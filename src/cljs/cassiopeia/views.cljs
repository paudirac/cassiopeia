(ns cassiopeia.views
  (:require [re-frame.core :as re-frame]
            [cassiopeia.config :as conf]
            [cassiopeia.api :as api]))

(defn relative-coord [c comp]
  (let [tot (comp conf/size)
        turt (comp conf/turtle-size)
        step (/ tot turt)
        mid (/ tot 2)]
    (+ mid (* c step))))

(defn xpx [x] (relative-coord x :width))
(defn ypx [y] (relative-coord y :height))

(defn turtle-img [dir]
  ({[0 1] "img/up.png"
    [-1 0] "img/left.png"
    [0 -1] "img/down.png"
    [1 0] "img/right.png"} dir))

(defn turtle []
  (let [x (re-frame/subscribe [:x])
        y (re-frame/subscribe [:y])
        left (xpx @x)
        top (ypx @y)
        dir (re-frame/subscribe [:dir])]
    [:div {:style {:width (str (:width conf/turtle-size) "px")
                   :height (str (:height conf/turtle-size) "px")
                   :position "absolute"
                   :left (str left "px")
                   :top (str top "px")}}
     [:img {:src (turtle-img @dir)
            :width "200px"
            :height "200px"}]]))

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

(defn button-for [name handler]
  [:button {:on-click #(handler)} name])

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div
       [:div "Hello from " @name]
       (button-for "Left" api/left)
       (button-for "Right" api/right)
       (button-for "Advance" api/advance)
       [position]
       [field]])))
