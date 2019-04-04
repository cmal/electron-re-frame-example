(ns setup-front.views
  (:require [re-frame.core :as rf]
            [re-com.core :as re-com]
            [setup-front.helper :as h]
;;            [anh-front.subs :as subs]
            ))


(def sidebars
  {:typing "跟打"
   :history "历史"
   :setting "设置"
   :rank "排行榜"})

(defn page []
  (let [panel (rf/subscribe [:panel])]
   [:div
    [:div.side-bar
     (doall
      (for [[k v] sidebars]
        ^{:key (name k)}
        [:div.side-bar-item
         {:style {:color (if (= @panel k) "#fff" "#666")}
          :on-click (fn [_]
                      (rf/dispatch [:set-panel k]))}
         v]))]
    [:div.panel
     [(name @panel)]]]))

(defn typing []
  [:div.panel
   "typing"])

(defn history []
  [:div.panel
   "history"])

(defn rank []
  [:div.panel
   "rank"])

(defn main-panel []
  [re-com/v-box
   :height "100%"
   :children [[page] ]])
