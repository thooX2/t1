/**
 * 
 */
// 이미지 변경을 위한 숫자를 세는 함수
let cntFn = (
	(num) => () => num++
)(1);

// setInterval이 끝나기 전에 다른 부분으로 이동하면
// 진행되는 setInterval을 끝내기 위해서 필요한 변수
let countBear;

// 로그인 실패후 나오는 부분
$(function() {
	if ($('#errorId').val() != null || $('#errorPw').val() != null) {
		$('#hiBear').attr('src', `/default/img/bear/errorBear.png`);
	}
})

// 아이디입력부분에 커서를 가져다 대면 이미지가 변경되는 함수
$('#login').focus(function() {
	clearInterval(countBear);

	cntFn = (
		(num) => () => num++
	)(1);

	countBear = setInterval(function() {
		let result = cntFn();

		$('#hiBear').attr('src', `/default/img/bear/watch${result}.png`);

		if (result >= 24) {
			clearInterval(countBear);
			cntFn = (
				(num) => () => num++
			)(1);
		}
	}, 30);
});

// 아이디입력부분에서 포커스가 해제될때 이미지가 변경되는 함수
$('#login').blur(function() {
	clearInterval(countBear);
	cntFn = (
		(num) => () => num++
	)(1);

	countBear = setInterval(function() {
		let result = cntFn();

		$('#hiBear').attr('src', `/default/img/bear/watch${13 - result}.png`);

		if (result >= 12) {
			clearInterval(countBear);
			cntFn = (
				(num) => () => num++
			)(1);
		}
	}, 30);
});

// 비밀번호입력부분에서 커서를 가져다대면 이미지가 변경되는 함수
$('#password').focus(function() {
	clearInterval(countBear);

	cntFn = (
		(num) => () => num++
	)(1);

	countBear = setInterval(function() {
		let result = cntFn();

		$('#hiBear').attr('src', `/default/img/bear/bear${result}.png`);

		if (result >= 5) {
			clearInterval(countBear);
			cntFn = (
				(num) => () => num++
			)(1);
		}
	}, 30);
});

// 비밀번호입력부분에서 포커스를 해제하면 이미지가 변경되는 함수
$('#password').blur(function() {
	clearInterval(countBear);

	cntFn = (
		(num) => () => num++
	)(1);

	countBear = setInterval(function() {
		let result = cntFn();

		$('#hiBear').attr('src', `/default/img/bear/bear${6 - result}.png`);

		if (result >= 5) {
			clearInterval(countBear);
			cntFn = (
				(num) => () => num++
			)(1);
		}
	}, 30);
});
