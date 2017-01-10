<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <title>${initParam['pageTitle']}</title>
    </head>
    <body>
        <div id="top-bar">
            <h3>${initParam['pageTitle']}</h3>
            Hello <strong><c:out default="Guest" value="${user}" /></strong>
            <c:if test="${!empty user}">
                <a href="${pageContext.request.contextPath}/logout" title="Logout">
                    <!-- Icon made by Freepik from www.flaticon.com -->
                    <img src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTguMS4xLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgdmlld0JveD0iMCAwIDE0LjU3MyAxNC41NzMiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDE0LjU3MyAxNC41NzM7IiB4bWw6c3BhY2U9InByZXNlcnZlIiB3aWR0aD0iMTZweCIgaGVpZ2h0PSIxNnB4Ij4KPGc+Cgk8Zz4KCQk8cGF0aCBkPSJNNy4yODYsMTQuNTczYy0xLjczNiwwLTMuMzY4LTAuNjc2LTQuNTk2LTEuOTAzYy0xLjIyNy0xLjIyOC0xLjkwNC0yLjg2LTEuOTA0LTQuNTk3ICAgIHMwLjY3Ny0zLjM2OSwxLjkwNC00LjU5N2MwLjM5MS0wLjM5MSwxLjAyMy0wLjM5MSwxLjQxNCwwczAuMzkxLDEuMDIzLDAsMS40MTRjLTAuODUsMC44NTEtMS4zMTgsMS45ODEtMS4zMTgsMy4xODMgICAgczAuNDY4LDIuMzMzLDEuMzE4LDMuMTgzczEuOTc5LDEuMzE3LDMuMTgyLDEuMzE3czIuMzMyLTAuNDY4LDMuMTgyLTEuMzE3YzAuODUxLTAuODUsMS4zMTgtMS45OCwxLjMxOC0zLjE4MyAgICBTMTEuMzE4LDUuNzQsMTAuNDY5LDQuODljLTAuMzkxLTAuMzkxLTAuMzkxLTEuMDIzLDAtMS40MTRzMS4wMjMtMC4zOTEsMS40MTQsMGMxLjIyNywxLjIyOSwxLjkwNCwyLjg2MSwxLjkwNCw0LjU5NyAgICBzLTAuNjc3LDMuMzY5LTEuOTA0LDQuNTk3QzEwLjY1NSwxMy44OTcsOS4wMjMsMTQuNTczLDcuMjg2LDE0LjU3M3oiIGZpbGw9IiNEODAwMjciLz4KCTwvZz4KCTxnPgoJCTxwYXRoIGQ9Ik03LjI4Niw3Yy0wLjU1MywwLTEtMC40NDgtMS0xVjFjMC0wLjU1MiwwLjQ0Ny0xLDEtMXMxLDAuNDQ4LDEsMXY1QzguMjg2LDYuNTUyLDcuODQsNyw3LjI4Niw3eiIgZmlsbD0iI0Q4MDAyNyIvPgoJPC9nPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+CjxnPgo8L2c+Cjwvc3ZnPgo=" />
                </a>
            </c:if>
        </div>