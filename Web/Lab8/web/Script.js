function storeCookies() {
    var expires = "; expires=Monday, 01-Dec-18 23:59:59 GMT";
    var name = document.form.name.value;
    var mail = document.form.mail.value;
    var user = document.form.user.value;
    var pass = document.form.pass.value;
    var rpass = document.form.rpass.value;
    if (pass === rpass) {
        document.cookie = "name=" + name + expires;
        document.cookie = "mail=" + mail + expires;
        document.cookie = "user=" + user + expires;
        document.cookie = "pass=" + pass + expires;
        document.cookie = "rpass=" + rpass + expires;
    } else
        alert("Unmatch");
}

function cookieVal(cookieName, cookieString) {
    var startLoc = cookieString.indexOf(cookieName);
    if (startLoc === -1) {
        return("");
    }
    var sepLoc = cookieString.indexOf("=", startLoc);
    var endLoc = cookieString.indexOf(";", startLoc);
    if (endLoc === -1) {
        endLoc = cookieString.length;
    }
    return(cookieString.substring(sepLoc + 1, endLoc));
}

function presetValues() {
    var name = document.form.name;
    var mail = document.form.mail;
    var user = document.form.user;
    var pass = document.form.pass;
    var rpass = document.form.rpass;
    var cookies = document.cookie;
    name.value = cookieVal("name", cookies);
    mail.value = cookieVal("mail", cookies);
    user.value = cookieVal("user", cookies);
    pass.value = cookieVal("pass", cookies);
    rpass.value = cookieVal("rpass", cookies);
}
