<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Service Register</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
        <link rel="stylesheet" href="<c:url value="/assets/css/FontAwesome5.css" />">
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap-table/bootstrap-table.min.css" />">
        <link
                rel="stylesheet"
                href="<c:url value="/assets/css/bootstrap-table/extensions/page-jump-to/bootstrap-table-page-jump-to.min.css" />"
        />
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />">
    </head>
    <body class="d-flex flex-column">
    <script src="<c:url value="/assets/js/jquery.min.js" />"></script>
    <script src="<c:url value="/assets/js/bootstrap.bundle.min.js" />"></script>
    <script src="<c:url value="/assets/js/bootstrap-table/bootstrap-table.min.js" />"></script>
    <script src="<c:url value="/assets/js/bootstrap-table/locale/bootstrap-table-locale-all.min.js" />"></script>
    <script src="<c:url value="/assets/js/bootstrap-table/extensions/page-jump-to/bootstrap-table-page-jump-to.min.js" />"></script>
    <script src="<c:url value="/assets/js/jquery-validate.js" />"></script>

    <%@ include file="../header.jsp"%>

    <div class="container flex-grow-1">
        <form:form action="${contextPath}/register/service" method="post" modelAttribute="serviceUsage">
            <div class="jumbotron col-7 mx-auto mt-5">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <h2 class="text-center">Service Register</h2>
                    </div>
                    <div class="w-100"></div>
                    <div class="col-10">
                        <div class="form-group">
                            <form:label path="customer.customerId">Customer</form:label>
                            <form:select path="customer.customerId" class="form-control" >
                                <form:options items="${customers}" itemLabel="name" itemValue="customerId"/>
                            </form:select>
                            <form:errors path="customer.customerId" cssClass="error" />
                        </div>
                    </div>
                    <div class="w-100"></div>
                    <div class="col-10">
                        <div class="form-group">
                            <form:label path="service.serviceId">Service</form:label>
                            <form:select path="service.serviceId" class="form-control" >
                                <form:options items="${services}" itemLabel="name" itemValue="serviceId"/>
                            </form:select>
                            <form:errors path="service.serviceId" cssClass="error" />
                        </div>
                    </div>
                    <div class="w-100"></div>
                    <div class="col-10">
                        <div class="form-group">
                            <form:label path="serviceUsagePk.dateUsage">Date Usage</form:label>
                            <form:input
                                    path="serviceUsagePk.dateUsage"
                                    type="date"
                                    class="form-control"
                            />
                            <form:errors path="serviceUsagePk.dateUsage" cssClass="error" />
                        </div>
                    </div>
                    <div class="w-100"></div>
                    <div class="col-10">
                        <div class="form-group">
                            <form:label path="serviceUsagePk.timeUsage">Time Usage</form:label>
                            <form:input
                                    path="serviceUsagePk.timeUsage"
                                    type="time"
                                    class="form-control"
                            />
                            <form:errors path="serviceUsagePk.timeUsage" cssClass="error" />
                        </div>
                    </div>
                    <div class="w-100"></div>
                    <div class="col-10">
                        <div class="form-group">
                            <form:label path="amount">Amount</form:label>
                            <form:input
                                    path="amount"
                                    type="number"
                                    class="form-control"
                            />
                            <form:errors path="amount" cssClass="error" />
                        </div>
                    </div>
                    <div class="w-100"></div>
                    <div class="col-10 d-flex justify-content-end">
                        <div class="form-group">
                            <form:button class="btn btn-primary btn-md">Submit</form:button>
                        </div>
                    </div>

                </div>
            </div>
        </form:form>
    </div>

    <%@ include file="../footer.jsp"%>
    </body>
</html>