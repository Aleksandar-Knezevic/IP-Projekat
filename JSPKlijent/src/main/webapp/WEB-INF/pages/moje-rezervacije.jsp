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
    <link rel="stylesheet" href="styles/moje-rezervacije-style.css">
    <script src="scripts/moje-rezervacije-script.js"></script>
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
       <div style="margin-top: 6px;">Moje rezervacije</div>
        
        <div class="letovi" id="letovi">
            
        </div>
      
        
        
    </div>
    <div class="footer"> 
        <div>
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2824.49364263445!2d17.30222805022368!3d44.93363189951153!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475dfedd7be12b43%3A0xd93ee8208177c576!2sInternational%20airport%20Banja%20Luka!5e0!3m2!1ssr!2sba!4v1628939088355!5m2!1ssr!2sba" width="200" height="200" style="border:0; margin: 30px;" allowfullscreen="" loading="lazy"></iframe>
        </div>
        <div style="font-size:1.5rem">
            ETF - Sva prava zadrzana
        </div>
        <div class="contact-footer">
            <span>TEL:065/276-989</span>
            <span>FAX:08697735</span>
            <div>
                <form action="PosaljiPoruku" method="POST" class="form-contact">
                    <input type="email" name="email" id="email" placeholder="email">
                    <input type="text" name="naslov" id="naslov" placeholder="naslov">
                    <textarea name="poruka" id="poruka" cols="30" rows="10" placeholder="Tekst poruke"></textarea>
                    <button type="submit" class="posalji-dugme">Posalji</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>