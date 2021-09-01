<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="net.etfbl.ip.jsp.dto.KorisnikDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registracija</title>
    <link rel="stylesheet" href="styles/register-style.css">
    <script src="scripts/register-script.js"></script>
        <link rel="stylesheet" href="styles/header-style.css">
    <link rel="stylesheet" href="styles/footer-style.css">
    <script src="scripts/header-script.js"></script>
    <script src="scripts/footer-script.js"></script>
</head>



<body class="body" onload="init()">
    <%@include file="header.jsp" %>
    <div class="form-div-wrapper">
    
    <div class="form-div">
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
            <br><button id="submit" style="margin-bottom:5px">Submit</button>
        </div>
        <div>
        	<p style="color:red;"><%=session.getAttribute("errorMsg")==null?"":session.getAttribute("errorMsg") %></p>
        </div>

    </form>
    </div>
    </div>
    <%@include file="footer.jsp" %>
</body>

</html>