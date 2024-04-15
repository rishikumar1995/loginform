<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
        }
        .container {
            width: 100%;
            margin: 0 auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid;
        }
        th {
            background-color: #f2f2f2;
        }
        .custom-button {
            margin-top: -12px;
            float: right;
        }
        .form input{
            padding-top: 1px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>User Details</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Mobile No</th>
        </tr>
        <tr>
            <td><%= session.getAttribute("UserName")%></td>
            <td><%= session.getAttribute("UserEmail")%></td>
            <td><%= session.getAttribute("UserMobNo")%></td>
        </tr>
    </table>
</div>
<form action="excel" method="get">
    <input type="submit" class="excel" value="Export to Excel">
</form>
</body>
</html>
