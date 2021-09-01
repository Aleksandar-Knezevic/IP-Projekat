var selectedFlight="";
var visibility = 'visible';

async function init()
{

    await popuniDrzave();
    document.getElementById('polaznaDrzava').selectedIndex="0";
    document.getElementById('odredisnaDrzava').selectedIndex="0";
    // document.getElementById('polaznaDrzava').dispatchEvent(new Event('change'));
    // document.getElementById('odredisnaDrzava').dispatchEvent(new Event('change'));
    var tipNaloga = readCookie('accountType');
    let baseUrl = 'http://localhost:8080/JSPKlijent/';
    if(tipNaloga==='Putnicki')
        baseUrl+='PutnickiLetovi';
    else if (tipNaloga==='Teretni')
        baseUrl+='TeretniLetovi';
    var letoviResult = await fetch(baseUrl);
    var letoviData = await letoviResult.json();
    popuniLetovima(letoviData);
}

function selectLet(div)
{
    var letovi = document.getElementById('letovi');
    selectedFlight=div.id;
    for(var item of letovi.children)
        item.style.backgroundColor = '';
    div.style.backgroundColor = 'rgba(0,0,0,0.9)';
}





async function applyFilter()
{
    var baseUrl;
    var accountType = readCookie('accountType');
    if(accountType==='Putnicki')
        baseUrl="http://localhost:8080/JSPKlijent/PutnickiLetovi?";
    else if(accountType==='Teretni')
        baseUrl='http://localhost:8080/JSPKlijent/TeretniLetovi?';


    var date = document.getElementById('datum').value;
    if(date !== "")
        baseUrl+="date="+date+"&";

    var polazniGradIndex = document.getElementById('polazniGrad').selectedIndex;
    var odredisniGradIndex = document.getElementById('odredisniGrad').selectedIndex;
    let polazniGrad="";
    let odredisniGrad="";

    if(polazniGradIndex>-1)
        polazniGrad = document.getElementById('polazniGrad').options[polazniGradIndex].text;
    
    if(odredisniGradIndex>-1)
    odredisniGrad = document.getElementById('odredisniGrad').options[odredisniGradIndex].text;

    if(polazniGrad !== 'Banja Luka' && odredisniGrad !== 'Banja Luka' && (polazniGrad!=="" || odredisniGrad!==""))
    {
        alert('Polazni ili odredisni grad moraju biti Banja Luka');
        return;
    }
        
    if(polazniGrad==='Banja Luka' && odredisniGrad==='Banja Luka')
    {
        alert('Ne mogu i polazni i odredisni grad biti Banja Luka');
        return;
    }
        

    if(polazniGrad==='Banja Luka')
        baseUrl+="type=odlasci&";
    if(odredisniGrad==='Banja Luka')
        baseUrl+="type=dolasci&"
    if(polazniGrad!=='Banja Luka' && polazniGrad!=="")
        baseUrl+="source="+polazniGrad+"&";
    if(odredisniGrad!=='Banja Luka' && odredisniGrad!=="")
        baseUrl+="destination="+odredisniGrad+"&";

    
    var letoviResult = await fetch(baseUrl);
    var letoviData = await letoviResult.json();
    popuniLetovima(letoviData);
}

async function clearFilter()
{
    document.getElementById('datum').value='';
    document.getElementById('polazniGrad').innerHTML="";
    document.getElementById('odredisniGrad').innerHTML="";
    document.getElementById('polaznaDrzava').selectedIndex=0;
    document.getElementById('odredisnaDrzava').selectedIndex=0;
    var tipNaloga = readCookie('accountType');
    let baseUrl = 'http://localhost:8080/JSPKlijent/';
    if(tipNaloga==='Putnicki')
        baseUrl+='PutnickiLetovi';
    else if (tipNaloga==='Teretni')
        baseUrl+='TeretniLetovi';
    var letoviResult = await fetch(baseUrl);
    var letoviData = await letoviResult.json();
    popuniLetovima(letoviData);
}

