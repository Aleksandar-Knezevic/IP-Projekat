<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<%@ page import ="net.etfbl.ip.jsp.dto.KorisnikDTO"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Svi odlasci</title>
    <link rel="stylesheet" href="styles/svi-odlasci-style.css">
    <script src="scripts/svi-odlasci-script.js"></script>
                    <link rel="stylesheet" href="styles/header-style.css">
    <link rel="stylesheet" href="styles/footer-style.css">
    <script src="scripts/header-script.js"></script>
    <script src="scripts/footer-script.js"></script>
</head>
<body class="body" onload="init()">
    <%@include file="header.jsp" %>
    <div class="content">
    	<div>Svi odlasci</div>
        <div><span class="arrow" onclick="left()"><<   </span><span id="odlasci-date"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %></span><span class="arrow" onclick="right()">   >></span></div>
        <div class="table-wrapper">
        <table style="width: 100%;" id="odlasci-table">
        <col width="14.2%"/>
        <col width="14.2%"/>
        <col width="14.2%"/>
        <col width="14.2%"/>
        <col width="14.2%"/>
        <col width="14.2%"/>
        <col width="14.2%"/>
            <tr>
            <th>Polazna lokacija</th>
            <th>Odrediste</th>
            <th>Datum leta</th>
            <th>Vrijeme polaska</th>
            <th>Vrijeme dolaska</th>
            <th>Status</th>
            <th>Vrsta leta</th>
            </tr>
        </table>
        </div>
        
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>