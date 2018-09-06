<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<html>
<head>
<mytags:jquery />
    <mytags:style />
    <mytags:bootstrap />
</head>
<body>

    <div class="navbar navbar-inverse navbar-expand">
        <mytags:menu/>
    </div>

 <div class="container">
    <c:choose>
	    <c:when test="${person != null}">
	        <h3>Profile</h3>
		    <table border=1>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>EmailId</th>

                </tr>
                <tr>
                    <td><c:out value="${person.name}"/></td>
                    <td><c:out value="${person.age}"/></td>
                    <td><c:out value="${person.emailId}"/></td>
                </tr>
		    </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-danger">
                Invalid EmailId/Password
            </div>
        </c:otherwise>
    </c:choose></br></br>
    <footer class="page-footer font-small blue pt-4" style="margin-left:60px">

<mytags:footer/>
</div>
</body>
</html>
