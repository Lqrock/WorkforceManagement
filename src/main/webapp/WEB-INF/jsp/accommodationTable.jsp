<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <html lang="en">
  <head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
  </head>
  <body>
    <div class="container table-responsive py-5">
      <table class="table table-bordered table-hover">
        <thead class="thead-dark">
          <tr>
            <th>id</th>
            <th>owners Name</th>
            <th>Ownership Type</th>
            <th>City</th>
            <th>Address</th>
            <th>Province</th>
            <th>Rental Period</th>
            <th>Notice Period</th>
            <th>Has Internet</th>
            <th>Has Parking</th>
            <th>rent</th>
            <th>deposit</th>
          </tr>
          <c:forEach items="${accommodations}" var="accommodation">
            <tr>
              <td>${accommodation.id}</td>
              <td>${accommodation.ownersName}</td>
              <td>${accommodation.ownershipType}</td>
              <td>${accommodation.city}</td>
              <td>${accommodation.address}</td>
              <td>${accommodation.province}</td>
              <td>${accommodation.rentalPeriod}</td>
              <td>${accommodation.noticePeriod}</td>
              <td>${accommodation.hasInternet}</td>
              <td>${accommodation.hasParking}</td>
              <td>${accommodation.rent}</td>
              <td>${accommodation.deposit}</td>
            </tr>
          </c:forEach>
          </tbody>
      </table>
    </div>
  </body>
  <link href="
			<c:url value=" /css/style.css" />" rel="stylesheet">
</html>