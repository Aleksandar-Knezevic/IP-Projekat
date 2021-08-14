var visibility = 'visible';

function init() {
    let items = document.getElementsByClassName('menu-li');
    for (let item of items) {
        item.addEventListener('mouseenter', event => changeBackground('#1a759f', 'enter', event));
        item.addEventListener('mouseleave', event => changeBackground('#52b69a', 'exit', event));
    }
    dohvatiDolaske();
    dohvatiOdlaske();
    setInterval(dohvatiDolaske, 360000);
    setInterval(dohvatiOdlaske, 360000);


}
function changeBackground(color, event, element) {
    element.target.style.background = color;
    if (event === 'enter')
        element.target.style.cursor = 'pointer'
    if (event === 'exit')
        element.target.style.cursor = 'unset'
}

function showLogin() {
    let seen = document.getElementById('login-form').style.visibility;
    if (seen === 'visible')
        document.getElementById('login-form').style.visibility = 'hidden';
    else
        document.getElementById('login-form').style.visibility = visibility;

}

async function dohvatiDolaske()
{
    var date = document.getElementById("dolasci-date").innerText;
    var dolasci = await fetch("http://localhost:8080/JSPKlijent/LetoviServlet?type=dolasci&date="+date);
    var data = await dolasci.json();
    var dolasciList = document.getElementById('dolasci-list');
    dolasciList.innerHTML="";
    data.forEach(element =>{
        var li = document.createElement('li');
        var div = document.createElement('div');
        div.className='flight-list-item';
        div.innerHTML= "Od: " + element.polazniGrad.nazivGrada + ", " + element.polaznaDrzava.nazivDrzave + "<br>" +
        "Do: " + element.odredisniGrad.nazivGrada + ", " + element.odredisnaDrzava.nazivDrzave + "<br>" + 
        "Vrijeme polaska: " + element.vrijemePolaska + "<br>" + 
        "Vrijeme dolaska: " + element.vrijemeDolaska + "<br>" + 
        "Status: " + element.status;
        li.appendChild(div);
        dolasciList.appendChild(li);
    });

}

async function dohvatiOdlaske()
{
    var date = document.getElementById("odlasci-date").innerText;
    var dolasci = await fetch("http://localhost:8080/JSPKlijent/LetoviServlet?type=odlasci&date="+date);
    var data = await dolasci.json();
    var dolasciList = document.getElementById('odlasci-list');
    dolasciList.innerHTML="";
    data.forEach(element =>{
        var li = document.createElement('li');
        var div = document.createElement('div');
        div.className='flight-list-item';
        div.innerHTML= "Od: " + element.polazniGrad.nazivGrada + ", " + element.polaznaDrzava.nazivDrzave + "<br>" +
        "Do: " + element.odredisniGrad.nazivGrada + ", " + element.odredisnaDrzava.nazivDrzave + "<br>" + 
        "Vrijeme polaska: " + element.vrijemePolaska + "<br>" + 
        "Vrijeme dolaska: " + element.vrijemeDolaska + "<br>" + 
        "Status: " + element.status;
        li.appendChild(div);
        dolasciList.appendChild(li);
    });
}

function leftDolazak()
{
    var dateString = document.getElementById('dolasci-date').innerText;
    var date = new Date(dateString);
    date.setDate(date.getDate() - 1);
    document.getElementById('dolasci-date').innerText= date.toISOString().substring(0,10);
    dohvatiDolaske();
}

function rightDolazak()
{
    var dateString = document.getElementById('dolasci-date').innerText;
    var date = new Date(dateString);
    date.setDate(date.getDate() + 1);
    document.getElementById('dolasci-date').innerText= date.toISOString().substring(0,10);
    dohvatiDolaske();
}

function leftOdlazak()
{
    var dateString = document.getElementById('odlasci-date').innerText;
    var date = new Date(dateString);
    date.setDate(date.getDate() - 1);
    document.getElementById('odlasci-date').innerText= date.toISOString().substring(0,10);
    dohvatiOdlaske();
}

function rightOdlazak()
{
    var dateString = document.getElementById('odlasci-date').innerText;
    var date = new Date(dateString);
    date.setDate(date.getDate() + 1);
    document.getElementById('odlasci-date').innerText= date.toISOString().substring(0,10);
    dohvatiOdlaske();
}