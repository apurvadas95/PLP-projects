<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <mytags:jquery />
    <mytags:style />
    <mytags:bootstrap />

    <script type="text/javascript">
        function displayForm(value) {
            if (value == 1) {
                document.getElementById("other").style.visibility = 'visible';
                document.getElementById("self").style.visibility = 'hidden';
            } else if (value == 0) {
                 document.getElementById("other").style.visibility = 'hidden';
                 document.getElementById("self").style.visibility = 'visible';
            } else {}
        }

        function validateForm () {
            return vaidateFlightRadioButtons();
        }

        function vaidateFlightRadioButtons () {
        debugger;
            var flightsRadios = document.querySelectorAll(".flights:checked");

            if (null != flightsRadios
                && flightsRadios.length > 0) {
                return true;
            }
            alert("Please select a flight.");
            return false;
        }

    </script>

</head>
<body>


        <div class="navbar navbar-inverse navbar-expand">
            <mytags:menu/>
        </div>

        <div class="container">

        <h3>Flights</h3>

        <form>
        <div class="navbar navbar-inverse navbar-expand">
            <div class="container-fluid">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <label>Self</label>

                            <input type="radio" name="person" onclick="displayForm(0)" checked/>
                    </li>
                    <li class="nav-item active">
                        <label>Other</label>
                             <input type="radio" name="person" onclick="displayForm(1)" />

                    </li>
                </ul>
            </div>

        <form>



            </form>
        </div>
     <form style="visibility:hidden" onsubmit="return validateForm()" method="post" id="other" action="other.htm">
                <label for="name">Name:</label><input type="text" name="name" required /><br/>
                <label for="age">Age:</label><input type="number" max="100" min="0" name="age" required/><br/></br>
                <c:choose>
                    <c:when test="${fn:length(flights) gt 0}">
                        <table border=1>
                            <tr>
                                <th>FlightNo</th>
                                <th>Source</th>
                                <th>Destination</th>
                                <th>Time</th>
                                <th>Duration</th>
                                <th>Date</th>
                            </tr>
                            <c:forEach var="flights" items="${flights}">
                                    <td><c:out value="${flights.flightNo}"/></td>
                                    <td><c:out value="${flights.source}"/></td>
                                    <td><c:out value="${flights.destination}"/></td>
                                    <td><c:out value="${flights.time}"/></td>
                                    <td><c:out value="${flights.duration}"/></td>
                                      <jsp:useBean id="newsDate" class="java.util.Date" />
                                       <jsp:setProperty name="newsDate" property="time" value="${booking.flights.date}" />

                                        <fmt:formatDate value="${newsDate}" pattern="dd/MM/yyyy" var="date"/>
                                    <td><c:out value="${date}"/></td>
                                    <td>
                                <input type="radio" class="flights" name="flightNo" value="${flights.flightNo}"></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                    <c:otherwise>No flights found</c:otherwise>
                </c:choose>
                </br></br>
                <input type="submit" class="btn btn-primary" value="Book" onclick="return confirm('Are you sure you want to continue')" /><input type="reset" class="btn btn-primary" />
            </form>

            <form id="self" onsubmit="return validateForm()" action="self.htm" method="post">
            <c:choose>
                <c:when test="${fn:length(flights) gt 0}">
                    <table border=1>
                        <tr>
                            <th>FlightNo</th>
                            <th>Source</th>
                            <th>Destination</th>
                            <th>Time</th>
                            <th>Duration</th>
                            <th>Date</th>
                        </tr>
                        <c:forEach var="flights" items="${flights}">
                                <td><c:out value="${flights.flightNo}"/></td>
                                <td><c:out value="${flights.source}"/></td>
                                <td><c:out value="${flights.destination}"/></td>
                                <td><c:out value="${flights.time}"/></td>
                                <td><c:out value="${flights.duration}"/></td>

                                <td><c:out value="${flights.date}"/></td>
                                <td><input type="radio" class="flights" name="flightNo" value="${flights.flightNo}"></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>No flights found</c:otherwise>
            </c:choose>
            </br></br>
                <input type="submit" value="Book" class="btn btn-primary" onclick="return confirm('Are you sure you want to continue')"/>
            </form>


            <mytags:footer/>
        </div>

</body>
</html>
