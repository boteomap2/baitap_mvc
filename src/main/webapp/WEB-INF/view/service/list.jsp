<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
            <div class="jumbotron">
                <div class="row">
                    <div class="col">
                        <h2 class="text-center">Service List</h2>
                    </div>
                    <div class="w-100"></div>

                    <div class="col" style="position: relative">
                        <div id="toolbar">
                            <a href="${contextPath}/service/add">
                                <button id="newBtn" class="btn btn-secondary">
                                    <i class="far fa-plus-circle fa-lg fa-fw"></i>
                                    Add New
                                </button>
                            </a>
                        </div>
                        <table
                                id="table"
                                class="table table-bordered table-hover table-striped"
                                data-toggle="table"
                                data-locale="en-US"
                                data-show-columns="true"
                                data-show-columns-toggle-all="true"
                                data-search="true"
                                data-visible-search="true"
                                data-show-search-clear-button="true"
                                data-search-on-enter-key="true"
                                data-pagination="true"
                                data-page-list="[10, 25, 50, 100, all]"
                                data-show-jump-to="true"
                        >
                            <thead>
                                <tr>
                                    <th data-field="serviceId" data-sortable="true" data-switchable="false">Service Id</th>
                                    <th data-field="name" data-sortable="true">Name</th>
                                    <th data-field="unit" data-sortable="true">Unit</th>
                                    <th data-field="price" data-sortable="true">Price</th>
                                    <th data-field="operate"
                                        data-switchable="false"
                                        data-align="center"
                                        data-formatter="operateFormatter"
                                        data-events="operateEvents"
                                    >
                                        Operation
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${services}" var="service">
                                <tr>
                                    <td>${service.serviceId}</td>
                                    <td>${service.name}</td>
                                    <td>${service.unit}</td>
                                    <td>${service.price}</td>
                                    <td></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- delete Modal -->
        <div
                class="modal fade"
                id="deleteModal"
                tabindex="-1"
                role="dialog"
                aria-labelledby="deleteModalTitle"
                aria-hidden="true"
        >
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Delete Confirmation</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">Are you sure to delete this row?</div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                            Close
                        </button>
                        <button id="deleteModalBtn" type="button" class="btn btn-danger">
                            Delete
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="../footer.jsp"%>
    </body>
    <script src="<c:url value="/assets/js/validate-method.js" />"></script>
    <script src="<c:url value="/assets/js/service/list.js" />"></script>

</html>