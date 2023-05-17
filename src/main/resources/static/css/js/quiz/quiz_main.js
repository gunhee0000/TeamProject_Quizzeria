function randomQuiz(){
    var quizSize = document.getElementById("size").value; //안가져와짐;;;
    var qlno = Math.floor(Math.random() * quizSize) + 1;
    location.href = './quiz_view?qlno='+qlno+'&index=0';
}