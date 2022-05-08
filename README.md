# ExploreCountriesBackEnd_Spring
A Back-end service that uses a ready API to create Restful endpoint methods such as get and post methods to retrieve countries information 



#ExploreCountriesBackEnd_Spring

Its basiclly a back-end service to consume data from a ready JSON API that allows the user to get specific data about countries.

The HTTP methods that I've used in the service to build an Endpoint were GET and POST.

The GET Method is working fine with out any errors it sends a request and gets back the response for a specific data. However,
the POST Method doesn't work as expected it sends a request and the server gets it but, the response keeps on getting a 301/302 status code which refers to MOVED_PERMENENTLY 
it's a server error that occurs and redirects the response to another URL.
I've tried severl times to adjust the error but unfortunately I couldn't.
so, I've decided to send the POST Method in the frontend app as a direct request to the Given API.

##############
Language used to code: Java

WHY Java?
Java allows us to write the code once and run it anywhere on any platform.
I personly find java the most suitable programming language for server side that I hope to master more and more.


Framework used for back-end development: Spring

WHY Spring ?

Spring helps developers create high performing applications using plain old Java objects (POJOs).
One of the main advantages of Spring Framework is its use of the Dependency Injection pattern. 
DI makes it much easier to implement the functionality that applications need, and allows to develop loosely coupled, more general classes.
