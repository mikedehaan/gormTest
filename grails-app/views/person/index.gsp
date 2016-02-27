<%--
  Created by IntelliJ IDEA.
  User: mike
  Date: 2/26/2016
  Time: 9:17 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <g:if test="${resultMap.gormObjectId}">
        <p style="color: rgb(0, 128, 0)">Found via GORM by ObjectId</p>
    </g:if>
    <g:else>
        <p style="color: rgb(128, 0, 0)">Not found via GORM by ObjectId</p>
    </g:else>

    <g:if test="${resultMap.collectionString}">
        <p style="color: rgb(0, 128, 0)">Found via MongoCollection by String</p>
    </g:if>
    <g:else>
        <p style="color: rgb(128, 0, 0)">Not found via MongoCollection by String</p>
    </g:else>

    <g:if test="${resultMap.collectionObjectId}">
        <p style="color: rgb(0, 128, 0)">Found via MongoCollection by ObjectId</p>
    </g:if>
    <g:else>
        <p style="color: rgb(128, 0, 0)">Not found via MongoCollection by ObjectId</p>
    </g:else>
</body>
</html>