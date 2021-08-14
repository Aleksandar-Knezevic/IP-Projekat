var visibility = 'visible';
function showLogin() {
    let seen = document.getElementById('login-form').style.visibility;
    if (seen === 'visible')
        document.getElementById('login-form').style.visibility = 'hidden';
    else
        document.getElementById('login-form').style.visibility = visibility;

}

async function init()
{

	let items = document.getElementsByClassName('menu-li');
    for (let item of items) {
        item.addEventListener('mouseenter', event => changeBackground('#1a759f', 'enter', event));
        item.addEventListener('mouseleave', event => changeBackground('#52b69a', 'exit', event));
    }
    var result = await fetch('https://restcountries.eu/rest/v2/region/europe');
    var data = await result.json();
    var selectionBox = document.getElementById('drzava');
    data.forEach(element => {
        var option = document.createElement('option');
        option.value=element.name;
        option.innerHTML=element.name;
        selectionBox.appendChild(option);
    });
}

function check(input)
 {
 console.log(input.value);
            if (input.value != document.getElementById('password').value) {
                document.getElementById('msg').innerHTML="Passwords must match"
                document.getElementById('submit').disabled = true;
            } else {
                console.log("ovdje");
                document.getElementById('msg').innerHTML="";
                document.getElementById('submit').disabled = false;
            }
 }
 
 function changeBackground(color, event, element) {
    element.target.style.background = color;
    if (event === 'enter')
        element.target.style.cursor = 'pointer'
    if (event === 'exit')
        element.target.style.cursor = 'unset'
}