(ns setup-front.events
  (:require
   [re-frame.core :refer [after debug path reg-fx dispatch
                          reg-event-db reg-event-fx subscribe
                          reg-sub inject-cofx] :as rf]
   [setup-front.db :as db]))

(reg-sub
 :panel
 (fn [db _]
   (:panel db)))

(reg-event-db
 :set-panel
 (fn [db [_ panel]]
   (assoc db :panel panel)))

(reg-event-db
 :initialize-db
 (fn [db _]
   (db/default-db)))
