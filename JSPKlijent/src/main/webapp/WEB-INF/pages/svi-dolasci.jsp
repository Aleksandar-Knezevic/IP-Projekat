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
    <title>Svi dolasci</title>
    <link rel="stylesheet" href="styles/svi-dolasci-style.css">
    <script src="scripts/svi-dolasci-script.js"></script>
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
    	<div>Svi dolasci</div>
        <div><span class="arrow" onclick="left()"><<   </span><span id="dolasci-date"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %></span><span class="arrow" onclick="right()">   >></span></div>
        <table style="width: 100%;" id="dolasci-table">
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
    <div class="footer">
        <div class="mapa">Mapa</div>
        <div class="copyright">ETFBL-2021</div>
        <div>Kontakt</div>
    </div>    
</body>
</html>