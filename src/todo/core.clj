(ns todo.core
  (:gen-class))

(def DFLT_STOR "./todojure.txt")

(defn is-not
  "checks inequality of todos"
  ([a b] (not (= a b)))
  ([a] (fn [b] (is-not a b))))

(defn add-todo
  "adds a new todo to the list"
  [todos title]
  (set (cons title todos)))

(defn del-todo
  "removes a todo from the list"
  [todos title]
  (set (filter (is-not title) todos)))

(defn load-storage
  "loads todos from storage"
  []
  (clojure.string/split-lines (slurp DFLT_STOR)))

(defn save-storage
  "saves todos to storage"
  [todos]
  (spit DFLT_STOR (clojure.string/join "\n" (filter #(not (empty? %)) todos))))

(defn do-add-todo
  "usage: todo add <title>"
  [[title]]
  (save-storage (add-todo (load-storage) title)))

(defn do-del-todo
  "usage: todo del <title>"
  [[title]]
  (save-storage (del-todo (load-storage) title)))

(defn do-list-todos
  "usage: todo list"
  []
  (dorun (println (clojure.string/join "\n" (map #(str "[-] " %) (load-storage))))))

(defn -main
  "usage: todo <cmd> [todo-title]"
  [cmd & args]
  (cond
    (= cmd "add") (do-add-todo args)
    (= cmd "del") (do-del-todo args)
    (= cmd "list") (do-list-todos)
    :else (println (str "unknown command: " cmd))))

; vim: set ts=8 sw=4 tw=0
