<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tic Tac Toe</title>
</head>
<body>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
    <script>
        function submitSize() {
            var size = $("#size").val();
            window.location = "http://localhost:8080/" + "boardsize/" +size ;
        }
        function submitCoordinate() {
            var coordinate = $("#coordinate").val();
            window.location = "http://localhost:8080/" + "coordinate/" +coordinate ;
        }
    </script>

    <h1>Tic Tac Toe</h1>
    <c:if test="${empty board}">
    <div>
        <form NAME="form1" METHOD="POST">
            <label>
                <input type='number' id="size" min="3"/>
            </label>
            <input TYPE="button" VALUE="Assign board size" id="sizebutton" ONCLICK="submitSize()">
        </form>
    </div>
    </c:if>
    <c:if test="${not empty board}">
        <div>
            <c:choose>
                <c:when test="${player}">
                    <p>Its Player One Turn :</p>
                </c:when>
                <c:otherwise>
                    <p>Its Player Two Turn :</p>
                </c:otherwise>
            </c:choose>

            <form NAME="form2" METHOD="POST">
                <label>
                    <input type='text' id="coordinate" pattern="/^(\d+(?:[\.\,]\d{1,2})?)$/"/>
                </label>
                <INPUT TYPE="button" VALUE="Assign coordinate to fill" id="coordinatebutton" ONCLICK="submitCoordinate()">
            </form>
        </div>
    </c:if>
    <div style="white-space:pre;">
        <c:forEach items="${board}" varStatus="loop">
           ${board[loop.index]}
        </c:forEach>
    </div>
    <c:if test="${error ne null}">
        <div>
            <p>Error: ${error}</p>
        </div>
    </c:if>
</body>
</html>