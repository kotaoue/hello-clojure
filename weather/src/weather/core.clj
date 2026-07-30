(ns weather.core
  (:require [clj-http.client :as http]
            [cheshire.core :as json]))

(defn format-time [t]
  (let [h (quot (Integer/parseInt t) 100)]
    (format "%02d:00" h)))

(defn extract-forecast [data]
  (for [day  (get data "weather")
        hour (get day "hourly")]
    {:date (get day "date")
     :time (format-time (get hour "time"))
     :desc (get-in hour ["weatherDesc" 0 "value"])}))

(defn -main [& _args]
  (let [res      (http/get "https://wttr.in/Tokyo?format=j1")
        data     (json/parse-string (:body res))
        forecast (extract-forecast data)]
    (doseq [{:keys [date time desc]} forecast]
      (println (str date " " time " : " desc)))))
