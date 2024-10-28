/**
 * 241005
 * user_exam_take.html customJs
 *  작성자 : 문성민
 */
const $title = document.querySelector('title');
$title.textContent = '모의고사 응시';
// 문제를 다풀면 여기를 true로 변경

let nextFlag = false;

$('.popexam-wrap__question--link').click(function(e) {
	const $targetDiv = $(e.target).parent().find('.popexam-wrap__info.popexam-wrap__info-first')

	if ($targetDiv.css('display') === "none"
		|| $targetDiv.css('display') === "") {
		$targetDiv.css('display', 'block'); // 보이게 함
	} else {
		$targetDiv.css('display', 'none'); // 숨김

	}
});

$('.button-ico__exam.button-ico__exam-close').click(function(e) {
	const $targetDiv = $(e.target).parents('.popexam-wrap__info.popexam-wrap__info-first')

	if ($targetDiv.css('display') === "none"
		|| $targetDiv.css('display') === "") {
		$targetDiv.css('display', 'block'); // 보이게 함
	} else {
		$targetDiv.css('display', 'none'); // 숨김

	}
});

function fncViewQues(questionNumber) {
	// 이동할 요소의 ID를 생성
	const targetId = `ques${questionNumber}`;
	// 해당 요소를 찾음
	const targetElement = document.getElementById(targetId);

	if (targetElement) {
		// 부드럽게 스크롤 이동
		targetElement.scrollIntoView({
			behavior: 'smooth'
		});
	} else {
		console.error(`Element with ID ${targetId} not found.`);
	}
}
function fncAnsMark() {
	const userCheck = confirm('답안을 채점하시겠습니까?');
	if (!userCheck) {
		return;
	}

	let allChecked = true; // 모든 라디오 버튼이 선택되었는지 확인하는 변수

	// 모든 문제에 대해 반복
	for (let i = 1; i <= 20; i++) {
		const radios = document.getElementsByName(`ans${i}`);
		const row = document.getElementById(`qans${i}`);
		const checked = [...radios].some(radio => radio.checked);

		// 라디오 버튼 선택 여부에 따라 배경색 변경
		if (!checked) {
			allChecked = false; // 하나라도 선택되지 않으면 false로 설정
			row.style.backgroundColor = 'red';
		} else {
			row.style.backgroundColor = ''; // 선택된 경우 기본값으로 되돌리기
		}
	}

	// 모든 라디오 버튼이 선택된 경우 페이지 이동
	if (allChecked) {

		// 답안지를 채점결과로 변경
		const $tit = document.getElementById('tit');
		$tit.textContent = '채점결과';

		// 채점하기 버튼을 변경
		const $examResult = document.getElementById('examResult');
		$examResult.style.display = 'table-row';

		// 버튼과 메뉴 상태 초기화
		resetExamControls();

		// 오른쪽 답안지 위로 스크롤
		scrollToAnswerArea();

		// 유저가 선택한 정답을 배열에 담기
		checkAnswer();

		// 채점 및 정답표에 선택지를 표기
		gradeAnswer();
		nextFlag = true;
	} else {
		alert('답안을 선택하지 않은 문항이 있습니다');
	}
}

// 버튼과 메뉴 상태 초기화 함수
function resetExamControls() {
	const $swpause = document.getElementById('swpause');
	const $swstart = document.getElementById('swstart');
	const $swstop = document.getElementById('swstop');
	const $gradeExam = document.getElementById('gradeExam');
	const $examDoneMenu = document.getElementById('examDoneMenu');

	swReset();
	$swpause.style.display = 'none';
	$swstart.style.display = 'inline-block';
	$swstart.className = 'button-ico__time button-ico__time-play off';
	$swstop.className = 'button-ico__time button-ico__time-stop off';
	$swstart.onclick = null;
	$swstop.onclick = null;
	$gradeExam.style.display = 'none';
	$examDoneMenu.style.display = 'inline';
}

let timer;
let elapsedSeconds = 0;
let isPaused = false;
let isReStart = false;

// 시간을 포맷팅하는 함수 (HH:MM:SS 형식)
function formatTime(seconds) {
	let hrs = Math.floor(seconds / 3600);
	let mins = Math.floor((seconds % 3600) / 60);
	let secs = seconds % 60;

	return `${hrs.toString().padStart(2, '0')} : ${mins.toString().padStart(2, '0')} : ${secs.toString().padStart(2, '0')}`;
}

// 타이머를 시작하는 함수
function startTimer() {
	timer = setInterval(() => {
		if (!isPaused) {
			elapsedSeconds++;
			document.getElementById('swtime').innerHTML = formatTime(elapsedSeconds);
		}
	}, 1000);
}

// 타이머 일시정지 함수
function swPause() {
	isPaused = true;
	document.getElementById('swpause').style.display = 'none';  // 일시정지 버튼 숨김
	document.getElementById('swstart').style.display = 'inline-block'; // 시작 버튼 표시
}

// 타이머 재개 함수
function swStart() {
	isPaused = false;
	document.getElementById('swpause').style.display = 'inline-block'; // 일시정지 버튼 표시
	document.getElementById('swstart').style.display = 'none';   // 시작 버튼 숨김
	if (isReStart) {
		startTimer();
		isReStart = false;
	}
}

// 타이머 리셋 함수
function swReset() {
	clearInterval(timer);
	elapsedSeconds = 0;
	document.getElementById('swtime').innerHTML = "00 : 00 : 00";
	document.getElementById('swpause').style.display = 'none';  // 일시정지 버튼 숨김
	document.getElementById('swstart').style.display = 'inline-block'; // 시작 버튼 표시
	isPaused = true;
	isReStart = true;
}

