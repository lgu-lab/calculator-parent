# Java EE 7 demonstrator

This project provides examples for Java EE application components
packaging and usage (EJB, WAR, etc)

This project has been tested with JBoss EAP 7.1


### calculator-ear
The EAR packaging containing 
- 1 EJB
- 2 WAR 
- 1 JAR ( in "lib" )


### calculator-jar-ejb
Contains the **Calculator Singleton EJB**  with 2 interfaces (Local and Remote)
This EJB is used by components located in this project (EAR) 
but also by external components located in "hello-parent" project (other EAR)

### calculator-war-add
Very simple Web Application using the **Calculator EJB** located in the same EAR
- Calculator EJB with **local interface** ( "add" servlet and "count" servlet )


### calculator-war-subtract
Very simple Web Application using the **Calculator EJB** located in the same EAR
- Calculator EJB with **local interface** ( "count" servlet )
- Calculator EJB with **remote interface** ( "subtract" servlet )


### calculator-util-jar
Basic utility JAR to demonstrate how to package "jar" files in "ear /lib" folder
with other dependencies 


### calculator-jar-ejb-client
A standalone "Main" application invoking remotely the **Calculator EJB** 
with **JNDI lookup**

