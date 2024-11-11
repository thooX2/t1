/*$('#deletebutton').on('click', function() {
  console.log("버튼 클릭 실행");
   $.ajax({
     url: '/admin/study/modal',  // 서버 경로
     method: 'GET',
     success: function(data) {
       // 서버에서 받은 경로 값 (예: data.path)
       console.log("로딩 성공");
     },
     error: function(error) {
	   console.log("실패");
       console.error('Error fetching data:', error);
     }
   });
 });*/
 
 document.getElementById('deleteButton').addEventListener('click', function() {
     // 모달 내에 설정할 itemId 값을 동적으로 설정
     document.getElementById('itemId').value = 'item123';  // 예시로 'item123' ID 값 설정
     $('#eventModal').modal('show');  // 모달을 보이게 함
 });

 // 취소 버튼 클릭 시 모달 닫기 및 값 초기화
 document.getElementById('cancelButton').addEventListener('click', function() {
     // 폼 데이터 초기화
     document.getElementById('itemId').value = '';  // itemId 값 초기화
     // 페이지 리로드
     location.reload();  // 페이지 리로드
 });

 // 폼 제출 후 페이지 리로드 (삭제 버튼 클릭 시)
 document.getElementById('deleteForm').addEventListener('submit', function(event) {
     // 페이지 리로드 전에 폼을 제출
     event.preventDefault();  // 기본 제출을 막고

     // 폼을 제출
     this.submit();  // 폼 제출

     // 폼 제출 후 페이지 리로드
     location.reload();  // 페이지를 새로고침
 });