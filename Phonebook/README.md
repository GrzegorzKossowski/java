# Phonebook
---
Simple JEE phonebook test for Decsoft S.A.

Known issues:

1. UTF-8 coding - polish Łękotka Śródstopa doesn't work...
 ```java
 Severe:   java.sql.SQLException: 
 Incorrect string value: '\xC5?\xC4?ko...' for column 'firstname' at row 1
 ```

2. hibernate & JEE error. No solution on web :-(. Plain java works fine. JEE does not...
 ```java
 java.lang.NoSuchMethodError: org.hibernate.internal.CoreMessageLogger.debugf(Ljava/lang/String;I)V
 ```


