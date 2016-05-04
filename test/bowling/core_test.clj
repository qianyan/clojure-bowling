(ns bowling.core-test
  (:use midje.sweet)
  (:use [bowling.core]))

(facts "about `bowling-scoring`"
  (fact "should add up all numbers if it is just basic score keeping"
    (bowling-scoring "1 2 3 4") => 10)

  (fact "should add next ball roll when there has the spare"
    (bowling-scoring "9 1 9 1") => 29)
  
  (fact "should add the next two ball rolls when there has the strike"
    (bowling-scoring "1 1 1 1 10 1 1") => 18)
  
  (fact "should score 300 pins when all 10 frames are strike"
    (bowling-scoring "10 10 10 10 10 10 10 10 10 10 10 10") => 300)
  
  (fact "should score 279 pins when the first nine frames are strike but the tenth is spare"
    (bowling-scoring "10 10 10 10 10 10 10 10 10 9 1 10") => 279)

  (fact "should validate input score sequence"
    (fact (bowling-scoring "3 8 1 2") => (throws Exception "invalid input sequence!")))

  (fact "should throw assertion error if input score sequrence is empty"
    (fact (bowling-scoring "") => (throws AssertionError))))


