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
    <link rel="stylesheet" href="styles/rezervacija-style.css">
    <script src="scripts/rezervacija-script.js"></script>
</head>
<body class="body" onload="init()">
    <div class="header">
        <div class="login" style="margin-right: auto; visibility: hidden; margin-left: 0;"></div>
        <span class="title" onclick="window.location.href='/JSPKlijent'">ETFBL_AERO</span>
       <%if(session.getAttribute("user")==null){ %>
        <div class="login" onclick="showLogin()">Login</div>
        <div class="login-form" id="login-form">
            <form action="LoginServlet" method="post">
                <label for="username">Username</label><br>
                <input type="text" name="username" id="username"><br>
                <label for="loginPassword">Password</label><br>
                <input type="password" name="loginPassword" id="loginPassword"><br>
                <button type="submit">Login</button>
                <a href="RegisterServlet">Register</a>
            </form>
        </div>
        <%} else
        {
        	 KorisnikDTO korisnik = (KorisnikDTO) session.getAttribute("user");%>
     
        <div class="login-2">
            <span><%=korisnik.getIme()%></span>
            <span><%=korisnik.getPrezime()%></span><br>
            <a href="LogoutServlet">Logout</a>
        </div>
        
        <%} %>
    </div>
    
       <ul class="menu-list" >
            <li class="menu-li"  onclick="window.location.href='SviDolasciServlet'">
                 <span>Svi dolasci</span>
             </li>
            <li class="menu-li"  onclick="window.location.href='SviOdlasciServlet'">
                <span>Svi odlasci</span>
            </li>
            <%if(session.getAttribute("user")!=null){ %>
            <li class="menu-li" onclick="window.location.href='RezervacijaPageServlet'">
                <span>Rezervacija leta</span>
            </li>
            <li class="menu-li" onclick="window.location.href='MojeRezervacijePageServlet'">
                <span>Sve rezervacije</span>
            </li>
            <%} %>
        </ul>
    <div class="content">
       <div style="margin-top: 6px;">Rezervisite let</div>
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
        	<input type="number" name="reservationId" id="reservationId" hidden><br>
        	<div>
        	
            <input type="submit" value="Rezervisi">
            
        	</div>
           </form>	

        </div>
        
        <div style="color: red;" id="errorMessage"></div>
        
    </div>
    <div class="footer"> 
        <div class="mapa">Mapa</div>
        <div class="copyright">ETFBL-2021</div>
        <div>Kontakt</div>
    </div>
</body>
</html>