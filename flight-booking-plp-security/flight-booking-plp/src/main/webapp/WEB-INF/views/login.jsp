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
    <div class="navbar navbar-inverse navbar-expand">
        <mytags:menu/>
    </div>
    <div class="container text-center">

         <c:if test="${error != null && error=='NO_USER_IN_SESSION'}" >
         <div class="alert alert-danger">
            User not logged in
         </div>
         </c:if>
         <c:if test="${errorInvalid != null && errorInvalid=='INVALID_USER'}">
            <div class="alert alert-danger">
                Invalid EmailId/Password
            </div>
         </c:if>

        <div class="text-center">
            <div style="width:30%; margin-left:35%">
                <form method="post" action="login.htm">
                  <img class="mb-4" src="<c:url value="webapp/Images/Expedia.png" />" alt="" width="72" height="72"></img>
                  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                  <label for="inputEmail" class="sr-only">Email address</label>
                  <input name="emailId" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                  <label for="inputPassword" class="sr-only">Password</label>
                  <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>

                  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div>
        </div>

        <mytags:footer/>
    </div>
</body>
</html>