# Java EE 7 demonstrator

This project provides examples for Java EE application components
packaging and usage (EJB, WAR, etc)

#### calculator-ear
The EAR packaging containing 
- 1 EJB
- 2 WAR 
- 1 JAR ( in "lib" )

#### calculator-jar-ejb
Contains the **Calculator Singleton EJB**  with 2 interfaces (Local and Remote)

#### calculator-war-add
Very simple Web Application using the **Calculator Singleton EJB** located in the same EAR
- Calculator EJB with **local interface** ( "add" servlet and "count" servlet )

#### calculator-war-subtract
Very simple Web Application using the **Calculator Singleton EJB** located in the same EAR
- Calculator EJB with **local interface** ( "count" servlet )
- Calculator EJB with **remote interface** ( "subtract" servlet )


