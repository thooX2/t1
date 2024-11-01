let currentEvent = null;
let tempEvent = null; // 임시 이벤트
let isModalOpen = false; // 모달 상태 변수
let startDays = {}; // 각 계획별 날자의 시작점 저장 변수
let EndDays = {}; // 계획별 종료일의 종료 변수

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
				const compleate = (item.compleateMemo).substring(0, 3);
				const detail = item.result !== null ? (item.result).substring(0, 3) : item.result;
				if (compleate === '미달성') {
					item.compleateMemo = '진행중 : 현재 진행중인 상태 입니다.';
				}
				if (detail === '미달성') {
					item.result = '진행중 : 현재 진행중인 상태 입니다.';
				}
				if(item.fullSchedule !== null){
					startDays[item.fullSchedule] = item.startDay;
					EndDays[item.fullSchedule] = item.endDay;	
										
				}

				endDays.setDate(endDays.getDate() + 1);
				if (item.detailed === null) {
					currentEvent = calendar.addEvent({
						title: item.lesMemo,
						mainKey: item.fullSchedule,
						subKey: item.detailed,
						subject1: item.submjr,
						subject2: item.submir,
						start: item.startDay,
						end: endDays,
						days: item.days,
						startDays : item.startDay,
						endDays : endDays,
						allDay: true,
						extendedProps: {
							result: item.compleateMemo
						}
					});
				}
				if (item.detailed !== null) {
					const startday = new Date(`${item.detailDate}T${item.startTime}`);
					const endday = new Date(`${item.detailDate}T${item.endTime}`);
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
			const days = (endDate - startDate) / (1000 * 60 * 60 * 24);
			const resultdays = days < 1 ? 1 : days;

			document.getElementById('startDate').value = startDateOnly;
			document.getElementById('startTime').value = startDate.toTimeString().split(' ')[0].slice(0, 5);
			document.getElementById('endDate').value = endDate.toISOString().split('T')[0];
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

			if (document.getElementById('endDate').value !== document.getElementById('startDate').value) {
				document.getElementById('learning').removeAttribute('required');
			}
			else {
				document.getElementById('learning').setAttribute('required', true);
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
				
				// 유효성 검사
				if (end <= start) {
					alert('종료일자와 종료시간은 시작일자와 시작시간보다 늦어야 합니다.');
					return;
				}

				if (!title) {
					alert('제목을 입력해야 합니다.');
					return;
				}

				//공통으로 들어가는 코드 부분
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


			document.getElementById('startDate').value = eventDateOnly;
			document.getElementById('startTime').value = event.start.toTimeString().split(' ')[0].slice(0, 5);


			if (document.getElementById('endDate').value !== document.getElementById('startDate').value) {

				document.getElementById('learning').removeAttribute('required');
			}
			else {
				document.getElementById('learning').setAttribute('required', true);
			}

			if (event.end == null) {
				document.getElementById('endDate').value = eventDateOnly;
				document.getElementById('endTime').avlue = event.start.toTimeString().split(' ')[0].slice(0, 5)
			}

			else {
				document.getElementById('endDate').value = event.end.toISOString().split('T')[0];
				document.getElementById('endTime').value = event.end.toTimeString().split(' ')[0].slice(0, 5);
			}



			document.getElementById('days').value = event.extendedProps.days;
			$('#eventModal').modal('show');

			document.getElementById('learning').addEventListener('change', function(){
				console.log("변화한 후 값 확인"+ document.getElementById('learning').value);
			});
			
			

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
			console.log(mainKey);
			console.log(startDays[mainKey]);
			console.log(EndDays[mainKey]);
					
			



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
			if(startDays[mainKey] >  startDate ||  startDate > EndDays[mainKey]) {
				console.log(실패);
				alert('선택하신 계획이랑 날자가 일치하지 않습니다. 다시 설정해 주세요.');
			}
			else {
				console.log(startDays[mainKey] >  startDate);
				console.log(EndDays[mainKey] <  startDate);
				
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