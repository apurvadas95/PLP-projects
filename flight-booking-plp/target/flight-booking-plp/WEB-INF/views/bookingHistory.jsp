<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<html>
    <head>
        <mytags:jquery />
        <mytags:style />
        <mytags:bootstrap />

    </head>
    <body >

        <div class="navbar navbar-inverse navbar-expand">
            <mytags:menu/>
        </div>

        <div class="container">
            <form method="post" action="bookingHistory.htm" >
                    <table border=1>
                                <tr>

                                    <th>Name</th>
                                    <th>Age</th>

                                    <th>FlightNo</th>
                                    <th>Source</th>
                                    <th>Destination</th>
                                    <th>Time</th>
                                    <th>Duration</th>
                                    <th>Date</th>
                                    <th>TicketNo</th>
                                    <th>Status</th>
                                    <th>Clear</th>

                                </tr>
                                <tr>
                                <c:forEach var="booking" items="${bookings}">

                                       <td><c:out value="${booking.name}"/></td>
                                        <td><c:out value="${booking.age}"/></td>
                                        <td><c:out value="${booking.flights.flightNo}"/></td>
                                        <td><c:out value="${booking.flights.source}"/></td>
                                        <td><c:out value="${booking.flights.destination}"/></td>
                                        <td><c:out value="${booking.flights.time}"/></td>
                                        <td><c:out value="${booking.flights.duration}"/></td>

                                        <td><c:out value="${booking.flights.date}"/></td>
                                        <td><c:out value="${booking.ticketNo}"/></td>

                                        <td>
                                            <c:if test="${booking.status == 1}">
                                                <input type="radio" name="ticketNo" value="${booking.ticketNo}">
                                            </c:if>
                                            <c:if test="${booking.status == 0}">
                                                Cancelled
                                            </c:if>
                                        </td>

                                        <td >

                                            <c:if test="${booking.status == 0}">
                                                <input type="button" class="btn btn-danger" onclick="onClickDelete(${booking.ticketNo})" value="Delete" />
                                            </c:if>
                                        </td>

                                    </tr>
                                </c:forEach>
                            </table></br>
            <input type="submit" class="btn btn-primary" onclick="return confirm('Are you sure you want to continue')"
            value="Cancel"/></br></br>

            </form>
            <form method="post" id="deleteForm" action="delete.htm" >
                <input name="ticketNo" type="hidden" id="deleteTicketNo" value="" />
            </form>
        </div>
            <footer class="page-footer font-small blue pt-4" style="margin-left:60px">

        <mytags:footer/>

        <script type="text/javascript">
            function onClickDelete(ticketNo) {
                if (null != ticketNo
                    && confirm('Are you sure you want to continue') == true) {

                    document.getElementById("deleteTicketNo").value = ticketNo;
                    document.getElementById("deleteForm").submit();
                }
            }
        </script>
    </body>
</html>
