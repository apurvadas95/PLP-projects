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

    <form method="post" onsubmit="return myLog()" action="searchFlights.htm">

    <div class="row">
        <div class="col col-sm-1">
             <label for="name">Source:</label>
        </div>
        <div class="col col-sm-1">
            <select name="source">
                <c:forEach items="${flights}" var="flights">
                    <option value="${flights[0]}">${flights[0]}</option>
                </c:forEach>
             </select><br />
        </div>
    </div>

    <div class="row">
        <div class="col col-sm-1">
             <label for="name">Destination:</label>
        </div>
        <div class="col col-sm-1">
            <select name="destination">
                <c:forEach items="${flights}" var="flights">
                    <option value="${flights[1]}">${flights[1]}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="row">
        <div class="col col-sm-1">
            <label for="date">Date:</label>
        </div>
        <div class="col col-sm-1">
            <input type="date" name="date"/>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-2">
            <button style="margin-top:5%;margin-left:50%;" class="btn btn-block btn-primary" type="submit">Search</button>
        </div>
    </div>

    </form>
        <footer class="page-footer font-small blue pt-4" style="margin-left:60px">

    <mytags:footer/>
    </div>
</body>
</html>