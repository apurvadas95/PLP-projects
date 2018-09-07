<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home</a>
    </li>
    <li class="nav-item">
         <c:if test="${pageContext.request.userPrincipal == null}">
            <a class="nav-link" href="addPerson.htm">Register</a>
         </c:if>
    </li>
    <li class="nav-item" >
     <c:if test="${pageContext.request.userPrincipal == null}">
        <a class="nav-link" href="login.htm">Login</a>
         </c:if>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="searchFlights.htm">Search Flights</a>
    </li>

    <li class="nav-item">
        <c:if test="${pageContext.request.userPrincipal != null}">
            <a class="nav-link" href="bookingHistory.htm">Booking History</a>
        </c:if>
    </li>
    <li class="nav-item">
        <c:if test="${pageContext.request.userPrincipal != null}">
            <a class="nav-link" href="editProfile.htm">Edit Profile</a>
        </c:if>
    </li>
    <li class="nav-item">
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <form action=${logoutUrl} method="post">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <button class="btn btn-link" type="submit">Logout</button>
            </c:if>
        </form>
    </li>
</ul>

<hr />
