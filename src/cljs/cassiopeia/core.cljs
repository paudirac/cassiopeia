(ns cassiopeia.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [cassiopeia.events]
              [cassiopeia.subs]
              [cassiopeia.views :as views]
              [cassiopeia.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))

(defn ^:export reset-position [] (re-frame/dispatch [:set-position [0 0] [0 1]]))
(defn ^:export advance [] (re-frame/dispatch [:advance]))
(defn ^:export left [] (re-frame/dispatch [:rotate :left]))
(defn ^:export right [] (re-frame/dispatch [:rotate :right]))
