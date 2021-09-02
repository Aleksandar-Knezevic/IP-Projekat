var visibility = 'visible';


function init()
{

    dohvatiLetove();
    setInterval(dohvatiLetove, 60000)
}


async function dohvatiLetove()
{
    var date = document.getElementById("dolasci-date").innerText;

    var putnickiResponse = await fetch("http://localhost:8080/JSPKlijent/PutnickiLetovi?type=dolasci&date="+date);
    var putnickiLetovi = await putnickiResponse.json();
    putnickiLetovi.forEach(e => e.tip="Putnicki");

    var teretniResponse = await fetch("http://localhost:8080/JSPKlijent/TeretniLetovi?type=dolasci&date="+date);
    var teretniLetovi = await teretniResponse.json();
    teretniLetovi.forEach(e => e.tip="Teretni");
    const sviLetovi = [];

    putnickiLetovi.forEach(e => sviLetovi.push(e));
    teretniLetovi.forEach(e => sviLetovi.push(e));

    
    var table = document.getElementById("dolasci-table");

    while(table.rows.length > 1)
        table.deleteRow(1);


    sviLetovi.sort((a,b) => b.vrijemeDolaska-a.vrijemeDolaska);
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
    var dateString = document.getElementById('dolasci-date').innerText;
    var date = new Date(dateString);
    date.setDate(date.getDate() - 1);
    document.getElementById('dolasci-date').innerText= date.toISOString().substring(0,10);
    dohvatiLetove();
}

function right()
{
    var dateString = document.getElementById('dolasci-date').innerText;
    var date = new Date(dateString);
    date.setDate(date.getDate() + 1);
    document.getElementById('dolasci-date').innerText= date.toISOString().substring(0,10);
    dohvatiLetove();
}

// function changeBackground(color, event, element) {
//     element.target.style.background = color;
//     if (event === 'enter')
//         element.target.style.cursor = 'pointer'
//     if (event === 'exit')
//         element.target.style.cursor = 'unset'
// }