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
            <th>Model</th>
            <th>Brand</th>
            <th>Plate Number</th>
            <th>Vin</th>
            <th>Mileage</th>
            <th>Tire Type</th>
            <th>Owners Name</th>
            <th>Insurance type</th>
            <th>Tuf expiration date</th>
            <th>Insurance expiration date</th>
            <th>Oil change Indicator</th>
          </tr>
          <c:forEach items="${vehicles}" var="vehicle">
            <tr>
              <td>${vehicle.id}</td>
              <td>${vehicle.model}</td>
              <td>${vehicle.brand}</td>
              <td>${vehicle.plateNumber}</td>
              <td>${vehicle.vin}</td>
              <td>${vehicle.mileage}</td>
              <td>${vehicle.tireType}</td>
              <td>${vehicle.ownersName}</td>
              <td>${vehicle.insuranceType}</td>
              <td>${vehicle.tufExpirationDate}</td>
              <td>${vehicle.insuranceExpirationDate}</td>
              <td>${vehicle.oilChangeIndicator}</td>
            </tr>
          </c:forEach>
          </tbody>
      </table>
    </div>
  </body>
  <link href="
			<c:url value=" /css/style.css" />" rel="stylesheet">
</html>