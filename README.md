
# Spring MVC Bookshop Web App with Walmart Open Api
This project is an example of Spring MVC with jsp. Spring-boot is used in project to keep it simple.

###  Pre-requisite : 
Maven must be installed on your machine. Nothing else meeded!
Please visit [here](https://maven.apache.org/download.cgi) to download Maven project if you need.

### How to install and run

  - Download or pull this repository into your local machine
  - Open project folder (pom.xml file path should be referenced) over a terminal window
  - Run below commands
    - ```sh
      $ mvn clean install
      $ mvn spring-boot:run

### Functions

  - Listing all "Book" categories on left side of web page
  - Listing books of selected category on right side of web page
  - Pagination for listed books of selected book category
  - Displaying the details of selected book

### Pages
##### Main Page
- List of Book Categories
[http://localhost:8080/category](http://localhost:8080/category)
- List of books under a category
[http://localhost:8080/category/3920_582321](http://localhost:8080/category/3920_582321)
- Pagination 
[http://localhost:8080/category/3920_582321?page=2](http://localhost:8080/category/3920_582321?page=2)
##### Detail Page
- Details of selected book
[http://localhost:8080/book?bookId=55801275](http://localhost:8080/book?bookId=55801275)

License
----
MIT

