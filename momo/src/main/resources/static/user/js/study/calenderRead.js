document.addEventListener('DOMContentLoaded', function() {
	document.getElementById('smjrcc').addEventListener('click', function() {
		const selectedSubject = this.value;
		const detailSubjectSelect = document.getElementById('smircc');

		// 기존 옵션 삭제
		detailSubjectSelect.innerHTML = '';

		// 선택된 과목에 따라 세부 과목 배열 생성
		let options = [];
		if (selectedSubject === "smjrcc1") {
			options = [
				{ value: "smircc1", text: "독서" },
				{ value: "smircc2", text: "문학" },
				{ value: "smircc3", text: "화법과 작문" },
				{ value: "smircc3", text: "언어와 매체" }
			];
		} else if (selectedSubject === "smjrcc2") {
			options = [
				{ value: "smircc5", text: "수학1" },
				{ value: "smircc6", text: "수학2" },
				{ value: "smircc7", text: "확률과 통계" },
				{ value: "smircc8", text: "미분과 적분" },
				{ value: "smircc9", text: "기하" }
			];
		}
		else if (selectedSubject === "smjrcc3") {
			options = [
				{ value: "smircc10", text: "영어1" },
				{ value: "smircc11", text: "영어1" }
			]

		}
		else if (selectedSubject === "smjrcc4") {
			options = [
				{ value: "null", text: "한국사" }
			]
		}
		else if (selectedSubject === "smjrcc5") {
			options = [
				{ value: "smircc12", text: "생활과 윤리" },
				{ value: "smircc13", text: "윤리와 사상" },
				{ value: "smircc14", text: "한국지리" },
				{ value: "smircc15", text: "세계지리" },
				{ value: "smircc16", text: "동아시아사" },
				{ value: "smircc17", text: "세계사" },
				{ value: "smircc18", text: "경제" },
				{ value: "smircc19", text: "정치와 법" },
				{ value: "smircc20", text: "사회 문화" }
			]

		}
		else if (selectedSubject === "smjrcc6") {
			options = [
				{ value: "smircc21", text: "물리학1" },
				{ value: "smircc22", text: "화학1" },
				{ value: "smircc23", text: "생명과학1" },
				{ value: "smircc24", text: "지구과학1" },
				{ value: "smircc25", text: "물리학2" },
				{ value: "smircc26", text: "화학2" },
				{ value: "smircc27", text: "생명과학2" },
				{ value: "smircc28", text: "지구과학2" }
			]

		}
		else if (selectedSubject === "smjrcc7") {
			options = [
				{ value: "smircc29", text: "성공적인 직업생활" },
				{ value: "smircc30", text: "농업 기초 기술" },
				{ value: "smircc31", text: "공업 일반" },
				{ value: "smircc32", text: "산업 경제" },
				{ value: "smircc33", text: "수산 해운 산업 기초" },
				{ value: "smircc34", text: "인간 발달" }
			]

		}
		else if (selectedSubject === "smjrcc8") {
			options = [
				{ value: "smircc35", text: "독일어1" },
				{ value: "smircc36", text: "프랑스어1" },
				{ value: "smircc37", text: "스페인어1" },
				{ value: "smircc38", text: "중국어1" },
				{ value: "smircc39", text: "일본어1" },
				{ value: "smircc40", text: "러시아어1" },
				{ value: "smircc41", text: "아랍어1" },
				{ value: "smircc42", text: "베트남어1" },
				{ value: "smircc43", text: "한문1" }

			]

		}
		else {
			options = [
				{ value: null, text: "선택된 과목이 없습니다." }
			]
		}

		// 옵션을 만들어서 detailSubjectSelect에 추가
		options.forEach(function(optionData) {
			const option = document.createElement('option');
			option.value = optionData.value; // value 설정
			option.textContent = optionData.text; // textContent 설정
			detailSubjectSelect.appendChild(option); // 옵션 추가
		});
	});
});



let currentEvent = null;
let tempEvent = null; // 임시 이벤트
let isModalOpen = false; // 모달 상태 변수
let startDays = {}; // 각 계획별 날자의 시작점 저장 변수
let EndDays = {}; // 계획별 종료일의 종료 변수
let Event = new Set();

$('#eventModal').modal('hide');

