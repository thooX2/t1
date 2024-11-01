let currentEvent = null;
let tempEvent = null; // 임시 이벤트
let isModalOpen = false; // 모달 상태 변수
$('#eventModal').modal('hide');

document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
	
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
            $('#eventModal').modal('show');
        },
        select: function(info) {
            const startDate = new Date(info.start);
            const endDate = new Date(info.end);
            const startYear = startDate.getFullYear();
            const startMonth = String(startDate.getMonth() + 1).padStart(2, '0');
            const startDay = String(startDate.getDate()).padStart(2, '0');
            const startDateOnly = `${startYear}-${startMonth}-${startDay}`;

            document.getElementById('startDate').value = startDateOnly;
            document.getElementById('startTime').value = startDate.toTimeString().split(' ')[0].slice(0, 5);
			
            document.getElementById('endDate').value = endDate.toISOString().split('T')[0];
			console.log("실험1번" +  document.getElementById('endDate').value);
            document.getElementById('endTime').value = '23:59';
			console.log("실험1번" +  document.getElementById('endDate').value);
			console.log("시간 실험1번" +  document.getElementById('endTime').value);
            tempEvent = calendar.addEvent({
                title: '',
                start: info.start,
                end: info.end,
                allDay: false,
                rendering: 'background',
                color: 'rgba(0, 123, 255, 0.2)',
                editable: false
            });

            isModalOpen = true; 
            $('#eventModal').modal('show');

            document.getElementById('eventForm').onsubmit = function(e) {
                e.preventDefault();
                const title = document.getElementById('title').value.trim();
                const startDate = document.getElementById('startDate').value;
                const startTime = document.getElementById('startTime').value;
                const endDate = document.getElementById('endDate').value;
                const endTime = document.getElementById('endTime').value;
                const memo = document.getElementById('memo').value;
                const start = new Date(`${startDate}T${startTime}`);
                const end = new Date(`${endDate}T${endTime}`);

				
                if (end <= start) {
                    alert('종료일자와 종료시간은 시작일자와 시작시간보다 늦어야 합니다.');
                    return;
                }

                if (!title) {
                    alert('제목을 입력해야 합니다.');
                    return;
                }

                if (currentEvent) {
                    currentEvent.setProp('title', title);
                    currentEvent.setStart(start);
                    currentEvent.setEnd(end);
                    currentEvent.setExtendedProp('memo', memo);
                } else {
                    currentEvent = calendar.addEvent({
                        title: title,
                        start: start,
                        end: end,
                        allDay: false,
                        extendedProps: { memo: memo }
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
            const event = info.event;
            currentEvent = event;

            document.getElementById('title').value = event.title;
            const eventYear = event.start.getFullYear();
            const eventMonth = String(event.start.getMonth() + 1).padStart(2, '0');
            const eventDay = String(event.start.getDate()).padStart(2, '0');
            const eventDateOnly = `${eventYear}-${eventMonth}-${eventDay}`;

            document.getElementById('startDate').value = eventDateOnly;
            document.getElementById('startTime').value = event.start.toTimeString().split(' ')[0].slice(0, 5);
            document.getElementById('endDate').value = event.end.toISOString().split('T')[0];
			
            document.getElementById('endTime').value = event.end.toTimeString().split(' ')[0].slice(0, 5);
            document.getElementById('memo').value = event.extendedProps.memo || '';

            $('#eventModal').modal('show');
        }
    });

    $('#eventModal').on('hidden.bs.modal', function () {
        if (tempEvent) {
            tempEvent.remove();
            tempEvent = null;
        }
        isModalOpen = false;
    });

    document.getElementById('deleteButton').addEventListener('click', function() {
        if (currentEvent) {
            currentEvent.remove();
            $('#eventModal').modal('hide');
            currentEvent = null;
        }
    });

    calendar.render();
});