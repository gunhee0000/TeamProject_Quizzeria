$(document).ready(function(){
    document.getElementById('form_category').addEventListener('change', function() {
        var category = this.value;
        var inputContainer = document.getElementById('inputContainer');

        while (inputContainer.firstChild) {
            inputContainer.removeChild(inputContainer.firstChild);
        }

        if (category === 'Subjective') {
            var input = document.createElement('input');
            input.setAttribute('type', 'text');
            input.setAttribute('id', 'answer');
            input.setAttribute('name', 'answer');
            input.setAttribute('class', 'form-control');
            input.setAttribute('placeholder', '정답 입력');
            inputContainer.appendChild(input);

            var correct = document.createElement('input');
            correct.setAttribute('type', 'radio');
            correct.setAttribute('id', 'correct');
            correct.setAttribute('name', 'correct');
            correct.setAttribute('value', 1);
            correct.setAttribute('checked', 'true');
            inputContainer.appendChild(correct);
        } else if (category === 'BinaryChoice') {
            for (var i = 0; i < 2; i++) {
                var input = document.createElement('input');
                input.setAttribute('type', 'text');
                input.setAttribute('id', 'answer');
                input.setAttribute('name', 'answer');
                input.setAttribute('class', 'form-control');
                input.setAttribute('placeholder', '정답 ' + (i + 1) + ' 입력');
                inputContainer.appendChild(input);

                var correct = document.createElement('input');
                correct.setAttribute('type', 'radio');
                correct.setAttribute('id', 'correct');
                correct.setAttribute('name', 'correct');
                correct.setAttribute('value', i);
                inputContainer.appendChild(correct);
            }
        } else if (category === 'TernaryChoice') {
            for (var i = 0; i < 3; i++) {
                var input = document.createElement('input');
                input.setAttribute('type', 'text');
                input.setAttribute('id', 'answer');
                input.setAttribute('name', 'answer');
                input.setAttribute('class', 'form-control');
                input.setAttribute('placeholder', '정답 ' + (i + 1) + ' 입력');
                inputContainer.appendChild(input);

                var correct = document.createElement('input');
                correct.setAttribute('type', 'radio');
                correct.setAttribute('id', 'correct');
                correct.setAttribute('name', 'correct');
                correct.setAttribute('value', i);
                inputContainer.appendChild(correct);
            }
        } else if (category === 'MultipleChoice') {
            for (var i = 0; i < 4; i++) {
                var input = document.createElement('input');
                input.setAttribute('type', 'text');
                input.setAttribute('id', 'answer');
                input.setAttribute('name', 'answer');
                input.setAttribute('class', 'form-control');
                input.setAttribute('placeholder', '정답 ' + (i + 1) + ' 입력');
                inputContainer.appendChild(input);

                var correct = document.createElement('input');
                correct.setAttribute('type', 'radio');
                correct.setAttribute('id', 'correct');
                correct.setAttribute('name', 'correct');
                correct.setAttribute('value', i);
                inputContainer.appendChild(correct);
            }
        }
    });

    document.getElementById("quizTitleForm").addEventListener("submit", function(event) {
        event.preventDefault();


        var radios = document.getElementsByName("correct");

        for (var i = 0; i < radios.length; i++) {
            if (radios[i].checked) {
                radios[i].value = "Y";
            } else {
                radios[i].value = "N";
            }
        }

        // const question = document.getElementById("form_title").value;
        // const type = document.getElementById("form_category").value;
        // const qlno = document.getElementById("qlno").value;
        //
        // const quizDTO = {
        //     question : question,
        //     type : type,
        //     hidden : "N",
        //     likes : 0,
        //     quizList : qlno
        // };
        //
        // let count = 0;
        // switch (type){
        //     case "Subjective":
        //         count = 1;
        //         break;
        //     case "BinaryChoice":
        //         count = 2;
        //         break;
        //     case "TernaryChoice":
        //         count = 3;
        //         break;
        //     case "MultipleChoice":
        //         count = 4;
        //         break;
        // }
        //
        // const quizAnswerDTO = [];
        //
        // const answer = document.getElementsByName("answer");
        // for(let i=0; i<count; i++){
        //
        //     const quizAnswer = {
        //         quiz : quizDTO,
        //         answer : answer[i].value,
        //         correct : radios[i].value,
        //         hidden : "N"
        //     };
        //
        //     quizAnswerDTO.push(quizAnswer);
        // }
        //
        // fetch('/quiz/quiz_create_question', {
        //     method: 'POST',
        //     headers: {
        //         'Content-Type': 'application/json',
        //     },
        //     body: JSON.stringify({
        //         quizDTO: quizDTO,
        //         quizAnswerDTO: quizAnswerDTO
        //     }),
        // })
        //     .then(response => response.json())
        //     .then(data => {
        //         console.log('Entities created:', data);
        //     })
        //     .catch(error => {
        //         console.error('Error:', error);
        //     });

        this.submit();
    });
});
