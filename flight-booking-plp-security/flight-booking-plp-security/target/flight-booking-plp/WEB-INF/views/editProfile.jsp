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

    <h4>Edit Profile</h4>
    <form method="post" action="editProfile.htm">

        <div class="row">
            <div class="col col-sm-1">
                <label for="name">Name:</label>
            </div>
            <div class="col col-sm-1">
                <input type="hidden" name="name" value="${person.name}"  />
                <input disabled type="text" name="name" value="${person.name}"  />
            </div>
        </div>

        <div class="row">
            <div class="col col-sm-1">
                 <label for="age">Age:</label>
            </div>
            <div class="col col-sm-1">
                <input type="hidden" max="100" min="0" name="age" value="${person.age}" />
                <input disabled type="number" max="100" min="0" name="age" value="${person.age}" />
            </div>
        </div>

        <div class="row">
            <div class="col col-sm-1">
                 <label for="emailId">Email Id:</label>
            </div>
            <div class="col col-sm-1">
                <input type="hidden" name="emailId" value="${person.emailId}"  />
                <input type="hidden" name="password" value="${person.password}"  />
                <input disabled type="email" name="emailId" value="${person.emailId}"  />
            </div>
        </div>

        <div class="row">
            <div class="col col-sm-1">
                 <label for="address">Address:</label>
            </div>
            <div class="col col-sm-1">
                <input type="text" name="personDetails.address" value="${person.personDetails.address}" required />
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
