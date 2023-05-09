$(function() {
    var currentIndex = 0;
    var images = $('#banner img');
    var imageCount = images.length;
    var intervalId;

    function startSlideShow() {
        intervalId = setInterval(function() {
            images.eq(currentIndex).fadeOut(1000);
            images.eq(currentIndex).attr('style', 'display: none')
            currentIndex = (currentIndex + 1) % imageCount;
            images.eq(currentIndex).fadeIn(1000);
        }, 4000);
    }

    startSlideShow();

    // 카드 요소와 버튼 요소들을 가져옴
    var btns = document.querySelectorAll("#answer button");

    // 정답 버튼 클릭 시 처리할 함수
    function showAnswer(event) {
        var clickedBtn = event.target;

        var card = document.querySelector('.card');
        card.classList.toggle('flipped');

        if (clickedBtn.value === "correct") {
            clickedBtn.style.backgroundColor = "green";
        }else {
            clickedBtn.style.backgroundColor = "red";
        }

        // 모든 버튼 요소에 대해
        for (var i = 0; i < btns.length; i++) {
            var btn = btns[i];
            if (btn === clickedBtn) {
                btn.disabled = true;
                // 선택한 버튼이면 색상 유지
                continue;
            } else {
                btn.disabled = true;
                // 오답 버튼은 선택하지 않은 경우에만 회색으로 변경
                btn.style.backgroundColor = "gray";
            }
        }
    }

    // 모든 버튼 요소에 클릭 이벤트 등록
    for (var i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", showAnswer);
    }

});