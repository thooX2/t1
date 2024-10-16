/**
 * user_join_form.html javascript
 */
$(function() {
	$("#reg_zip_find").css("display", "inline-block");


	// 휴대폰인증
	$("#win_hp_cert").click(function() {
		if (!cert_confirm())
			return false;


		certify_win_open("kcp-hp", "https://moden939.gabia.io/plugin/kcpcert/kcpcert_form.php");
		return;
	});
});

// submit 최종 폼체크
function fregisterform_submit(f) {
	// 회원아이디 검사
	if (f.w.value == "") {
		var msg = reg_mb_id_check();
		if (msg) {
			alert(msg);
			f.mb_id.select();
			return false;
		}
	}

	if (f.w.value == "") {
		if (f.mb_password.value.length < 3) {
			alert("비밀번호를 8글자 이상 입력하십시오.");
			f.mb_password.focus();
			return false;
		}
	}

	if (f.mb_password.value != f.mb_password_re.value) {
		alert("비밀번호가 같지 않습니다.");
		f.mb_password_re.focus();
		return false;
	}

	if (f.mb_password.value.length > 0) {
		if (f.mb_password_re.value.length < 3) {
			alert("비밀번호를 8글자 이상 입력하십시오.");
			f.mb_password_re.focus();
			return false;
		}
	}

	// 이름 검사
	if (f.w.value == "") {
		if (f.mb_name.value.length < 1) {
			alert("이름을 입력하십시오.");
			f.mb_name.focus();
			return false;
		}

		/*
		var pattern = /([^가-힣\x20])/i;
		if (pattern.test(f.mb_name.value)) {
alert("이름은 한글로 입력하십시오.");
f.mb_name.select();
return false;
		}
*/
	}

	// E-mail 검사
	if ((f.w.value == "") || (f.w.value == "u" && f.mb_email.defaultValue != f.mb_email.value)) {
		var msg = reg_mb_email_check();
		if (msg) {
			alert(msg);
			f.reg_mb_email.select();
			return false;
		}
	}

	// 휴대폰번호 체크
	var msg = reg_mb_hp_check();
	if (msg) {
		alert(msg);
		f.reg_mb_hp.select();
		return false;
	}

	if (typeof (f.mb_recommend) != "undefined" && f.mb_recommend.value) {
		if (f.mb_id.value == f.mb_recommend.value) {
			alert("본인을 추천할 수 없습니다.");
			f.mb_recommend.focus();
			return false;
		}

		var msg = reg_mb_recommend_check();
		if (msg) {
			alert(msg);
			f.mb_recommend.select();
			return false;
		}
	}

	if (!chk_captcha()) return false;

	document.getElementById("btn_submit").disabled = "disabled";

	return true;
}
$(function() {
	$("#top_btn").on("click", function() {
		$("html, body").animate({ scrollTop: 0 }, '500');
		return false;
	});

	$(window).scroll(function() {
		if ($(document).scrollTop() > 300) {
			$('#top_btn').fadeIn(500);
		} else {
			$('#top_btn').fadeOut(500);
		}
	});
});
