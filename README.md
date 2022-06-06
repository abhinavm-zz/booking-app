# booking-app

This is a sample app to create movie shows
Runn the appplication with  following command
mvnw spring-boot:run

Create a new show by
POST localhost:8080/showDetails
{"movieId": "2", "showDate": "2022-06-06","showTime": "15:00", "theatreDetails":{"id":1}}

Get show details for city, date and movie use below
GET localhost:8080/theatreDetails?showDate=2022-06-05&city=pune&movieId=1
