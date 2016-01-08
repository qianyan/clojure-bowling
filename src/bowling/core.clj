(ns bowling.core)

(def STRIKE 10)

(defn bowling-scoring [sequence]
  (->> sequence
       (re-seq #"\d+")
       (map read-string)
       (reduce (fn [xs x]
                 (if (and (= STRIKE x) (even? (count xs)))
                   (conj xs x 0)
                   (conj xs x))) [])
       (partition 2)
       (map (fn [[f s]]
              (cond
                (= STRIKE f) [10 \x \y]
                (= STRIKE (+ f s)) [f s \x]
                :else [f s 0])))
       (reduce (fn [xs [f s ss]]
                 (conj (->> xs
                            (map (fn [x] (cond (= \x x) f
                                              (and (= \y x)
                                                   (not= \x s)) s
                                              (= \y x) \x
                                              :else x)))
                            (into [])) f s ss)))
       (partition 3)
       (take 10) ;; 10 => total rounds
       (flatten)
       (filter #(and (not= \x %) (not= \y %)))
       (apply +)))


