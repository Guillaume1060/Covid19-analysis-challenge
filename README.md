# covid19-analysis-challenge
Build a data analysis commandline tool that processes a csv file on how Covid 19 has affected trade as of July 2021.

## The Mission

This challenge's aims to introduce the concepts of [object oriented programming](https://en.m.wikipedia.org/wiki/Object-oriented_programming) (_OOP_), [unit testing](https://en.m.wikipedia.org/wiki/Unit_testing) and [build tool](https://www.techopedia.com/definition/16359/build-tool) in a Java context. To do so, it will have you **build a data analysis commandline tool* that processes a [csv file](./assets/covid_and_trade.csv) on how Covid 19 has affected trade as of July 2021. The program itself will **take commands as inputs** to then **process** immediately (_AKA: only one command processed at a time_) that can further receive **parameters** (_either allow users to immediately pass parameters with the command or have the program asks after the command has been typed_), here is a list of mandatory commands your program should recognize:

- `help`: returns a list of available commands with a small description.
- `help <command>`: returns a full explanation of what the "_<command>_" does and what parameters it needs.
- `monthly_total`: returns the sum of both the export and import for a specified month of a specified year.
- `monthly_average`: returns the average of both the export and the import of a specified month of a specified year.
- `yearly_total`: returns an overview of all the monthly totals for a particular year. This command returns the total of each month for both import and export. Then it gives the yearly total for both import and export.
- `yearly_average`: returns an overview of all the montly averages for a particular year, for both import and export. Then it gives the yearly average for both import and export.
- `overview`: returns all the unique values that span the data set: _years_, _countries_, _commodities_, _transportation_ _modes_ and _measures_.

The commands `monthly_total`, `monthly_average`, `yearly_total` and `yearly_average` further have the following parameters available to customize their query:

- `country` (default: "_all_")
- `commodity` (default: "_all_")
- `transport_mode` (default: "_all)")
- `measure` (default: "_$_")

Writing the program is however not enough to complete this challenge. You also have to **write tests**, either "_unit tests_" or "_integration tests_", in order to streamline the debugging process as well as implement the build tool [Maven](https://maven.apache.org/) to manage the project and its dependencies. Although these steps might seem like extra work, as they are, they have the potential to save you lots of time during bigger future project. From now on you should **always make sure** to **write test** and **automate** project management!

Once this is all done, and in the spirit and writing as good a program as possible, you should step back and ask yourself the following questions (_they should help you improve your code and OOP implementation_):

1. How hard is it to add another command in your program? How can you make that process easy?
2. What if all of a sudden, there are also users who don't want a command line tool? Maybe they want a UI. How hard is it to change this in your program? How can you make this easy to do?
3. What if all of a sudden, there are also users who don't want to see the result in the terminal window? Maybe they want the result to be written to a file. How hard is it to change this in your program? How can you make this easy to do?
4. The previous questions basically ask for changes in the core of your program, changes in the "_input_" of your program and changes in the "_output_" of your program. Do you think that is a coincidence? Why? What does this tell you about programming and programmatic solutions in general?

The raw power in object oriented programming is in being able to abstract the stakeholder requirements (_these are all the 'whats' in the program, basically what the program needs todo_) in simple apis which can then be implemented in different ways (_this is 'how' the program should do the expected functionality_) by using polymorphism. For this to work properly, you need classes/modules that can function pretty much on their own, in other words: what these classes/modules need to function is encapsulated in the class.

> **WARNING**: In order to confortably tackle the exercise you should already be able to create rudimentary Java programs. In other words, you should know the **basic syntax**, be able to make **classes** and **interfaces** as well as have good knowledge of **collections** and **generics**. Don't worry if you still need to look up some edge cases such as `APIs` or `keywords`, it's the basics you should already be familiar with.

## Complementary Resources

### About OOP

- Article: [The forgotten history of OOP](https://medium.com/javascript-scene/the-forgotten-history-of-oop-88d71b9b2d9f) (_IMPORTANT!_)
- Article: [How OOP started](http://kristennygaard.org/FORSKNINGSDOK_MAPPE/F_OO_start.html)
- Article: [Meaning of OOP by the man who "invented" the term OOP](https://userpage.fu-berlin.de/~ram/pub/pub_jf47ht81Ht/doc_kay_oop_de), Dr Alan Kay invented the term OOP, but what OOP is today is **no longer what it was originally conceived to be**. In order to be good in OOP, you need to understand this and understand where OOP actually came from.

### Tips

- Always keep in mind that **change and being able to deal with change** is one of the **most important** aspects of software development.
- Object Oriented programming is **just one way to solve problems** with software. It has its benefits and it has its drawbacks.

## Expected Output

At the end of this challenge you should be [able to setup and write basic OOP project](./evaluation.md), which should be verifiable by a repository containing your solution to the exercise.
