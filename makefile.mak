# Honor Pledge: I pledge that I have neither 
# given nor receieved any help on this assignment.
# A5: A Healthy Dose of Inheritence, aka subclass action law suit
# Java Makefile
# David Haines

Driver.class: Driver.java
	javac Driver.java
	
Employee.class: Employee.java
	javac Employee.java
	
Pharmacist.class: Pharmacist.java
	javac Pharmacist.java

PharmMan.class: PharmMan.java
	javac PharmMan.java
	
SeniorTech.class: SeniorTech.java
	javac SeniorTech.java
	
Tech.class: Tech.java
	javac Tech.java
	
clean:
	rm *.class