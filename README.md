# bowling

this is a bowling scoring program
- [x] basic score
- [x] spare
- [x] strike
- [x] strike bonus
- [x] spare bonus
- [x] validation for input sequence

## How to run the tests

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.
