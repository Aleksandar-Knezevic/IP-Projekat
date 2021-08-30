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