// 페이지 로드 시 타이머 자동 시작
window.onload = () => {
	startTimer();
};
// 채점후 다시 응시하기버튼을 누를경우
function takeReExam() {
	const width = window.innerWidth * 1.0;
	const height = window.innerHeight * 1.0;
	const reExam = confirm('해당 시험을 다시 응시하시겠습니까?');

	if (reExam) {
		window.open('/exam/userExamTake', 'popupWindow', `width=${width},height=${height},scrollbars=yes`);
	}
}

// 답안지 위로 스크롤
function scrollToAnswerArea() {
	document.getElementById("swpause").scrollIntoView({ behavior: 'smooth' });
}

// 유저가 선택한 정답을 배열에 담기
function checkAnswer() {
	// 답안을 저장할 배열
	var answers = [];

	// 1~20번 문항의 선택된 값을 배열에 저장
	for (var i = 1; i <= 20; i++) {
		var radios = document.getElementsByName('ans' + i);
		var selectedValue = null;

		// 해당 문항에서 체크된 radio button 값 찾기
		for (let element of radios) {
			if (element.checked) {
				selectedValue = element.value;
				break;
			}
		}

		// 선택된 값이 있으면 배열에 추가, 없으면 0 (또는 다른 기본값)
		answers.push(selectedValue || 0);
	}
	console.log("제출된 답:", answers);
	return answers;
}

// 문제의 답안과 유저가 입력한 답안을 비교후 채점 및 답안지에 선택표기
function gradeAnswer() {
	// 정답수를 기록하기위한 변수
	let cntCorrect = 0;

	// 문제지 정답
	const Answer = [4, 2, 5, 1, 1, 4, 4, 1, 4, 3, 3, 1, 1, 4, 5, 4, 4, 3, 1, 3];
	// 유저정답
	const userAnswer = checkAnswer();

	for (let i = 0; i < Answer.length; i += 1) {
		// 답안지에 정답체크
		addSpanToRadioValue((i + 1), Answer[i], true);

		// 답안지에 유저정답체크
		setRadioState((i + 1), userAnswer[i], false);
		if (Answer[i] == userAnswer[i]) {
			cntCorrect += 1;
			// 답안지 숫자부분에 o 표기
			markCorrect((i + 1), true);
		} else {
			// 답안지 숫자부분에 x 표기
			markCorrect((i + 1), false);
		}
	}

	// 정답수와 오답수 계산후 표기
	const $myoxcnt = document.getElementById('myoxcnt');
	$myoxcnt.innerHTML = `정답 ${cntCorrect} <strong>오답 ${Answer.length - cntCorrect}</strong>`;
}

// 답안지 숫자부분에 정답과 오답표기``
function markCorrect(questionNumber, check) {
	// 해당하는 문항의 <p> 요소를 찾음
	var questionRow = document.getElementById('qans' + questionNumber);
	var pElement = questionRow.querySelector('.num p');

	// 중복 추가 방지
	if (!pElement.querySelector('.chk_o')) {
		// <span> 요소 추가 후 p 태그의 내용을 업데이트
		pElement.innerHTML = questionNumber + (check ? ' <span class="chk_o"></span>' : ' <span class="chk_x"></span>');
	}
}

// 유저가 기입한 정답만 활성화(check가 false인 경우)
// 라디오 버튼을 찾기.
function setRadioState(questionNumber, activeValue, check) {

	const radios = document.getElementsByName('ans' + questionNumber);

	for (let radio of radios) {
		radio.disabled = (radio.value == activeValue) ? false : true;
	}

	// 선택지를 답안지에 표기하는 함수
	addSpanToRadioValue(questionNumber, activeValue, check);
}

// 선택지를 답안지에 표기하는 함수
function addSpanToRadioValue(questionNumber, value, check) {
	const radios = document.getElementsByName('ans' + questionNumber);

	for (let radio of radios) {
		if (radio.value == value) {
			const parentTd = radio.parentElement;
			const spanElement = document.createElement('span');

			spanElement.className = check ? 'table-type__answer--chk_correct' : 'table-type__answer--chk_mine';
			spanElement.innerHTML = check ? '<img src="/user/img/exam/userExamTake/ic_cir_on.gif" alt="">' : '<img src="/user/img/exam/userExamTake/ic_cir.gif" alt="">';

			// <span>을 <td>에 추가합니다.
			parentTd.appendChild(spanElement);
			break;
		}
	}
}

// 시험 채점후 정답/해설보기에서 채점결과를 가지고 해설페이지로 이동
$('#examSolutionBtn').click(function() {
	if (nextFlag) {
		const examAnswer = [4, 2, 5, 1, 1, 4, 4, 1, 4, 3, 3, 1, 1, 4, 5, 4, 4, 3, 1, 3];
		const $form = $(`<form><input type="hidden" name="userAnswer" value="${checkAnswer().join(',')}"/>
		<input type="hidden" name="examAnswer" value="${examAnswer.join(',')}"/></form>`);
		$form.attr('action', "/exam/userExamSolution");
		$form.attr('method', 'post');
		$form.appendTo('body');
		$form.submit();
	} else {
		alert('문제풀기후 확인가능합니다');
	}
})

$('#topMenu > li > a').click(function() {
	if (nextFlag) {
		const examAnswer = [4, 2, 5, 1, 1, 4, 4, 1, 4, 3, 3, 1, 1, 4, 5, 4, 4, 3, 1, 3];
		const $form = $(`<form><input type="hidden" name="userAnswer" value="${checkAnswer().join(',')}"/>
			<input type="hidden" name="examAnswer" value="${examAnswer.join(',')}"/></form>`);
		$form.attr('action', "/exam/userExamSolution");
		$form.attr('method', 'post');
		$form.appendTo('body');
		$form.submit();
	} else {
		alert('문제풀기후 확인가능합니다');
	}
})
