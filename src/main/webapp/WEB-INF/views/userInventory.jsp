<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Inventory</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="resources/stylesheets/light-theme.css">
</head>
<body>
<div class="container">
    <c:if test="${empty userEquipmentList}">
        <h2>It looks like you have no equipment. Please add some.</h2>
    </c:if>
    <c:if test="${not empty userEquipmentList}">
        <br/><br/>
        <table class="table table-bordered">
            <thead>
               <tr>
                   <th>Serial Number</th>
                   <th>Description</th>
                   <th>Location</th>
                   <th>Condition</th>
                   <th>Vendor</th>
                   <th>Assigned To</th>
                   <th>Defective?</th>
                   <th>Edit</th>
                   <th>Delete</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="equipment" items="${userEquipmentList}">
                   <tr>
                       <td>${equipment.serialNumber}</td>
                       <td>${equipment.description}</td>
                       <td>${equipment.location}</td>
                       <td>${equipment.condition}</td>
                       <td>${equipment.vendor}</td>
                       <td>${equipment.assignedTo}</td>

                       <td align="center">
                           <c:choose>
                               <c:when test="${equipment.defective == 'true'}">
                                   <c:set var="defectiveCheckBoxChecked" value="checked"/>
                               </c:when>
                               <c:otherwise>
                                   <c:set var="defectiveCheckBoxChecked" value=""/>
                               </c:otherwise>
                           </c:choose>
                           <input type="checkbox" onclick="return false;" ${defectiveCheckBoxChecked}>
                       </td>

                       <td>
                           <button type="button" class="btn btn-primary btn-sm">
                               <span class="glyphicon glyphicon-pencil"></span>
                           </button>
                       </td>

                       <td>
                           <button type="button" class="btn btn-primary btn-sm">
                               <span class="glyphicon glyphicon-remove"></span>
                           </button>
                       </td>
                   </tr>
               </c:forEach>
            </tbody>
        </table>
    </c:if>

    <br/>
    <form:form action="processUserInventory" method="post">
        <input type="submit" class="btn btn-primary" name="addEquipment" value="Add Equipment">
    </form:form>
</div>
</body>
</html>
