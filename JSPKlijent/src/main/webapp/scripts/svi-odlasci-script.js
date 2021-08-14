var visibility = 'visible';
function showLogin() {
    let seen = document.getElementById('login-form').style.visibility;
    if (seen === 'visible')
        document.getElementById('login-form').style.visibility = 'hidden';
    else
        document.getElementById('login-form').style.visibility = visibility;

}

function init()
{
	let items = document.getElementsByClassName('menu-li');
    for (let item of items) {
        item.addEventListener('mouseenter', event => changeBackground('#1a759f', 'enter', event));
        item.addEventListener('mouseleave', event => changeBackground('#52b69a', 'exit', event));
    }
    dohvatiLetove();
    setInterval(dohvatiLetove, 360000)
}


async function dohvatiLetove()
{
    var date = document.getElementById("odlasci-date").innerText;

    var putnickiResponse = await fetch("http://localhost:8080/JSPKlijent/PutnickiLetovi?type=odlasci&date="+date);
    var putnickiLetovi = await putnickiResponse.json();
    putnickiLetovi.forEach(e => e.tip="Putnicki");

    var teretniResponse = await fetch("http://localhost:8080/JSPKlijent/TeretniLetovi?type=odlasci&date="+date);
    var teretniLetovi = await teretniResponse.json();
    teretniLetovi.forEach(e => e.tip="Teretni");
    const sviLetovi = [];

    putnickiLetovi.forEach(e => sviLetovi.push(e));
    teretniLetovi.forEach(e => sviLetovi.push(e));

    
    var table = document.getElementById("odlasci-table");
    // for(var i = 1; i<table.rows.length;i++)
    //     table.deleteRow(i);
    while(table.rows.length > 1)
        table.deleteRow(1);
    console.log(table.rows);

    sviLetovi.sort((a,b) => b.vrijemePolaska-a.vrijemePolaska);
    sviLetovi.forEach(e =>{
        var tr = document.createElement("tr");
        var polaznaLokacija = document.createElement("td");
            polaznaLokacija.innerText = e.polaznaDrzava.nazivDrzave+", "+e.polazniGrad.nazivGrada;
        var odrediste = document.createElement("td");
            odrediste.innerText = e.odredisnaDrzava.nazivDrzave+", "+e.odredisniGrad.nazivGrada;
        var datumLeta = document.createElement("td");
            datumLeta.innerText=e.datumLeta;
        var vrijemePolaska = document.createElement("td");
            vrijemePolaska.innerText = e.vrijemePolaska;
        var vrijemeDolaska = document.createElement("td");
            vrijemeDolaska.innerText = e.vrijemeDolaska;
        var status = document.createElement("td");
            status.innerText = e.status;
        var vrsta = document.createElement("td");
            vrsta.innerText=e.tip;
        
        tr.appendChild(polaznaLokacija);
        tr.appendChild(odrediste);
        tr.appendChild(datumLeta);
        tr.appendChild(vrijemePolaska);
        tr.appendChild(vrijemeDolaska);
        tr.appendChild(status);
        tr.appendChild(vrsta);
        table.appendChild(tr);

    });

}

function left()
{
    var dateString = document.getElementById('odlasci-date').innerText;
    var date = new Date(dateString);
    date.setDate(date.getDate() - 1);
    document.getElementById('odlasci-date').innerText= date.toISOString().substring(0,10);
    dohvatiLetove();
}

function right()
{
    var dateString = document.getElementById('odlasci-date').innerText;
    var date = new Date(dateString);
    date.setDate(date.getDate() + 1);
    document.getElementById('odlasci-date').innerText= date.toISOString().substring(0,10);
    dohvatiLetove();
}

function changeBackground(color, event, element) {
    element.target.style.background = color;
    if (event === 'enter')
        element.target.style.cursor = 'pointer'
    if (event === 'exit')
        element.target.style.cursor = 'unset'
}