# todo

Classic todo list app implementation in clojure

## Installation

`lein uberjar`

## Usage

    $ java -jar todo-0.1.0-standalone.jar <cmd> [title]

### Params

* `cmd`: the command to execute, can be `add`, `del` or `list`
* `title`: title of the todo on which to operate (for `add` or `del`)

## Notes

Freaks out unless `./todojure.txt` exists for it to use as storage. Next task is
to fix this 😉.
