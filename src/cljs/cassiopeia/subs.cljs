(ns cassiopeia.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 :pos
 (fn [db]
   (:pos db)))

(re-frame/reg-sub
 :dir
 (fn [db]
   (:dir db)))
