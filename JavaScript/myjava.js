function check() {
    var uname = document.getElementById("username").value
    var pword = document.getElementById("password").value
    var uspan = document.getElementById("len1")
    var p1_span = document.getElementById("len2")
    uspan.innerHTML = ""
    p1_span.innerHTML = ""
    if (uname.length == 0) {
        uspan.innerHTML = "<font color = red>Username cannot be left blank</font>"
        return false
    }

    if (pword.length == 0) {
        p1_span.innerHTML = "<font color = red>Password cannot be left blank</font>"
        return false
    }

    else if ((pword.length < 6 || pword.length > 12)) {
        p1_span.innerHTML = "<font color = red>Password should be between 6-12</font>"
        return false
    }

    else if (pword.charAt(0) != 'A') {
        p1_span.innerHTML = "<font color = red>Password should start with an A</font>"
        return false
    }
}