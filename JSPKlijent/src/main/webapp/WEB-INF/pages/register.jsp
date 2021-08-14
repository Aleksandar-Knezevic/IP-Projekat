<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="net.etfbl.ip.jsp.dto.KorisnikDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="styles/register-style.css">
    <script src="scripts/register-script.js"></script>
</head>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="register-style.css">
    <script src="register-script.js"></script>
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
    <form action="RegisterServlet" class="form-container" method="post">
        <div>
            <label for="ime" class="form-label">Ime</label><br>
            <input type="text" name="ime" id="ime" required>
        </div>
        <div>
            <label for="prezime" class="form-label">Prezime</label><br>
            <input type="text" name="prezime" id="prezime" required>
        </div>
        <div>
            <label for="korisnickoIme" class="form-label">Korisnicko ime</label><br>
            <input type="text" name="korisnickoIme" id="korisnickoIme" required>
        </div>
        <div>
            <label for="adresa" class="form-label">Adresa</label><br>
            <input type="text" name="adresa" id="adresa" required>
        </div>
        <div>
            <label for="email" class="form-label">Email</label><br>
            <input type="email" name="email" id="email" required>
        </div>
        <div>
            <label for="password" class="form-label">Lozinka</label><br>
            <input type="password" name="password" id="password" required onkeyup="check(document.getElementById('confirmPassword').value)">
        </div>
        <div>
            <label for="confirmPassword" class="form-label">Potvrdite lozinku</label><br>
            <input type="password" name="confirmPassword" id="confirmPassword" required onkeyup="check(this)"><br>
            <span id="msg"></span>
        </div>
        <div>
            <label for="drzava" class="form-label">Drzava</label><br>
            <select name="drzava" id="drzava" style="width: 180px;">
            </select>
        </div>
        <div>
            <label for="nalog" class="form-label">Tip naloga</label><br>
            <input type="radio" name="nalog" id="putnicki" value="Putnicki">
            <label for="putnicki" class="form-label">Putnicki</label>
            <input type="radio" name="nalog" id="teretni" value="Teretni">
            <label for="teretni" class="form-label">Teretni</label>
        </div>
        <div>
            <br><button id="submit">Submit</button>
        </div>

    </form>
    <div class="footer">
        <div class="mapa">Mapa</div>
        <div class="copyright">ETFBL-2021</div>
        <div>Kontakt</div>
    </div>
</body>

</html>