<html xmlns='http://www.w3.org/1999/xhtml' xmlns:th='http://www.thymeleaf.org'>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <head>
        <title>Result</title>
    </head>
    <body>
     <!--<h3 c:if test="${error}" th:text='${error}' style='color: red;'></h3>  -->   
        <%-- <div th:unless='${error}'> --%>
            <h3 style='color: green;'>Success!</h3>
            <div>Id: ${id}</div>
            <div>Status: ${status}</div>
           <%--  <div>Charge id.: ${chargeId}</div> --%>
            <div>Balance transaction id: ${balance_transaction}</div>
        <!-- </div> -->
        <a href='/checkout.html'>Checkout again</a>
    </body>
</html>