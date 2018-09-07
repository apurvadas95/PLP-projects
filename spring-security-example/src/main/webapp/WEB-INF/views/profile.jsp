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

        <!-- For login user -->
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
        <form action=${logoutUrl} method="post" id="logoutForm">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h2>
                    User : ${pageContext.request.userPrincipal.name} | <button type="submit" class="btn btn-primary">Logout</button>
                </h2>
            </c:if>
        </form>

</body>
</html>