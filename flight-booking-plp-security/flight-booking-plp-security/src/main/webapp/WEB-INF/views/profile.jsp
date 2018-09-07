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

 <div class="container-fluid">
    <c:choose>
	    <c:when test="${principal != null}">
	        <div class="jumbotron">
	         <h2>Welcome </h2><h4><c:out value="${principal.name}"/></h4>
	        </div

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
