# Phonebook
Simple JEE phonebook entry level test for Decsoft S.A.

---
Known issues:

**Bug 003**
~~**TODO**: Last search list doesn't update after edit/delete.~~
 ```java
  java.lang.IllegalArgumentException: attempt to create delete event with null entity
 ```

**Bug 002**
~~hibernate & JEE error. No solution on web :-(. Plain java works fine. JEE does not...~~
 ```java
 java.lang.NoSuchMethodError: org.hibernate.internal.CoreMessageLogger.debugf(Ljava/lang/String;I)V
 ```
 Problem solved: use **Tomcat** vs. ~~Glassfish~~

**Bug 001**
~~polish diactric marks don't show properly~~
 ```java
 Severe:   java.sql.SQLException: Incorrect string value: '\xC5?\xC4?cz...' for column 'firstname' at row 1
 ```
 Problem solved
