<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All Employees</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="empl" items="${allEmplo}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${empl.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteInfo">
            <c:param name="empId" value="${empl.id}"/>
        </c:url>

        <tr>
            <td>${empl.name}</td>
            <td>${empl.surname}</td>
            <td>${empl.department}</td>
            <td>${empl.salary}</td>
            <td>
                <input type="button" value="Update"
                onclick="window.location.href='${updateButton}'"/>
            </td>
            <td>
                <input type="button" value="Delete"
                onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>


</table>

<br><br>
<input type="button" value="Add"
onclick="window.location.href = 'addNewEmployee'">

</body>

</html>