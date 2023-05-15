// function flip() {
//     var card = document.querySelector('.card');
//     card.classList.toggle('flipped');
// }
$(function() {
    var btns = document.querySelectorAll("#answerInput button");

    function showAnswer(event) {
        var clickedBtn = event.target;

        var card = document.querySelector('.card');
        card.classList.toggle('flipped');

        if (clickedBtn.value === "Y") {
            clickedBtn.style.backgroundColor = "green";
        } else {
            clickedBtn.style.backgroundColor = "red";
        }

        // 모든 버튼 요소에 대해
        for (var i = 0; i < btns.length; i++) {
            var btn = btns[i];
            if (btn === clickedBtn) {
                btn.disabled = true;

                continue;
            } else {
                btn.disabled = true;

                btn.style.backgroundColor = "gray";
            }
        }
    }

    // 모든 버튼 요소에 클릭 이벤트 등록
    for (var i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", showAnswer);
    }
});

var qlno = document.getElementById('qlno').value;
var index = document.getElementById('currentIndex').value;
var quiz = document.getElementById('quizSize').value;
function nextQuiz(){
    index++;
    if (index > quiz) {
        index = quiz - 1;
    }
    if(index == quiz){
        document.getElementById("progressText").innerHTML = "<h4>진행도: 100%</h4>";
        document.querySelector(".progress-bar").style.width = "100%";
        alert("마지막 문제입니다.");
    }else{
        location.href = './quiz_view?qlno='+qlno+'&index=' + index;
    }
}

function prevQuiz(){
    index--;
    if (index <= 0) {
        alert("첫 번째 문제입니다.");
        index = 0;
    }
    location.href = './quiz_view?qlno='+qlno+'&index=' + index;
}

function updateProgress() {
    var progressText = document.getElementById('progressText');
    var progressBar = document.querySelector('.progress-bar');
    var progressPercent = Math.floor(index / quiz * 100);

    progressText.innerHTML = '<h4>진행도: ' + progressPercent + '%</h4>';
    progressBar.style.width = progressPercent + '%';
    progressBar.setAttribute('aria-valuenow', progressPercent);
}

window.addEventListener('load', function() {
    updateProgress();
});