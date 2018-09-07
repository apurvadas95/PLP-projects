<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<mytags:jquery />
<mytags:style />
<mytags:bootstrap />
</head>
<body class="text-center">
    NEW
    <div class="navbar navbar-inverse navbar-expand">
        <mytags:menu/>
    </div>
    <div class="container text-center">

         <c:if test="${error != null && error=='AUTH_FAILED'}">
             <div class="alert alert-danger">
                 Invalid EmailId/Password
             </div>
          </c:if>

        <div class="text-center">



            <div style="width:30%; margin-left:35%">
        <c:url value='/j_spring_security_check' var="loginUrl"/>
        <c:url value='/Images/Expedia.png' var="expediaLogo"/>
        <form method="post" action=${loginUrl} >
                  <img class="mb-4" src=${expediaLogo} alt="" width="72" height="72"></img>
                  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                  <label for="inputEmail" class="sr-only">Email address</label>
                  <input name="j_username" type="text" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                  <label for="inputPassword" class="sr-only">Password</label>
                  <input name="j_password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>

                  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div>
        </div>

        <mytags:footer/>
    </div>
</body>
</html>