function obradiRezervaciju()
{
    if(selectedFlight==="")
    {
        alert('Izaberite let');
        return false;
    }
    var accountType = readCookie('accountType');
    if(accountType==='Putnicki')
    {
        var brojMjesta = document.getElementById('brojMjesta').value;
        var brojMjestaNum = parseInt(document.getElementById('brojMjesta').value);
        //var message = document.getElementById('errorMessage');
        var freeSpace = parseInt(document.getElementById('free-space-'+selectedFlight).innerText);
        if(brojMjesta==='' || brojMjestaNum>freeSpace)
        {
            alert("Greska. Provjerite broj mjesta");
            // message.innerText="Greska. Provjerite broj mjesta";
            return false;
        }
        
    }  
    document.getElementById('reservationId').value=selectedFlight;
    alert('Uspjesna rezervacija');
    return true;

    
}

function showLogin() {
    let seen = document.getElementById('login-form').style.visibility;
    if (seen === 'visible')
        document.getElementById('login-form').style.visibility = 'hidden';
    else
        document.getElementById('login-form').style.visibility = visibility;

}

async function popuniDrzave()
{
    var drzaveResult = await fetch("http://localhost:8080/JSPKlijent/DrzaveServlet");
    var drzave = await drzaveResult.json();
    var polazneSelect = document.getElementById('polaznaDrzava');
    var odredisneSelect = document.getElementById('odredisnaDrzava');
    var blankOption1 = document.createElement('option');
        blankOption1.value="-1";
    var blankOption2 = document.createElement('option');
        blankOption2.value="-1";
    polazneSelect.appendChild(blankOption1);
    odredisneSelect.appendChild(blankOption2);
    drzave.forEach(element => {
        var option = document.createElement('option');
        var option2 = document.createElement('option');
        option2.value=element.id;
        option2.innerText=element.nazivDrzave;
        option.value = element.id;
        option.innerText=element.nazivDrzave;
        odredisneSelect.appendChild(option);
        polazneSelect.appendChild(option2);

    });
}

async function fillWithCities(selection, id)
{
    if(selection.value==='-1')
    {
        var gradovi = document.getElementById(id);
        gradovi.innerHTML="";
        var blankOption1 = document.createElement('option');
        gradovi.appendChild(blankOption1);

    }
    else
    {
        var gradovi = document.getElementById(id);
        var gradoviResult = await fetch("http://localhost:8080/JSPKlijent/GradoviServlet?drzava_id="+selection.value);
        var gradoviData = await gradoviResult.json();
        gradovi.innerHTML="";
        gradoviData.forEach(element => {
         var option = document.createElement('option');
         option.value=element.id;
         option.innerText = element.nazivGrada;
         gradovi.appendChild(option);
     });
    }
    
}


function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}

function popuniLetovima(data)
{
    data = data.filter((el) => el.status==='Ceka');
    var letovi = document.getElementById('letovi');
    letovi.innerHTML="";
    data.forEach(element =>{
        var parentDiv = document.createElement('div');
            parentDiv.className="let-div";
            parentDiv.onclick=() => selectLet(parentDiv);
            parentDiv.id=element.id;
        var od = "<div><b>Od:  &nbsp;&nbsp;</b>" + element.polaznaDrzava.nazivDrzave+", " + element.polazniGrad.nazivGrada+"</div>";
        var doLokacija = "<div><b>Do: &nbsp;&nbsp;</b>" + element.odredisnaDrzava.nazivDrzave+", " + element.odredisniGrad.nazivGrada+"</div>";
        var datum = "<div><b>Datum leta: &nbsp;&nbsp;</b>" + element.datumLeta + "</div>";
        var status = "<div><b>Status: &nbsp;&nbsp;&nbsp;</b>" + element.status + "</div>";
        var vrijemePolaska = "<div><b>Vrijeme polaska: &nbsp;&nbsp;</b>" + element.vrijemePolaska + "</div>";
        var vrijemeDolaska = "<div><b>Vrijeme dolaska: &nbsp;&nbsp;</b>" + element.vrijemeDolaska + "</div>";
        var opis="";
        if(readCookie('accountType')==="Putnicki")
            opis = "<div><b>Slobodnih mjesta: &nbsp;&nbsp;</b><span id=\"free-space-" +element.id+"\">"+ element.brojSlobodnihMjesta + "</span></div>";
        
        parentDiv.innerHTML = od + doLokacija + datum + status + vrijemePolaska + vrijemeDolaska + opis;
        letovi.appendChild(parentDiv);
        letovi.appendChild(document.createElement('hr'));
    });

}

function changeBackground(color, event, element) {
    element.target.style.background = color;
    if (event === 'enter')
        element.target.style.cursor = 'pointer'
    if (event === 'exit')
        element.target.style.cursor = 'unset'
}