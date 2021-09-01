<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="net.etfbl.ip.jsp.dto.KorisnikDTO"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- https://coolors.co/d9ed92-b5e48c-99d98c-76c893-52b69a-34a0a4-168aad-1a759f-1e6091-184e77 -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moje rezervacije</title>
    <link rel="stylesheet" href="styles/moje-rezervacije-style.css">
    <script src="scripts/moje-rezervacije-script.js"></script>
    <link rel="stylesheet" href="styles/header-style.css">
    <link rel="stylesheet" href="styles/footer-style.css">
    <script src="scripts/header-script.js"></script>
    <script src="scripts/footer-script.js"></script>
</head>
<body class="body" onload="init()">
    <%@include file="header.jsp" %>
       
    <div class="content">
       <div style="margin-top: 6px; color:aliceblue;">Moje rezervacije</div>
        
        <div class="letovi" id="letovi">
            
        </div>
      
        
        
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>