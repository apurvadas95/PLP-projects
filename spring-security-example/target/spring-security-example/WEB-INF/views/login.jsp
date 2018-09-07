       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
       <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
       <%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <html>
       <head>
       <mytags:menu />
       <mytags:jquery />
       <mytags:style />
       <mytags:bootstrap />
       </head>
        <h4>Enter your credentials:</h4>
        <c:url value='/j_spring_security_check' var="loginUrl"/>
        <form method="post" action=${loginUrl} >
            <div class="row">
                <div class="col col-sm-1">
                     <label for="username">Email Id:</label>
                </div>
                <div class="col col-sm-1">
                    <input type="text" name="j_username" required />
                </div>
            </div>

            <div class="row">
                <div class="col col-sm-1">
                     <label for="password">Password:</label>
                </div>
                <div class="col col-sm-1">
                    <input type="password" name="j_password" required/>
                </div>
            </div>


            <div class="col-sm-2">
                <button style="margin-left:50%; margin-top:5%;" type="submit" class="btn btn-block btn-primary">Login</button>
            </div>
        </form>
    </div>
