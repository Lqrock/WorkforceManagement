<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <html lang="en">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <html>
  <head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
  </head>

    <body>

        <form:form action="create" modelAttribute="accommodationDTO">
            owners name: <form:input path="ownersName" />
            <br><br>
            email:  <form:input path="email" />
            <br><br>
            ownership type:  <form:input path="ownershipType" />
            <br><br>
            city:  <form:input path="city" />
            <br><br>
            address:  <form:input path="address" />
            <br><br>
            province:  <form:input path="province" />
            <br><br>
            rental Period:  <form:input path="rentalPeriod" />
            <br><br>
            notice Period  <form:input path="noticePeriod" />
            <br><br>
            Internet status:  <form:input path="hasInternet" />
            <br><br>
            Parking status:  <form:input path="hasParking" />
            <br><br>
            deposit:  <form:input path="deposit" />
            <br><br>

            <input type="submit" value="create" />
        </form:form>

    </body>

   </html>