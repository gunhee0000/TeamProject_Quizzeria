$(document).ready(function(){
    document.getElementById('form_category').addEventListener('change', function() {
        var category = this.value;
        var inputContainer = document.getElementById('inputContainer');

        while (inputContainer.firstChild) {
            inputContainer.removeChild(inputContainer.firstChild);
        }

        if (category === 'Subjective') {
            var input = document.createElement('input');
            var correct = document.createElement('input');
            input.setAttribute('type', 'text');
            input.setAttribute('class', 'form-control');
            input.setAttribute('placeholder', '정답 입력');
            correct.setAttribute('type', 'radio');
            correct.setAttribute('name', 'correct');
            correct.setAttribute('value', 'answer');
            correct.setAttribute('checked', 'true');
            inputContainer.appendChild(input);
            inputContainer.appendChild(correct);
        } else if (category === 'BinaryChoice') {
            for (var i = 0; i < 2; i++) {
                var input = document.createElement('input');
                input.setAttribute('type', 'text');
                input.setAttribute('class', 'form-control');
                input.setAttribute('placeholder', '정답 ' + (i + 1) + ' 입력');
                inputContainer.appendChild(input);
            }
        } else if (category === 'TernaryChoice') {
            for (var i = 0; i < 3; i++) {
                var input = document.createElement('input');
                input.setAttribute('type', 'text');
                input.setAttribute('class', 'form-control');
                input.setAttribute('placeholder', '정답 ' + (i + 1) + ' 입력');
                inputContainer.appendChild(input);
            }
        } else if (category === 'MultipleChoice') {
            for (var i = 0; i < 4; i++) {
                var input = document.createElement('input');
                input.setAttribute('type', 'text');
                input.setAttribute('class', 'form-control');
                input.setAttribute('placeholder', '정답 ' + (i + 1) + ' 입력');
                inputContainer.appendChild(input);
            }
        }
    });
});