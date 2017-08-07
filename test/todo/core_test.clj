(ns todo.core-test
  (:require [clojure.test :refer :all]
            [todo.core :refer :all]))

(deftest adding-todos
    (testing "add-todo adds a todo to a list"
      (let [result (add-todo ["wake up"] "make breakfast")]
          (is (= result #{ "make breakfast" "wake up" })))))

(deftest deleting-todos
    (testing "del-todo removes a todo from a list"
        (let [result (del-todo ["one" "two"] "two")]
            (is (= result #{"one"})))))
