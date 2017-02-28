(ns cassiopeia.events
    (:require [re-frame.core :as re-frame]
              [cassiopeia.db :as db]
              [cassiopeia.coords :as coords]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   (.info js/console "Initialize event fired")
   db/default-db))

(re-frame/reg-event-db
 :set-position
 (fn [db [_ pos dir]]
   (assoc db :pos pos :dir dir)))

(re-frame/reg-event-db
 :advance
 (fn [db _]
   (let [pos (:pos db)
         dir (:dir db)
         next (coords/advance pos dir)]
     (.info js/console "next" (str next))
     (assoc db :pos next))))

(re-frame/reg-event-db
 :rotate
 (fn [db [_ to]]
   (let [dir (:dir db)
         new-dir (coords/rotate dir to)]
     (assoc db :dir new-dir))))
