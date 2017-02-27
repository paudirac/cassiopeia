(ns cassiopeia.events
    (:require [re-frame.core :as re-frame]
              [cassiopeia.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   (.info js/console "Initialize event fired")
   db/default-db))
