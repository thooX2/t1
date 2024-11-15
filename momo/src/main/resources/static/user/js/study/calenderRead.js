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
				console.log(item);
				const endDays = new Date(item.endDay);
				const compleate = (item.compleateMemo).substring(0, 3);
				const detail = item.result !== null ? (item.result).substring(0, 3) : item.result;

				// 상태 메시지 처리
				item.compleateMemo = compleate === '미달성' ? '진행중 : 현재 진행중인 상태 입니다.' : item.compleateMemo;
				item.result = detail === '미달성' ? '진행중 : 현재 진행중인 상태 입니다.' : item.result;

				// fullSchedule이 있을 경우 날짜 저장
				if (item.fullSchedule !== null) {
					startDays[item.fullSchedule] = item.startDay;
					EndDays[item.fullSchedule] = item.endDay;
				}

				// 공통된 이벤트 추가 함수로 리팩토링
				function addEventToCalendar(title, mainKey, subKey, subject1, subject2, start, end, allDay, result) {
					return calendar.addEvent({
						title: title,
						mainKey: mainKey,
						subKey: subKey,
						subject1: subject1,
						subject2: subject2,
						start: start,
						end: end,
						days: item.days,
						startDays: item.startDay,
						endDays: endDays,
						allDay: allDay,
						extendedProps: {
							result: result
						}
					});
				}

				// EndDays 수정
				endDays.setDate(endDays.getDate() + 1);

				// fullSchedule에 대한 이벤트 처리
				if (item.fullSchedule !== null && !Event.has(item.fullSchedule)) {
					Event.add(item.fullSchedule);
					addEventToCalendar(
						item.lesMemo,
						item.fullSchedule,
						item.detailed,
						item.mainmjr,
						item.mainmir,
						item.startDay,
						endDays,
						true,
						item.compleateMemo
					);
				}

				// detailed에 대한 이벤트 처리
				if (item.detailed !== null) {
					const startday = new Date(`${item.detailDate}T${item.startTime}`);
					const endday = new Date(`${item.detailDate}T${item.endTime}`);
					addEventToCalendar(
						item.detailMemo,
						item.fullSchedule,
						item.detailed,
						item.submjr,
						item.submir,
						startday,
						endday,
						false,
						item.result
					);
				}
			});
		},
		error: function(xhr, status, error) {
			alert("오류가 발생했습니다. 문제가 유지될 경우 관리자에게 연락해 주세요.")
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
			const titleInput = document.getElementById('title');
			const smjrccInput = document.getElementById('smjrcc');
			const smirccInput = document.getElementById('smircc');

			titleInput.value = null;
			smjrccInput.value = null;
			smirccInput.value = null;
			$('#eventModal').modal('show');
		},

		select: function(info) {
			const saveButton = document.getElementById('save');
			const editButton = document.getElementById('editButton');
			const titleInput = document.getElementById('title');
			const smjrccInput = document.getElementById('smjrcc');
			const smirccInput = document.getElementById('smircc');
			const startDateInput = document.getElementById('startDate');
			const startTimeInput = document.getElementById('startTime');
			const endDateInput = document.getElementById('endDate');
			const endTimeInput = document.getElementById('endTime');
			const daysInput = document.getElementById('days');
			const resultType = document.getElementById('result');
			const selectName = document.getElementById('selectName');
			const endTimer = document.getElementById('endTimer');
			const startTimer = document.getElementById('startTimer');
			const endDays = document.getElementById('endDays');
			const eventModalLabel = document.getElementById('eventModalLabel');

			saveButton.style.display = '';
			editButton.style.display = 'none';
			titleInput.value = null;
			smjrccInput.value = null;
			smirccInput.value = null;

			const startDate = new Date(info.start);
			const endDate = new Date(info.end);
			const startYear = startDate.getFullYear();
			const startMonth = String(startDate.getMonth() + 1).padStart(2, '0');
			const startDay = String(startDate.getDate()).padStart(2, '0');
			const startDateOnly = `${startYear}-${startMonth}-${startDay}`;

			const endYear = endDate.getFullYear();
			const endMonth = String(endDate.getMonth() + 1).padStart(2, '0');
			let endDay = String(endDate.getDate()).padStart(2, '0');
			if (startDay !== endDay) {
				endDay = String(endDate.getDate() - 1).padStart(2, '0');
			}
			const endOnly = `${endYear}-${endMonth}-${endDay}`;
			const days = (endDate - startDate) / (1000 * 60 * 60 * 24);
			const resultdays = days < 1 ? 1 : days;

			startDateInput.value = startDateOnly;
			startTimeInput.value = startDate.toTimeString().split(' ')[0].slice(0, 5);
			endDateInput.value = endOnly;
			endTimeInput.value = endDate.toTimeString().split(' ')[0].slice(0, 5);

			daysInput.value = resultdays;

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

			if (endDateInput.value !== startDateInput.value) {
				selectName.style.display = 'none';
				endTimer.style.display = 'none';
				startTimer.style.display = 'none';
				endDays.style.display = '';
				eventModalLabel.textContent = "학습계획 생성";
			} else {
				eventModalLabel.textContent = "세부계획 생성";
				selectName.style.display = '';
				endTimer.style.display = '';
				startTimer.style.display = '';
				endDays.style.display = 'none';
			}

			document.getElementById('eventForm').onsubmit = function(e) {
				e.preventDefault();
				const userCode = document.getElementById('userId').value;
				const title = titleInput.value.trim();
				const subject1 = smjrccInput.value;
				const subject2 = smirccInput.value;
				const startDate = startDateInput.value;
				const startTime = startTimeInput.value;
				const endDate = endDateInput.value;
				const endTime = endTimeInput.value;
				const start = new Date(`${startDate}T${startTime}`);
				const end = new Date(`${endDate}T${endTime}`);
				const domEndDate = new Date(endDate);
				domEndDate.setDate(domEndDate.getDate() + 1);
				const days = ((end - start) / (1000 * 60 * 60 * 24)) + 1;
				const resultdays = days < 1 ? 1 : days;
				const result = document.getElementById('result').value;
				const learning = document.getElementById('learning').value;

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
				};

				// 시작일자와 종료일자 비교
				if (start.toDateString() !== end.toDateString()) {
					$.ajax({
						url: '/study/addLearningSchedule', // learning 테이블로 보내는 API URL
						method: 'POST',
						contentType: 'application/json',
						data: JSON.stringify(learningData),

						success: function(response) {
							alert(response);
							window.location.href = '/study/getLearningScheduleList';
						},

						error: function(xhr, status, error) {
							alert('학습 계획 생성에 실패하셨습니다.\n관리자에게 문의해 주세요.');
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

				} else {
					if (startDays[mainKey] > startDate || startDate > EndDays[mainKey]) {
						alert('선택하신 계획이랑 날자가 일치하지 않습니다. 다시 설정해 주세요.');
						return;
					}
					if (learning === 'null') {
						alert('계획을 선택해 주셔야 합니다.');
						return;
					}

					$.ajax({
						url: '/study/addDetailedSchedule', // detail 테이블로 보내는 API URL
						method: 'POST',
						contentType: 'application/json',
						data: JSON.stringify(detailData),
						success: function(response) {
							alert(response);
							window.location.href = '/study/getLearningScheduleList';
						},
						error: function(xhr, status, error) {
							alert('세부 게획 생성에 실패하셨습니다.\n관리자에게 문의해 주세요.');
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
			const resultType = document.getElementById('result');
			const event = info.event;
			const endDate = document.getElementById('endDate').value;
			const domEndDate = new Date(endDate);
			domEndDate.setDate(domEndDate.getDate() + 1);

			currentEvent = event;

			resultType.value = event.extendedProps.result;

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
				document.getElementById('endDate').value = endOnly
				document.getElementById('endTime').value = event.end.toTimeString().split(' ')[0].slice(0, 5);
			}





			document.getElementById('days').value = event.extendedProps.days;
			$('#eventModal').modal('show');

			document.getElementById('nmSmircc').textContent = "선택된 과목 입니다. (변경을 원하실 경우 과목을 다시 선택해 주세요.)";


			if (eventDay !== endDay) {
				document.getElementById('selectName').style.display = 'none';
				document.getElementById('endTimer').style.display = 'none';
				document.getElementById('startTimer').style.display = 'none';
				document.getElementById('endDays').style.display = '';
				eventModalLabel
				document.getElementById('eventModalLabel').textContent = "학습계획 생성";

			}
			else {
				document.getElementById('eventModalLabel').textContent = "세부계획 생성";
				document.getElementById('selectName').style.display = '';
				document.getElementById('endTimer').style.display = '';
				document.getElementById('startTimer').style.display = '';
				document.getElementById('endDays').style.display = 'none';
					/*document.getElementById('learning') = event.extendedProps.mainKey;*/
				
			}

			const subjects = {
				"smircc1": "언어와 매체",
				"smircc2": "언어와 매체",
				"smircc3": "언어와 매체",
				"smircc4": "언어와 매체",
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
			const endDate = document.getElementById('endDate').value;
			const endTime = document.getElementById('endTime').value;
			const domEndDate = new Date(endDate);
			const result = document.getElementById('result').value;
			const userCode = document.getElementById('userId').value;
			const mainKey = currentEvent.extendedProps.mainKey;
			const subKey = currentEvent.extendedProps.subKey;

			const end = new Date(`${endDate}T${endTime}`);
			const start = new Date(`${startDate}T${startTime}`);
			domEndDate.setDate(domEndDate.getDate() + 1);

			const days = Math.round(((end - start) / (1000 * 60 * 60 * 24)) + 1);
			const resultdays = days < 1 ? 1 : days;
			if (end <= start) {
				alert('종료일자와 종료시간은 시작일자와 시작시간보다 늦어야 합니다.');
				return;
			}
			currentEvent.setProp('title', title);
			currentEvent.setExtendedProp('subject1', subject1);
			currentEvent.setExtendedProp('subject2', subject2);
			currentEvent.setStart(start);
			currentEvent.setExtendedProp('days', resultdays);

			console.log("과목 1번" + subject1);
			console.log("과목 2번" + subject2);


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
						alert(response);
						window.location.href = '/study/getLearningScheduleList';
					},
					error: function(xhr, status, error) {
						alert('학습 계획 수정에 실패하셨습니다.\n관리자에게 문의해 주세요.');
					}
				});



			}

			else {
				if (startDays[mainKey] > startDate || startDate > EndDays[mainKey]) {
					alert('선택하신 계획이랑 날자가 일치하지 않습니다. 다시 설정해 주세요.');
					return;
				}
				if (mainKey === 'null') {
					alert('계획 선택해 주셔야 합니다.');
					return;

				}

				$.ajax({
					url: '/study/modifyDetailedSchedule', // detail 테이블로 보내는 API URL
					method: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(detailData),
					success: function(response) {
						alert(response);
						window.location.href = '/study/getLearningScheduleList';
					},
					error: function(xhr, status, error) {
						alert('세부 계획 수정에 실패하셨습니다.\n관리자에게 문의해 주세요.');
					}
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
			const userData = document.getElementById('userId').value;
			const learningData = {
				learningSchedule: mainKey,
				userCode: userData
			}
			const detailData = {
				detailedSchedule: subKey,

			}

			if (start.toDateString() !== end.toDateString()) {
				alert('삭제시 해당 계획과 관련된 모든 데이터가 소멸합니다. 그래도 괜찮으시겠습니까?');
				$.ajax({
					url: '/study/removeLearningSchedule', // learning 테이블로 보내는 API URL
					method: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(learningData),

					success: function(response) {
						alert(response);
						window.location.href = '/study/getLearningScheduleList';
					},
					error: function(xhr, status, error) {
						alert('학습 계획 삭제에 실패하셨습니다.\n관리자에게 문의해 주세요.');
					}
				});



			} else {
				alert('세부 계획 데이터 삭제가 진행됩니다.');
				$.ajax({
					url: '/study/removeDetailedSchedule', // detail 테이블로 보내는 API URL
					method: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(detailData),
					success: function(response) {
						alert(response);
						window.location.href = '/study/getLearningScheduleList';
					},
					error: function(xhr, status, error) {
						alert('세부 계획 삭제에 실패하셨습니다.\n관리자에게 문의해 주세요.');
					}

				});
			}

			//삭제후 페이지 및 값을 초기화.
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