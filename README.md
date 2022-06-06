# booking-app

This is a sample app to create movie shows
Runn the appplication with  following command
mvnw spring-boot:run

Create a new show by
POST http://localhost:8080/showDetails
{"movieId": "2", "theatreId": "1","showDate": "2022-06-06","showTime": "15:00"}

Get show details for a theatre using
GET localhost:8080/showDetails?theatreId=1&showDate=2022-06-05
