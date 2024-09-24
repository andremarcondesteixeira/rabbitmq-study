# How to compile manually:

`javac -classpath ".;amqp-client-5.16.0.jar;slf4j-simple-1.7.36.jar;slf4j-api-1.7.36.jar" -d . HelloWorld/Send.java HelloWorld/Recv.java`

# Hello World

## How to run the Producer:

`java -classpath ".;amqp-client-5.16.0.jar;slf4j-simple-1.7.36.jar;slf4j-api-1.7.36.jar" com.myapp.HelloWorld.Send`

## How to run the Consumer:

`java -classpath ".;amqp-client-5.16.0.jar;slf4j-simple-1.7.36.jar;slf4j-api-1.7.36.jar" com.myapp.HelloWorld.Recv`