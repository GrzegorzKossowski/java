# Phonebook
Simple JEE phonebook test for Decsoft S.A.

Known issues:

1. ~~hibernate & JEE error. No solution on web :-(. Plain java works fine. JEE does not...~~
 ```java
 java.lang.NoSuchMethodError: org.hibernate.internal.CoreMessageLogger.debugf(Ljava/lang/String;I)V
 ```
 Problem solved: use **Tomcat** vs. ~~Glassfish~~

2. **TODO**: Last search list doesn't update after edit/delete.
 ```java
  java.lang.IllegalArgumentException: attempt to create delete event with null entity
 ```
