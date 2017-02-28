(ns cassiopeia.coords)

(def xv [1 0])
(def yv [0 1])
(def origin [0 0])

(defn advance [[x y] [vx vy]]
  [(+ x vx) (+ y vy)])

; vx' = cos A vx - sin A vy
; vy' = sin A vx + cos A vx
; left => A = 90º => cos A = 0, sin A = 1 => vx' = - vy, vy' = vx
; right => A = -90º => cos A = 0, sin A = -1 => vx' = vy, vy' = -vx
(defn rotate [[vx vy] rot]
  (cond (= rot :left) [(* -1 vy) vx]
        (= rot :right) [vy (* -1 vx)]))