document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');

	$.ajax({
		url: '/study/learning-schedules',
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			data.forEach(function(item) {
				const endDays = new Date(item.endDay);
				const compleate = (item.result).substring(0, 3);
				
				const detail = item.result !== null ? (item.result).substring(0, 3) : item.result;
				if (compleate === '미달성') {
					item.compleateMemo = '진행중 : 현재 진행중인 상태 입니다.';
				}
				if (detail === '미달성') {
					item.result = '진행중 : 현재 진행중인 상태 입니다.';
				}
				if (item.fullSchedule !== null) {
					startDays[item.fullSchedule] = item.startDay;
					EndDays[item.fullSchedule] = item.endDay;

				}

				endDays.setDate(endDays.getDate() + 1);
				const eventitem = item.fullSchedule;
				if (item.detailed === null || item.FullSchedule !== null) {
				if (!Event.has(eventitem)) {
					Event.add(eventitem);

					currentEvent = calendar.addEvent({
						title: item.lesMemo,
						mainKey: item.fullSchedule,
						subKey: item.detailed,
						subject1: item.submjr,
						subject2: item.submir,
						start: item.startDay,
						end: endDays,
						days: item.days,
						startDays: item.startDay,
						endDays: endDays,
						allDay: true,
						extendedProps: {
							result: item.compleateMemo
						}
					});
				}
				}

				/*if (item.detailed === null || item.FullSchedule !== null) {
					currentEvent = calendar.addEvent({
						title: item.lesMemo,
						mainKey: item.fullSchedule,
						subKey: item.detailed,
						subject1: item.submjr,
						subject2: item.submir,
						start: item.startDay,
						end: endDays,
						days: item.days,
						startDays: item.startDay,
						endDays: endDays,
						allDay: true,
						extendedProps: {
							result: item.compleateMemo
						}
					});
				}*/

				if (item.detailed !== null) {
					const startday = new Date(`${item.detailDate}T${item.startTime}`);
					const endday = new Date(`${item.detailDate}T${item.endTime}`);
					console.log("시작 일자 입니다. : " + startday + "종료일자 입니다. : " + endday);
					currentEvent = calendar.addEvent({
						mainKey: item.fullSchedule,
						subKey: item.detailed,
						title: item.detailMemo,
						subject1: item.submjr,
						subject2: item.submir,
						start: startday,
						end: endday,
						days: 1,
						allDay: false,
						extendedProps: { result: item.result }
					});
				}
			});

		},
		error: function(xhr, status, error) {
			/*console.error('Error fetching learning schedules:', error);*/
		}
	});




	var calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar: {
			left: 'prev,next today',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay'
		},

		navLinks: true,
		selectable: true,
		selectMirror: true,
		dateClick: function(info) {
			document.getElementById('title').value = null;
			document.getElementById('smjrcc').value = null;
			document.getElementById('smircc').value = null;
			$('#eventModal').modal('show');


		},
		select: function(info) {
			document.getElementById('save').style.display = '';
			document.getElementById('editButton').style.display = 'none'
			document.getElementById('title').value = null;
			document.getElementById('smjrcc').value = null;
			document.getElementById('smircc').value = null;

			const startDate = new Date(info.start);
			const endDate = new Date(info.end);
			const startYear = startDate.getFullYear();
			const startMonth = String(startDate.getMonth() + 1).padStart(2, '0');
			const startDay = String(startDate.getDate()).padStart(2, '0');
			const startDateOnly = `${startYear}-${startMonth}-${startDay}`;

			const endYear = endDate.getFullYear();
			const endMonth = String(endDate.getMonth() + 1).padStart(2, '0');
			let endDay = String(endDate.getDate()).padStart(2, '0');
			if (startDay != endDay) {
				endDay = String(endDate.getDate() - 1).padStart(2, '0');
			}
			const endOnly = `${endYear}-${endMonth}-${endDay}`;



			const days = (endDate - startDate) / (1000 * 60 * 60 * 24);
			const resultdays = days < 1 ? 1 : days;

			document.getElementById('startDate').value = startDateOnly;
			document.getElementById('startTime').value = startDate.toTimeString().split(' ')[0].slice(0, 5);
			document.getElementById('endDate').value = endOnly
			document.getElementById('endTime').value = endDate.toTimeString().split(' ')[0].slice(0, 5);


			document.getElementById('days').value = resultdays;

			const resultType = document.getElementById('result');
			resultType.readOnly = true;
			resultType.textContent = "미달성 : 생성 이후에 수정해 주시기 바랍니다.";
			tempEvent = calendar.addEvent({
				title: '',
				subject1: '',
				subject2: '',
				start: info.start,
				end: info.end,
				allDay: false,
				rendering: 'background',
				color: 'rgba(0, 123, 255, 0.2)',
				editable: false
			});

			isModalOpen = true;
			$('#eventModal').modal('show');
			console.log("종료일" + document.getElementById('endDate').value);
			console.log("시작일" + document.getElementById('startDate').value);
			if (document.getElementById('endDate').value !== document.getElementById('startDate').value) {
				document.getElementById('selectName').style.display = 'none';
				document.getElementById('endTimer').style.display = 'none';
				document.getElementById('startTimer').style.display = 'none';
				eventModalLabel
				document.getElementById('eventModalLabel').textContent = "학습계획 생성";

			}
			else {
				document.getElementById('eventModalLabel').textContent = "세부계획 생성";
				document.getElementById('selectName').style.display = '';
				document.getElementById('endTimer').style.display = '';
				document.getElementById('startTimer').style.display = '';
				document.getElementById('endDays').style.display = 'none';
			}

			document.getElementById('eventForm').onsubmit = function(e) {
				e.preventDefault();
				const userCode = document.getElementById('userId').value;
				const title = document.getElementById('title').value.trim();
				const subject1 = document.getElementById('smjrcc').value;
				const subject2 = document.getElementById('smircc').value;
				const startDate = document.getElementById('startDate').value;
				const startTime = document.getElementById('startTime').value;
				const endDate = document.getElementById('endDate').value;
				const endTime = document.getElementById('endTime').value;
				const start = new Date(`${startDate}T${startTime}`);
				const end = new Date(`${endDate}T${endTime}`);
				const domEndDate = new Date(endDate);
				domEndDate.setDate(domEndDate.getDate() + 1);
				const days = ((end - start) / (1000 * 60 * 60 * 24)) + 1;
				const resultdays = days < 1 ? 1 : days;
				const result = document.getElementById('result').value;
				const learningType = document.getElementById('learning');
				const learning = document.getElementById('learning').value;

				console.log("우선 날자 간격 :" + days);
				console.log("다음으로 시작일 :" + start);
				console.log("다음으로 종료일 :" + start);


				// 유효성 검사
				if (end <= start) {
					alert('종료일자와 종료시간은 시작일자와 시작시간보다 늦어야 합니다.');
					return;
				}



				if (!title) {
					alert('제목을 입력해야 합니다.');
					return;
				}

				const mainKey = document.getElementById('learning').value;

				const learningData = {
					userCode: userCode,
					smjcc: subject1,
					smicc: subject2,
					learningScheduleStart: startDate,
					learningScheduleEnd: endDate,
					learningScheduleDay: resultdays,
					learningScheduleMemo: title,
					learningScheduleCompleate: result
				};

				const detailData = {
					userCode: userCode,
					learningSchedule: learning,
					smjrcc: subject1,
					smircc: subject2,
					detailedScheduleMemo: title,
					detailedScheduleDate: startDate,
					detailedScheduleStartTime: startTime,
					detailedScheduleEndTime: endTime,
					detailedScheduleResult: result
				}


				// 시작일자와 종료일자 비교
				if (start.toDateString() !== end.toDateString()) {

					$.ajax({
						url: '/study/addLearningSchedule', // learning 테이블로 보내는 API URL
						method: 'POST',
						contentType: 'application/json',
						data: JSON.stringify(learningData),

						success: function(response) {
							/*window.location.href = '/study/getLearningScheduleList';*/
						},

						error: function(xhr, status, error) {
							/*console.error('Learning 데이터 저장 실패:', error);*/
						}
					});

					currentEvent = calendar.addEvent({
						title: title,
						subject1: subject1,
						subject2: subject2,
						start: start,
						end: domEndDate,
						days: days,
						allDay: true,

					});

				}
				else {
					if (startDays[mainKey] > startDate || startDate > EndDays[mainKey]) {
						console.log('실패');
						alert('선택하신 계획이랑 날자가 일치하지 않습니다. 다시 설정해 주세요.');
						return;
					}

					$.ajax({
						url: '/study/addDetailedSchedule', // detail 테이블로 보내는 API URL
						method: 'POST',
						contentType: 'application/json',
						data: JSON.stringify(detailData),
						success: function(response) {
							/*	console.log('Detail 데이터 저장 성공:', response);*/
							/*window.location.href = '/study/getLearningScheduleList';*/
						},
						error: function(xhr, status, error) {
							/*	console.error('Detail 데이터 저장 실패:', error);*/
						}
					});

					currentEvent = calendar.addEvent({
						title: title,
						subject1: subject1,
						subject2: subject2,
						start: start,
						end: end,
						allDay: false,

					});
				}

				if (tempEvent) {
					tempEvent.remove();
					tempEvent = null;
				}

				$('#eventModal').modal('hide');
				this.reset();
				currentEvent = null;
				isModalOpen = false;
			};

		},
		eventClick: function(info) {
			const userCode = document.getElementById('userId').value;
			const title = document.getElementById('title').value.trim();
			const subject1 = document.getElementById('smjrcc').value;
			const subject2 = document.getElementById('smircc').value;
			const startDate = document.getElementById('startDate').value;
			const startTime = document.getElementById('startTime').value;
			const endDate = document.getElementById('endDate').value;
			const endTime = document.getElementById('endTime').value;
			const start = new Date(`${startDate}T${startTime}`);
			const end = new Date(`${endDate}T${endTime}`);
			const domEndDate = new Date(endDate);
			domEndDate.setDate(domEndDate.getDate() + 1);
			const days = ((end - start) / (1000 * 60 * 60 * 24)) + 1;
			const resultdays = days < 1 ? 1 : days;
			const resultType = document.getElementById('result');
			const result = document.getElementById('result').value;
			const learning = document.getElementById('learning').value;
			const event = info.event;
			currentEvent = event;

			console.log("startDays" + startDays[event.extendedProps.mainKey]);
			console.log("endDays : " + EndDays[event.extendedProps.mainKey]);


			document.getElementById('learning').value = event.extendedProps.mainKey;
			document.getElementById('title').value = event.title;
			document.getElementById('smjrcc').value = event.extendedProps.subject1;
			document.getElementById('smircc').value = event.extendedProps.subject2;


			resultType.readOnly = false;
			if (event.extendedProps.result == null) {
				resultType.textContent = "현재 결과값이 없습니다. 새롭게 추가해 주시기 바랍니다.";
			}
			resultType.textContent = event.extendedProps.result;
			document.getElementById('save').style.display = 'none';
			document.getElementById('editButton').style.display = ''

			const eventYear = event.start.getFullYear();
			const eventMonth = String(event.start.getMonth() + 1).padStart(2, '0');
			const eventDay = String(event.start.getDate()).padStart(2, '0');
			const eventDateOnly = `${eventYear}-${eventMonth}-${eventDay}`;
			const endYear = event.end.getFullYear();
			const endMonth = String(event.end.getMonth() + 1).padStart(2, '0');
			let endDay = String(event.end.getDate()).padStart(2, '0');
			if (eventDay != endDay) {
				endDay = String(event.end.getDate() - 1).padStart(2, '0');
			}
			const endOnly = `${endYear}-${endMonth}-${endDay}`;

			document.getElementById('startDate').value = eventDateOnly;
			document.getElementById('startTime').value = event.start.toTimeString().split(' ')[0].slice(0, 5);

			console.log(eventDateOnly);
			console.log(event.end);

			/*if (document.getElementById('endDate').value !== document.getElementById('startDate').value) {

				document.getElementById('learning').setAttribute('required', true);
			}
			else {
				document.getElementById('learning').setAttribute('required', true);
			}*/

			if (event.end == null) {
				document.getElementById('endDate').value = eventDateOnly;
				document.getElementById('endTime').avlue = event.start.toTimeString().split(' ')[0].slice(0, 5)
			}

			if (eventDay == endDay) {
				document.getElementById('endDate').value = eventDateOnly;
				document.getElementById('endTime').value = event.end.toTimeString().split(' ')[0].slice(0, 5);

				document.getElementById('startTimer').setAttribute('required', true);
				document.getElementById('endTimer').setAttribute('required', true);
			}

			else {
				console.log(event.end);
				document.getElementById('endDate').value = endOnly
				document.getElementById('endTime').value = event.end.toTimeString().split(' ')[0].slice(0, 5);
			}





			document.getElementById('days').value = event.extendedProps.days;
			$('#eventModal').modal('show');

			document.getElementById('nmSmircc').textContent = "선택된 과목 입니다. (변경을 원하실 경우 과목을 다시 선택해 주세요.)";

			document.getElementById('learning').addEventListener('change', function() {
				console.log("변화한 후 값 확인" + document.getElementById('learning').value);
			});


			if (eventDay !== endDay) {
				document.getElementById('selectName').style.display = 'none';
				document.getElementById('endTimer').style.display = 'none';
				document.getElementById('startTimer').style.display = 'none';
				eventModalLabel
				document.getElementById('eventModalLabel').textContent = "학습계획 생성";

			}
			else {
				document.getElementById('eventModalLabel').textContent = "세부계획 생성";

				document.getElementById('selectName').style.display = '';
				document.getElementById('endTimer').style.display = '';
				document.getElementById('startTimer').style.display = '';
				document.getElementById('endDays').style.display = 'none';
			}

			const subjects = {
				"smircc3": "언어와 매체",
				"smircc5": "수학1",
				"smircc6": "수학2",
				"smircc7": "확률과 통계",
				"smircc8": "미분과 적분",
				"smircc9": "기하",
				"smircc10": "영어1",
				"smircc11": "영어2",
				"smircc48": "한국사",
				"smircc12": "생활과 윤리",
				"smircc13": "윤리와 사상",
				"smircc14": "한국지리",
				"smircc15": "세계지리",
				"smircc16": "동아시아사",
				"smircc17": "세계사",
				"smircc18": "경제",
				"smircc19": "정치와 법",
				"smircc20": "사회 문화",
				"smircc21": "물리학1",
				"smircc22": "화학1",
				"smircc23": "생명과학1",
				"smircc24": "지구과학1",
				"smircc25": "물리학2",
				"smircc26": "화학2",
				"smircc27": "생명과학2",
				"smircc28": "지구과학2",
				"smircc29": "성공적인 직업생활",
				"smircc30": "농업 기초 기술",
				"smircc31": "공업 일반",
				"smircc32": "산업 경제",
				"smircc33": "수산 해운 산업 기초",
				"smircc34": "인간 발달",
				"smircc35": "독일어1",
				"smircc36": "프랑스어1",
				"smircc37": "스페인어1",
				"smircc38": "중국어1",
				"smircc39": "일본어1",
				"smircc40": "러시아어1",
				"smircc41": "아랍어1",
				"smircc42": "베트남어1",
				"smircc43": "한문1"
			};
			const text = subjects[event.extendedProps.subject2];
			const select = document.getElementById('smircc');
			select.innerHTML = "";
			if (text) {
				const option = document.createElement('option');
				option.value = event.extendedProps.subject2;
				option.textContent = text;
				select.appendChild(option);
			}
		}
	});


	$('#eventModal').on('hidden.bs.modal', function() {
		if (tempEvent) {
			tempEvent.remove();
			tempEvent = null;
		}
		isModalOpen = false;
	});

	document.getElementById('editButton').addEventListener('click', function() {
		if (currentEvent) {
			const title = document.getElementById('title').value.trim();
			const subject1 = document.getElementById('smjrcc').value;
			const subject2 = document.getElementById('smircc').value;
			const startDate = document.getElementById('startDate').value;
			const startTime = document.getElementById('startTime').value;
			const start = new Date(`${startDate}T${startTime}`);
			const endDate = document.getElementById('endDate').value;
			const endTime = document.getElementById('endTime').value;
			const end = new Date(`${endDate}T${endTime}`);
			const domEndDate = new Date(endDate);
			domEndDate.setDate(domEndDate.getDate() + 1);
			const days = ((end - start) / (1000 * 60 * 60 * 24)) + 1;
			const resultdays = days < 1 ? 1 : days;
			const result = document.getElementById('result').value;
			const userCode = document.getElementById('userId').value;
			const mainKey = document.getElementById('learning').value;
			const subKey = currentEvent.extendedProps.subKey;

			if (startDays[mainKey] > startDate || startDate > EndDays[mainKey]) {
				console.log('실패');
				alert('선택하신 계획이랑 날자가 일치하지 않습니다. 다시 설정해 주세요.');
				return;
			}

			if (end <= start) {
				alert('종료일자와 종료시간은 시작일자와 시작시간보다 늦어야 합니다.');
				return;
			}
			currentEvent.setProp('title', title);
			currentEvent.setExtendedProp('subject1', subject1);
			currentEvent.setExtendedProp('subject2', subject2);
			currentEvent.setStart(start);
			currentEvent.setExtendedProp('days', resultdays);



			if (start.toDateString() !== end.toDateString()) {
				currentEvent.setEnd(domEndDate);
			}
			else {
				currentEvent.setEnd(end);
			}



			$('#eventModal').modal('hide');

			const learningData = {
				learningSchedule: mainKey,
				userCode: userCode,
				smjcc: subject1,
				smicc: subject2,
				learningScheduleStart: startDate,
				learningScheduleEnd: endDate,
				learningScheduleDay: resultdays,
				learningScheduleMemo: title,
				learningScheduleCompleate: result
			};

			const detailData = {
				detailedSchedule: subKey,
				userCode: userCode,
				learningSchedule: mainKey,
				smjrcc: subject1,
				smircc: subject2,
				detailedScheduleMemo: title,
				detailedScheduleDate: startDate,
				detailedScheduleStartTime: startTime,
				detailedScheduleEndTime: endTime,
				detailedScheduleResult: result,
			}



			if (start.toDateString() !== end.toDateString()) {
				$.ajax({
					url: '/study/modifyLearningSchedule', // learning 테이블로 보내는 API URL
					method: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(learningData),

					success: function(response) {
						/*window.location.href = '/study/getLearningScheduleList';*/
						/*console.log('Learning 데이터 저장 성공:', response);
					*/},
					error: function(xhr, status, error) {
						/*console.error('Learning 데이터 저장 실패:', error);
					*/}
				});



			}

			else {
				console.log(startDays[mainKey] > startDate);
				console.log(EndDays[mainKey] < startDate);

				$.ajax({
					url: '/study/modifyDetailedSchedule', // detail 테이블로 보내는 API URL
					method: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(detailData),
					success: function(response) {
						/*window.location.href = '/study/getLearningScheduleList';
						*//*console.log('Detail 데이터 저장 성공:', response);
					*/},
					error: function(xhr, status, error) {
						/*console.error('Detail 데이터 저장 실패:', error);
					*/}
				});
			}
		}
	});




	document.getElementById('deleteButton').addEventListener('click', function() {
		if (currentEvent) {
			const startDate = document.getElementById('startDate').value;
			const startTime = document.getElementById('startTime').value;
			const start = new Date(`${startDate}T${startTime}`);
			const endDate = document.getElementById('endDate').value;
			const endTime = document.getElementById('endTime').value;
			const end = new Date(`${endDate}T${endTime}`);
			const mainKey = currentEvent.extendedProps.mainKey;
			const subKey = currentEvent.extendedProps.subKey;
			const learningData = {
				learningSchedule: mainKey,
			}
			const detailData = {
				detailedSchedule: subKey,
			}



			if (start.toDateString() !== end.toDateString()) {
				$.ajax({
					url: '/study/removeLearningSchedule', // learning 테이블로 보내는 API URL
					method: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(learningData),

					success: function(response) {
						/*window.location.href = '/study/getLearningScheduleList';*/
						/*console.log('Learning 데이터 저장 성공:', response);
					*/},
					error: function(xhr, status, error) {
						/*console.error('Learning 데이터 저장 실패:', error);
					*/}
				});



			} else {

				$.ajax({
					url: '/study/removeDetailedSchedule', // detail 테이블로 보내는 API URL
					method: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(detailData),
					success: function(response) {
						/*window.location.href = '/study/getLearningScheduleList';
						*//*console.log('Detail 데이터 저장 성공:', response);*/

					},
					error: function(xhr, status, error) {
						/*console.error('Detail 데이터 저장 실패:', error);*/
					}

				});
			}

			currentEvent.remove();
			$('#eventModal').modal('hide');
			document.getElementById('title').value = null;
			document.getElementById('smjrcc').value = null;
			document.getElementById('smircc').value = null;
			document.getElementById('days').value = null;
			currentEvent = null;
		}


	});

	calendar.render();
});