/* document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('smjrcc').addEventListener('change', function() {
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
                { value: "smircc3", text: "화법과 작문"},
				{ value: "smircc3", text: "언어와 매체"}
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
		else if (selectedSubject === "smjrcc3"){
			options = [
				{ value : "smircc10", text: "영어1"},
				{ value : "smircc11", text: "영어1"}
			]
			
		}
		else if (selectedSubject === "smjrcc4"){
			options = [
				{ value : "null", text: "한국사"}
			]
		}
		else if (selectedSubject === "smjrcc5"){
			options = [
				{ value : "smircc12", text: "생활과 윤리"},
				{ value : "smircc13", text: "윤리와 사상"},
				{ value : "smircc14", text: "한국지리"},
				{ value : "smircc15", text: "세계지리"},
				{ value : "smircc16", text: "동아시아사"},
				{ value : "smircc17", text: "세계사"},
				{ value : "smircc18", text: "경제"},
				{ value : "smircc19", text: "정치와 법"},
				{ value : "smircc20", text: "사회 문화"}
			]
			
		}
		else if (selectedSubject === "smjrcc6"){
			options = [
				{ value : "smircc21", text: "물리학1"},
				{ value : "smircc22", text: "화학1"},
				{ value : "smircc23", text: "생명과학1"},
				{ value : "smircc24", text: "지구과학1"},
				{ value : "smircc25", text: "물리학2"},
				{ value : "smircc26", text: "화학2"},
				{ value : "smircc27", text: "생명과학2"},
				{ value : "smircc28", text: "지구과학2"}
			]
			
		}
		else if (selectedSubject === "smjrcc7"){
			options = [
				{ value : "smircc29", text: "성공적인 직업생활"},
				{ value : "smircc30", text: "농업 기초 기술"},
				{ value : "smircc31", text: "공업 일반"},
				{ value : "smircc32", text: "산업 경제"},
				{ value : "smircc33", text: "수산 해운 산업 기초"},
				{ value : "smircc34", text: "인간 발달"}
			]
			
		}
		else if (selectedSubject === "smjrcc8"){
			options = [
				{ value : "smircc35", text: "독일어1"},
				{ value : "smircc36", text: "프랑스어1"},
				{ value : "smircc37", text: "스페인어1"},
				{ value : "smircc38", text: "중국어1"},
				{ value : "smircc39", text: "일본어1"},
				{ value : "smircc40", text: "러시아어1"},
				{ value : "smircc41", text: "아랍어1"},
				{ value : "smircc42", text: "베트남어1"},
				{ value : "smircc43", text: "한문1"}
								
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
});*/