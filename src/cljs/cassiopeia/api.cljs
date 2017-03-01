(ns cassiopeia.api
  (:require [re-frame.core :as re-frame]))

(defn ^:export reset-position [] (re-frame/dispatch [:set-position [0 0] [0 1]]))
(defn ^:export advance [] (re-frame/dispatch [:advance]))
(defn ^:export left [] (re-frame/dispatch [:rotate :left]))
(defn ^:export right [] (re-frame/dispatch [:rotate :right]))
