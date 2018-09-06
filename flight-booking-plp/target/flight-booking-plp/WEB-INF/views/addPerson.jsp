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

    <c:if test="${err != null && err == true}">
    	<div class="alert alert-danger">
          <strong>Registration Failed</strong> email id already registered
        </div>
    </c:if>
    <c:if test="${err != null && err == false}">
    	<div class="alert alert-success">
          <strong>Registration Success</strong>
        </div>
    </c:if>


    <h4>Register</h4>
    <form method="post" action="addPerson.htm">

        <div class="row">
            <div class="col col-sm-1">
                <label for="name">Name:</label>
            </div>
            <div class="col col-sm-1">
                <input type="text" name="name" required />
            </div>
        </div>

        <div class="row">
            <div class="col col-sm-1">
                 <label for="age">Age:</label>
            </div>
            <div class="col col-sm-1">
                <input type="number" max="100" min="0" name="age" required/>
            </div>
        </div>

        <div class="row">
            <div class="col col-sm-1">
                 <label for="emailId">Email Id:</label>
            </div>
            <div class="col col-sm-1">
                <input type="email" name="emailId" required />
            </div>
        </div>

        <div class="row">
            <div class="col col-sm-1">
                 <label for="password">Password:</label>
            </div>
            <div class="col col-sm-1">
                <input type="password" name="password" required/>
            </div>
        </div>

        <div class="row m-2">
            <div class="col col-sm-1">

            </div>
            <div class="col col-sm-1">
                <input class="btn btn-primary" type="submit" />
            </div>
            <div class="col col-sm-1">
                <input class="btn  btn-primary" type="reset" />
            </div>
        </div>
    </form>
    <footer class="page-footer font-small blue pt-4" style="margin-left:60px">
    <mytags:footer/>
    </footer>
</div>

</body>
</html>
