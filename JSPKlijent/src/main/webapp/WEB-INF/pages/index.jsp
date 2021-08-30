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
    <title>Document</title>
    <link rel="stylesheet" href="styles/index-style.css">
    <link rel="stylesheet" href="styles/header-style.css">
    <link rel="stylesheet" href="styles/footer-style.css">
    <script src="scripts/index-script.js"></script>
    <script src="scripts/header-script.js"></script>
    <script src="scripts/footer-script.js"></script>
</head>
<body class="body" onload="init()">
  
    
    <%@include file="header.jsp" %>
        
    <div class="content">
        <div class="dolasci">
        	<div><span class="arrow" onclick="leftDolazak()"><<   </span><span id="dolasci-date"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %></span><span class="arrow" onclick="rightDolazak()">   >></span></div>
            <ul class="dolasci-list" id="dolasci-list">
                
            </ul>
        </div>
        <div class="odlasci">
        <div><span class="arrow" onclick="leftOdlazak()"><<   </span><span id="odlasci-date"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %></span><span class="arrow" onclick="rightOdlazak()">   >></span></div>
            <ul class="odlasci-list" id="odlasci-list">
                
            </ul>
        </div>
    </div>
    <%@include file="footer.jsp" %>
    
</body>
</html>