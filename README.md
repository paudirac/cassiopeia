# cassiopeia

A [re-frame](https://github.com/Day8/re-frame) application designed show
how to construct in an easy way a nontrivial problem in a 
functional style using a right set of tools.

This is somehow inspired by the [guile tutorial](https://www.gnu.org/software/guile/docs/guile-tut/tutorial.html).

## First steps

The first thing to do is to start a leiningen project with the following command.
```
lein new re-frame cassiopeia +test
```

Then run it
```
lein clean
lein figwheel dev
```

This will compile the project and start a development web server serving
at [http://localhost:3449](http://localhost:3449).
A REPL will appear and the prompt will become active when the browser
connects. Now you can type
```
(.info js/console (str "The meaning of life is " (+ 40 2)))
```
and check the browser console to have displayed the log message.

## References

* https://github.com/Day8/re-frame-template
