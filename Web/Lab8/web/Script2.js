var timerID = null;
var time = 60;
function stopclock() {
    time = 60;
    clearInterval(timerID);
    document.getElementById("clock").innerHTML = "Start counting down 1:00 [mm:ss]";
}
function startclock() {
    stopclock();
    timerID = setInterval("showtime()", 1000);
    document.getElementById("text").style.display = "block";
    document.getElementById("question").style.display = "block";
}
function showtime() {
    time--;
    var min = Math.floor(time / 60);
    var sec = time - min * 60;
    document.getElementById("clock").innerHTML = "The remaining time: " + min + ":" + sec + " [mm:ss]";
    if (time === 0) {
        stopclock();
        document.getElementById("up").style.display = "block";
        document.getElementById("sub").style.display = "block";
        document.getElementById("text").style.display = "none";
        document.getElementById("question").style.display = "none";
    }
}