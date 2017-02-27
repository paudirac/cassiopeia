(ns cassiopeia.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [cassiopeia.core-test]))

(doo-tests 'cassiopeia.core-test)
