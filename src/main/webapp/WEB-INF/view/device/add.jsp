<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Device List</title>
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
        <form:form action="${contextPath}/device/add" method="post" modelAttribute="device">
            <div class="jumbotron col-7 mx-auto mt-5">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <h2 class="text-center">Create New Device</h2>
                    </div>
                    <div class="w-100"></div>
                        <div class="col-10">
                            <div class="form-group">
                                <label for="position">Position</label>
                                <form:input
                                        type="text"
                                        path="position"
                                        class="form-control"
                                />
                                <form:errors path="position" cssClass="error" />
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="col-10">
                            <div class="form-group">
                                <label for="status">Status</label>
                                <form:input
                                        path="status"
                                        type="text"
                                        class="form-control"
                                />
                                <form:errors path="status" cssClass="error" />
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
<script>
  $("#updateModalForm").validate({
    rules: {
      updateDevicePosition: {
        required: true,
      },
      updateDeviceStatus: {
        required: true,
      },
    },
    messages: {
      updateDevicePosition: {
        required: "Device position is required",
      },
      updateDeviceStatus: {
        required: "Device status is required",
      },
    },
    errorPlacement: function (error, element) {
      // for check box and radio
      if (element.attr("name") == "checkme") {
        error.appendTo("#error-mess");
      } else {
        error.insertAfter(element);
      }
    },
    onfocusout: function (element) {
      // "eager" validation
      this.element(element);
    },
    success: "valid",
  });

  $("#addModalForm").validate({
    rules: {
      addDevicePosition: {
        required: true,
      },
      addDeviceStatus: {
        required: true,
      },
    },
    messages: {
      addDevicePosition: {
        required: "Device position is required",
      },
      addDeviceStatus: {
        required: "Device status is required",
      },
    },
    errorPlacement: function (error, element) {
      // for check box and radio
      if (element.attr("name") == "checkme") {
        error.appendTo("#error-mess");
      } else {
        error.insertAfter(element);
      }
    },
    onfocusout: function (element) {
      // "eager" validation
      this.element(element);
    },
    success: "valid",
  });
</script>
<script src="<c:url value="/assets/js/validate-method.js" />"></script>
</html>