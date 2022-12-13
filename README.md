# OOP - Streaming Platform

*Alexandru Mihai 323CA*

---
## Keywords
* Singleton Pattern -- Factory Pattern -- Strategy Pattern
* Streaming Service -- Navigation between pages -- Users watch movies :D!

---
## Introduction

Nowadays, everyone is using streaming platforms to watch their favorite shows and movies.
Streaming services such as Netflix, HBO MAX, Amazon Prime gained a strong reputation as
being client intuitive and easy to access and use, attracting millions of people
from all around the world.

This project plans to replicate these kinds of streaming platforms features using OOP
principles in order to develop an easily extensible and clear to understand code.

---
## Project Structure

* fileio package: contains classes used to read the input provided in a JSON format and
map it accordingly to their fields.
* database package: contains 3 **Singleton** classes used to store the users, movies and
actions available for the platform. The Singleton classes are dynamically changing when
a user or a movie is added and assures the platform flow by the sequence of actions given.
* pages package: contains the available pages on the platform which store the available
pages that can be further access and the actions available on the specific page.
* actions package: using the **Strategy Design Pattern** each type of action is generically
implemented inside the abstract Action class which will be further detailed inside each
inherited classes. These classes do a specific action corresponding to their name and act
upon the output.
* server package: the Server class assures the storing of both input data and transfers of
the output information. The Navigator class acts upon the current page, current user and
current movies accordingly to the flow of actions provided.
* helpers package: incorporates constants ensuring the readability of the code. In addition,
the ActionFactory uses the **Factory Design Pattern** in order to delegate each type of 
action in order to specify their role. The FormatOutput class organises the information
in order to be converted easier in JSON format.

---
## Platform Flow

* The user starts on the Unauthenticated Page and has the choice of either login or register
on the platform.
* The login action is valid only if the user is found in the users' database.
* A new user can register with credentials which will transfer him to the Authenticated Page.
* On Authenticated Page the user has a number of possible actions:
  * Displaying the movies available in his country
  * Upgrading their account
  * Logging out and returning on the Unauthenticated Page
* On the Movies Page, filters and search actions can be performed, displaying only the
movies corresponding to a certain pattern. A user can further purchase a movie by selecting it
which will mark it available for watch. After watching a movie, the user is able to
like or rate the movie accordingly to their personal believes.
* The Upgrades Page allows the user to either change his type of account to premium or
purchase tokens which can be used to further buy movies.

---
## Personal Evaluation

The project proved really useful in order to get used to design patterns as well as
being able to develop a considerable large project by myself.
The topic was very interesting, however I consider that the errors could have been treated
more specifically (not just a generic error message). Keep the good work up!