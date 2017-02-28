(ns cassiopeia.db
  (:require [cassiopeia.coords :as coords]))


(def default-db
  {:name "re-frame"
   :pos coords/origin
   :dir coords/yv})
