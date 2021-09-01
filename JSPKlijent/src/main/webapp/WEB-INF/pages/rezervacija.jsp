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
    <title>Rezervacije</title>
    <link rel="stylesheet" href="styles/rezervacija-style.css">
    <script src="scripts/rezervacija-script.js"></script>
            <link rel="stylesheet" href="styles/header-style.css">
    <link rel="stylesheet" href="styles/footer-style.css">
    <script src="scripts/header-script.js"></script>
    <script src="scripts/footer-script.js"></script>
</head>
<body class="body" onload="init()">
    <%@include file="header.jsp" %>
    <div class="content">
       <div style="margin-top: 6px; color:aliceblue;">Rezervisite let</div>
        <div class="let-filter">
            <div>
                <span>Datum leta:</span>
                <input type="date" name="datum" id="datum">
            </div>
            <div>
                <span>Od: </span>
                <select name="polaznaDrzava" id="polaznaDrzava" onchange="fillWithCities(this, 'polazniGrad')">
                </select>
                <select name="polazniGrad" id="polazniGrad">
                </select>
            </div>
            <div>
                <span>Do: </span>
                <select name="odredisnaDrzava" id="odredisnaDrzava" onchange="fillWithCities(this, 'odredisniGrad')">
                </select>
                <select name="polazniGrad" id="odredisniGrad">
                </select>
            </div>
            <div>
                <button onclick="applyFilter()">Primijeni filter</button>
                <button onclick="clearFilter()">Ocisti filter</button>
            </div>
            
        </div>
        <div class="letovi" id="letovi">
            
        </div>
        <div class="input">
        <form method="post" name="forma" action="RezervisiServlet" id="forma" onsubmit="return obradiRezervaciju()" class="form-class" enctype="multipart/form-data">
        <%
        	 KorisnikDTO korisnik = (KorisnikDTO) session.getAttribute("user");
        	
        	 if(korisnik.getTipNaloga().equals("Putnicki")){%>
        		 <input type="number" name="brojMjesta" id="brojMjesta" placeholder="Broj mjesta" required><br>
        <%} else
        {%>
        
        		<textarea name="opisTereta" id="opisTereta" cols="30" rows="5" placeholder="Opis tereta" required></textarea><br>
        		<input type="file" name="specifikacijaRobe" id="specifikacijaRobe" required>
        
            	
        	<% }	%>
        	<input type="number" name="reservationId" id="reservationId" hidden>
        	<div>
        	
            <input type="submit" value="Rezervisi" style="margin-top:-10px">
            
        	</div>
           </form>	

        </div>
        
    </div>
    <%@include file="footer.jsp" %>
</body>
</html>