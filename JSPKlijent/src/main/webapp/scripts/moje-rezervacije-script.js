var selectedFlight="";
var visibility = 'visible';

async function init()
{


    var tipNaloga = readCookie('accountType');
    let baseUrl = 'http://localhost:8080/JSPKlijent/MojeRezervacijeData';
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
    var letovi = document.getElementById('letovi');
    letovi.innerHTML="";
    data.forEach(element =>{
        var parentDiv = document.createElement('div');
            parentDiv.className="let-div";
            // parentDiv.onclick=() => selectLet(parentDiv);
            parentDiv.id=element.let.id;
        var od = "<div><b>Od:  &nbsp;&nbsp;</b>" + element.let.polaznaDrzava.nazivDrzave+", " + element.let.polazniGrad.nazivGrada+"</div>";
        var doLokacija = "<div><b>Do: &nbsp;&nbsp;</b>" + element.let.odredisnaDrzava.nazivDrzave+", " + element.let.odredisniGrad.nazivGrada+"</div>";
        var datum = "<div><b>Datum leta: &nbsp;&nbsp;</b>" + element.let.datumLeta + "</div>";
        var statusLeta = "<div><b>Status leta : &nbsp;&nbsp;&nbsp;</b>" + element.let.status + "</div>";
        var statusRezervacije = "<div><b>Status rezervacije : &nbsp;&nbsp;&nbsp;</b>" + element.statusRezervacije + "</div>";
        var vrijemePolaska = "<div><b>Vrijeme polaska: &nbsp;&nbsp;</b>" + element.let.vrijemePolaska + "</div>";
        var vrijemeDolaska = "<div><b>Vrijeme dolaska: &nbsp;&nbsp;</b>" + element.let.vrijemeDolaska + "</div>";
        var razlog = "";
        var dugme="";
        if(element.razlogPonistavanja!="")
            razlog = "<div><b>Razlog ponistavanja: &nbsp;&nbsp;</b>" + element.razlogPonistavanja + "</div>";
        if(element.statusRezervacije === 'Nova')
        {
            dugme=document.createElement('button');
            dugme.innerText='Otkazi';
            dugme.className="button-otkazi";
            dugme.onclick=() => otkaziRezervaciju(element.let.id);
        }
        
        parentDiv.innerHTML = od + doLokacija + datum + statusLeta + statusRezervacije + vrijemePolaska + vrijemeDolaska+razlog;
        if(dugme != "")
            parentDiv.appendChild(dugme)

        letovi.appendChild(parentDiv);
        letovi.appendChild(document.createElement('hr'));
    });

}

async function otkaziRezervaciju(id)
{
    await fetch("http://localhost:8080/JSPKlijent/OtkaziRezervacijuServlet?id="+id);
    location.reload();
}

function changeBackground(color, event, element) {
    element.target.style.background = color;
    if (event === 'enter')
        element.target.style.cursor = 'pointer'
    if (event === 'exit')
        element.target.style.cursor = 'unset'
}