## Welcome to concurrency and thread coordination!

We often want to stop threads for one of the following reasons:

1. clean up resources being used by a finished thread
2. stop a thread that is misbehaving
3. stop a thread that is taking too long
4. stop a thread that is blocked:
    1. waiting for a condition that may never occur
    2. waiting for a resource that may never become available
    3. waiting for a lock that may never be released.

###  Study the files in this order:

1. MemoryConsistencyExample.java
2. BlockingProblem.java
3. BlockingSolution.java
4. Interrupt.java
5. JoiningThreads.java
6. JoiningDemo.java
7. WaitNotifyExample.java
8. ConditionVariableExample.java
9. DaemonThreadDemo.java

