<%@page import="java.text.SimpleDateFormat"%>
<%@ page import ="net.etfbl.ip.jsp.dto.KorisnikDTO"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
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