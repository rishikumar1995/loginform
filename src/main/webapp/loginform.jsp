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
            max-width: 600px;
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
        <!-- Add more rows for additional user details -->
    </table>
</div>
</body>
</html>
