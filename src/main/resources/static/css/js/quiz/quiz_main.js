function randomQuiz(){
    var quizSize = parseInt(document.getElementById("size").getAttribute("value"));
    var qlno = Math.floor(Math.random() * quizSize) + 1;
    location.href = './quiz_view?qlno='+qlno+'&index=0';
}