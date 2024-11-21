/**
 * 
 */
if (tookExamList == null) {
	alert("응시한 모의고사가 없습니다. 모의고사 페이지로 이동합니다.");
	setTimeout(function() {
		location.href = "/exam/examList";
	}, 0);
}
else {
	let koreanScore = subjectScore['koreanScore'];
	let mathScore = subjectScore['mathScore'];
	let englishScore = subjectScore['englishScore'];
	let koreanHistoryScore = subjectScore['koreanHistoryScore'];
	let inquiry1Score = subjectScore['inquiry1Score'];
	let inquiry2Score = subjectScore['inquiry2Score'];
	let secondLanguageAndChineseCharactersScore = subjectScore['secondLanguageAndChineseCharactersScore'];

	const updateChart = function(chartName, chartType) {
		chartName.config.data.datasets[0].label = `${chartType} 전국 평균`;
		chartName.config.data.datasets[1].label = `${chartType} 도 평균`;
		chartName.config.data.datasets[2].label = `${chartType} 시 평균`;
		chartName.config.data.datasets[3].label = `${chartType}`;
		if (chartType == '원점수') {
			chartName.config.data.datasets[0].data = [koreanScore?.subjectOriginalScoreNationAvg ?? 0.0,
			mathScore?.subjectOriginalScoreNationAvg ?? 0.0,
			englishScore?.subjectOriginalScoreNationAvg ?? 0.0,
			koreanHistoryScore?.subjectOriginalScoreNationAvg ?? 0.0,
			inquiry1Score?.subjectOriginalScoreNationAvg ?? 0.0,
			inquiry2Score?.subjectOriginalScoreNationAvg ?? 0.0,
			secondLanguageAndChineseCharactersScore?.subjectOriginalScoreNationAvg ?? 0.0];
			const areaCode = user.areaCityCode.substring(0, 2);
			if(areaCode=='11' || areaCode=='26' || areaCode=='27' || areaCode=='28' ||
			   areaCode=='29' || areaCode=='30' || areaCode=='31' || areaCode=='36') {
				chartName.config.data.datasets[1].data = null;                                   
			}
			else {
				chartName.config.data.datasets[1].data = [koreanScore?.subjectOriginalScoreProvinceAvg ?? 0.0,
				mathScore?.subjectOriginalScoreProvinceAvg ?? 0.0,
				englishScore?.subjectOriginalScoreProvinceAvg ?? 0.0,
				koreanHistoryScore?.subjectOriginalScoreProvinceAvg ?? 0.0,
				inquiry1Score?.subjectOriginalScoreProvinceAvg ?? 0.0,
				inquiry2Score?.subjectOriginalScoreProvinceAvg ?? 0.0,
				secondLanguageAndChineseCharactersScore?.subjectOriginalScoreProvinceAvg ?? 0.0];
			}
			chartName.config.data.datasets[2].data = [koreanScore?.subjectOriginalScoreMunicipalityAvg ?? 0.0,
			mathScore?.subjectOriginalScoreMunicipalityAvg ?? 0.0,
			englishScore?.subjectOriginalScoreMunicipalityAvg ?? 0.0,
			koreanHistoryScore?.subjectOriginalScoreMunicipalityAvg ?? 0.0,
			inquiry1Score?.subjectOriginalScoreMunicipalityAvg ?? 0.0,
			inquiry2Score?.subjectOriginalScoreMunicipalityAvg ?? 0.0,
			secondLanguageAndChineseCharactersScore?.subjectOriginalScoreMunicipalityAvg ?? 0.0];
			chartName.config.data.datasets[3].data = [koreanScore?.subjectOriginalScore ?? 0.0,
			mathScore?.subjectOriginalScore ?? 0.0,
			englishScore?.subjectOriginalScore ?? 0.0,
			koreanHistoryScore?.subjectOriginalScore ?? 0.0,
			inquiry1Score?.subjectOriginalScore ?? 0.0,
			inquiry2Score?.subjectOriginalScore ?? 0.0,
			secondLanguageAndChineseCharactersScore?.subjectOriginalScore ?? 0.0];
			chartName.config.options.scales.y.min = 0;
			chartName.config.options.scales.y.max = 100;
			chartName.config.options.scales.y.ticks.beginAtZero = true;
			chartName.config.options.scales.y.ticks.stepSize = 10;
			chartName.config.options.scales.y.ticks.callback = value => value;
			chartName.config.options.plugins.tooltip['callbacks'] = {
				label: function(ctx) {
					let lbl = Math.round((ctx.raw) * 10) / 10 ?? '응시안함';
					return `${ctx.dataset.label} : ${lbl}점`;
				}
			}
		} else if (chartType == '표준점수') {
			chartName.config.data.datasets[0].data = [koreanScore?.subjectStandardScoreNationAvg ?? 0.0,
			mathScore?.subjectStandardScoreNationAvg ?? 0.0,
			englishScore?.subjectStandardScoreNationAvg ?? 0.0,
			koreanHistoryScore?.subjectStandardScoreNationAvg ?? 0.0,
			inquiry1Score?.subjectStandardScoreNationAvg ?? 0.0,
			inquiry2Score?.subjectStandardScoreNationAvg ?? 0.0,
			secondLanguageAndChineseCharactersScore?.subjectStandardScoreNationAvg ?? 0.0];
			const areaCode = user.areaCityCode.substring(0, 2);
			if(areaCode=='11' || areaCode=='26' || areaCode=='27' || areaCode=='28' ||
			   areaCode=='29' || areaCode=='30' || areaCode=='31' || areaCode=='36') {
				chartName.config.data.datasets[1].data = null;                                   
			}
			else {
				chartName.config.data.datasets[1].data = [koreanScore?.subjectStandardScoreProvinceAvg ?? 0.0,
				mathScore?.subjectStandardScoreProvinceAvg ?? 0.0,
				englishScore?.subjectStandardScoreProvinceAvg ?? 0.0,
				koreanHistoryScore?.subjectStandardScoreProvinceAvg ?? 0.0,
				inquiry1Score?.subjectStandardScoreProvinceAvg ?? 0.0,
				inquiry2Score?.subjectStandardScoreProvinceAvg ?? 0.0,
				secondLanguageAndChineseCharactersScore?.subjectStandardScoreProvinceAvg ?? 0.0];
			}
			chartName.config.data.datasets[2].data = [koreanScore?.subjectStandardScoreMunicipalityAvg ?? 0.0,
			mathScore?.subjectStandardScoreMunicipalityAvg ?? 0.0,
			englishScore?.subjectStandardScoreMunicipalityAvg ?? 0.0,
			koreanHistoryScore?.subjectStandardScoreMunicipalityAvg ?? 0.0,
			inquiry1Score?.subjectStandardScoreMunicipalityAvg ?? 0.0,
			inquiry2Score?.subjectStandardScoreMunicipalityAvg ?? 0.0,
			secondLanguageAndChineseCharactersScore?.subjectStandardScoreMunicipalityAvg ?? 0.0];
			chartName.config.data.datasets[3].data = [koreanScore?.subjectStandardScore ?? 0.0,
			mathScore?.subjectStandardScore ?? 0.0,
			englishScore?.subjectStandardScore ?? 0.0,
			koreanHistoryScore?.subjectStandardScore ?? 0.0,
			inquiry1Score?.subjectStandardScore ?? 0.0,
			inquiry2Score?.subjectStandardScore ?? 0.0,
			secondLanguageAndChineseCharactersScore?.subjectStandardScore ?? 0.0];
			chartName.config.options.scales.y.min = 0;
			chartName.config.options.scales.y.max = 150;
			chartName.config.options.scales.y.ticks.beginAtZero = true;
			chartName.config.options.scales.y.ticks.stepSize = 10;
			chartName.config.options.scales.y.ticks.callback = value => value;
			chartName.config.options.plugins.tooltip['callbacks'] = {
				label: function(ctx) {
					let lbl = Math.round((ctx.raw) * 10) / 10 ?? '응시안함';
					return `${ctx.dataset.label} : ${lbl}점`;
				}
			}
		} else if (chartType == '백분위') {
			chartName.config.data.datasets[0].data = [koreanScore?.subjectPercentNationAvg ?? 0.0,
			mathScore?.subjectPercentNationAvg ?? 0.0,
			englishScore?.subjectPercentNationAvg ?? 0.0,
			koreanHistoryScore?.subjectPercentNationAvg ?? 0.0,
			inquiry1Score?.subjectPercentNationAvg ?? 0.0,
			inquiry2Score?.subjectPercentNationAvg ?? 0.0,
			secondLanguageAndChineseCharactersScore?.subjectPercentNationAvg ?? 0.0];
			const areaCode = user.areaCityCode.substring(0, 2);
			if(areaCode=='11' || areaCode=='26' || areaCode=='27' || areaCode=='28' ||
			   areaCode=='29' || areaCode=='30' || areaCode=='31' || areaCode=='36') {
				chartName.config.data.datasets[1].data = null;                                   
			}
			else {
				chartName.config.data.datasets[1].data = [koreanScore?.subjectPercentProvinceAvg ?? 0.0,
				mathScore?.subjectPercentProvinceAvg ?? 0.0,
				englishScore?.subjectPercentProvinceAvg ?? 0.0,
				koreanHistoryScore?.subjectPercentProvinceAvg ?? 0.0,
				inquiry1Score?.subjectPercentProvinceAvg ?? 0.0,
				inquiry2Score?.subjectPercentProvinceAvg ?? 0.0,
				secondLanguageAndChineseCharactersScore?.subjectPercentProvinceAvg ?? 0.0];
			}
			chartName.config.data.datasets[2].data = [koreanScore?.subjectPercentMunicipalityAvg ?? 0.0,
			mathScore?.subjectPercentMunicipalityAvg ?? 0.0,
			englishScore?.subjectPercentMunicipalityAvg ?? 0.0,
			koreanHistoryScore?.subjectPercentMunicipalityAvg ?? 0.0,
			inquiry1Score?.subjectPercentMunicipalityAvg ?? 0.0,
			inquiry2Score?.subjectPercentMunicipalityAvg ?? 0.0,
			secondLanguageAndChineseCharactersScore?.subjectPercentMunicipalityAvg ?? 0.0];
			chartName.config.data.datasets[3].data = [koreanScore?.subjectPercent ?? 0.0,
			mathScore?.subjectPercent ?? 0.0,
			englishScore?.subjectPercent ?? 0.0,
			koreanHistoryScore?.subjectPercent ?? 0.0,
			inquiry1Score?.subjectPercent ?? 0.0,
			inquiry2Score?.subjectPercent ?? 0.0,
			secondLanguageAndChineseCharactersScore?.subjectPercent ?? 0.0];
			chartName.config.options.scales.y.min = 0;
			chartName.config.options.scales.y.max = 100;
			chartName.config.options.scales.y.ticks.beginAtZero = true;
			chartName.config.options.scales.y.ticks.stepSize = 10;
			chartName.config.options.scales.y.ticks.callback = value => value;
			chartName.config.options.plugins.tooltip['callbacks'] = {
				label: function(ctx) {
					let lbl = Math.round((ctx.raw) * 10) / 10 ?? '응시안함';
					return `${ctx.dataset.label} : ${lbl}%`;
				}
			}
		} else if (chartType == '등급') {
			chartName.config.data.datasets[0].data = [10 - (koreanScore?.subjectGradeNationAvg ?? 9.0),
			10 - (mathScore?.subjectGradeNationAvg ?? 9.0),
			10 - (englishScore?.subjectGradeNationAvg ?? 9.0),
			10 - (koreanHistoryScore?.subjectGradeNationAvg ?? 9.0),
			10 - (inquiry1Score?.subjectGradeNationAvg ?? 9.0),
			10 - (inquiry2Score?.subjectGradeNationAvg ?? 9.0),
			10 - (secondLanguageAndChineseCharactersScore?.subjectGradeNationAvg ?? 9.0)];
			const areaCode = user.areaCityCode.substring(0, 2);
			console.log(areaCode);
			if(areaCode=='11' || areaCode=='26' || areaCode=='27' || areaCode=='28' ||
			   areaCode=='29' || areaCode=='30' || areaCode=='31' || areaCode=='36') {
				chartName.config.data.datasets[1].data = null;                                   
			}
			else {
				console.log("aaa");
				chartName.config.data.datasets[1].data = [10 - (koreanScore?.subjectGradeProvinceAvg ?? 9.0),
				10 - (mathScore?.subjectGradeProvinceAvg ?? 9.0),
				10 - (englishScore?.subjectGradeProvinceAvg ?? 9.0),
				10 - (koreanHistoryScore?.subjectGradeProvinceAvg ?? 9.0),
				10 - (inquiry1Score?.subjectGradeProvinceAvg ?? 9.0),
				10 - (inquiry2Score?.subjectGradeProvinceAvg ?? 9.0),
				10 - (secondLanguageAndChineseCharactersScore?.subjectGradeProvinceAvg ?? 9.0)];
			}
			chartName.config.data.datasets[2].data = [10 - (koreanScore?.subjectGradeMunicipalityAvg ?? 9.0),
			10 - (mathScore?.subjectGradeMunicipalityAvg ?? 9.0),
			10 - (englishScore?.subjectGradeMunicipalityAvg ?? 9.0),
			10 - (koreanHistoryScore?.subjectGradeMunicipalityAvg ?? 9.0),
			10 - (inquiry1Score?.subjectGradeMunicipalityAvg ?? 9.0),
			10 - (inquiry2Score?.subjectGradeMunicipalityAvg ?? 9.0),
			10 - (secondLanguageAndChineseCharactersScore?.subjectGradeMunicipalityAvg ?? 9.0)];
			chartName.config.data.datasets[3].data = [10 - (koreanScore?.subjectGrade ?? 9.0),
			10 - (mathScore?.subjectGrade ?? 9.0),
			10 - (englishScore?.subjectGrade ?? 9.0),
			10 - (koreanHistoryScore?.subjectGrade ?? 9.0),
			10 - (inquiry1Score?.subjectGrade ?? 9.0),
			10 - (inquiry2Score?.subjectGrade ?? 9.0),
			10 - (secondLanguageAndChineseCharactersScore?.subjectGrade ?? 9.0)];
			chartName.config.options.scales.y.min = 1;
			chartName.config.options.scales.y.max = 9;
			chartName.config.options.scales.y.ticks.beginAtZero = false;
			chartName.config.options.scales.y.ticks.stepSize = 1;
			chartName.config.options.scales.y.ticks.callback = value => (10 - value);
			chartName.config.options.plugins.tooltip['callbacks'] = {
				label: function(ctx) {
					let lbl = Math.round((10 - ctx.raw) * 10) / 10 ?? '응시안함';
					return `${ctx.dataset.label} : ${lbl}등급`;
				}
			}
		} else if (chartType == '석차') {
			chartName.config.data.datasets[0].data = [20 - (koreanScore?.subjectRankNationAvg ?? 20),
			20 - (mathScore?.subjectRankNationAvg ?? 20),
			20 - (englishScore?.subjectRankNationAvg ?? 20),
			20 - (koreanHistoryScore?.subjectRankNationAvg ?? 20),
			20 - (inquiry1Score?.subjectRankNationAvg ?? 20),
			20 - (inquiry2Score?.subjectRankNationAvg ?? 20),
			20 - (secondLanguageAndChineseCharactersScore?.subjectRankNationAvg ?? 20)];
			const areaCode = user.areaCityCode.substring(0, 2);
			if(areaCode=='11' || areaCode=='26' || areaCode=='27' || areaCode=='28' ||
			   areaCode=='29' || areaCode=='30' || areaCode=='31' || areaCode=='36') {
				chartName.config.data.datasets[1].data = null;                                   
			}
			else {
				chartName.config.data.datasets[1].data = [20 - (koreanScore?.subjectRankProvinceAvg ?? 20),
				20 - (mathScore?.subjectRankProvinceAvg ?? 20),
				20 - (englishScore?.subjectRankProvinceAvg ?? 20),
				20 - (koreanHistoryScore?.subjectRankProvinceAvg ?? 20),
				20 - (inquiry1Score?.subjectRankProvinceAvg ?? 20),
				20 - (inquiry2Score?.subjectRankProvinceAvg ?? 20),
				20 - (secondLanguageAndChineseCharactersScore?.subjectRankProvinceAvg ?? 20)];
			}
			chartName.config.data.datasets[2].data = [20 - (koreanScore?.subjectRankMunicipalityAvg ?? 20),
			20 - (mathScore?.subjectRankMunicipalityAvg ?? 20),
			20 - (englishScore?.subjectRankMunicipalityAvg ?? 20),
			20 - (koreanHistoryScore?.subjectRankMunicipalityAvg ?? 20),
			20 - (inquiry1Score?.subjectRankMunicipalityAvg ?? 20),
			20 - (inquiry2Score?.subjectRankMunicipalityAvg ?? 20),
			20 - (secondLanguageAndChineseCharactersScore?.subjectRankMunicipalityAvg ?? 20)];
			chartName.config.data.datasets[3].data = [20 - (koreanScore?.subjectRank ?? 20),
			20 - (mathScore?.subjectRank ?? 20),
			20 - (englishScore?.subjectRank ?? 20),
			20 - (koreanHistoryScore?.subjectRank ?? 20),
			20 - (inquiry1Score?.subjectRank ?? 20),
			20 - (inquiry2Score?.subjectRank ?? 20),
			20 - (secondLanguageAndChineseCharactersScore?.subjectRank ?? 20)];
			chartName.config.options.scales.y.min = 0;
			chartName.config.options.scales.y.max = 20;
			chartName.config.options.scales.y.ticks.beginAtZero = false;
			chartName.config.options.scales.y.ticks.stepSize = 2;
			chartName.config.options.scales.y.ticks.callback = value => (20 - value);
			chartName.config.options.plugins.tooltip['callbacks'] = {
				label: function(ctx) {
					let lbl = Math.round((20 - ctx.raw) * 10) / 10 ?? '응시안함';
					return `${ctx.dataset.label} : ${lbl}등`;
				}
			}
		}
		chartName.update();
	};

	$('#took-exam-select').change(function() {
		const data = $(this).find(':selected').data();
		const request = $.ajax({
			url: '/score/searchTookExamScore',
			method: 'POST',
			dataType: 'JSON',
			contentType: 'application/json',
			data: JSON.stringify(data)
		});
		request.done(function(subjectScore) {

			console.log(subjectScore);

			koreanScore = subjectScore['koreanScore'];
			mathScore = subjectScore['mathScore'];
			englishScore = subjectScore['englishScore'];
			koreanHistoryScore = subjectScore['koreanHistoryScore'];
			inquiry1Score = subjectScore['inquiry1Score'];
			inquiry2Score = subjectScore['inquiry2Score'];
			secondLanguageAndChineseCharactersScore = subjectScore['secondLanguageAndChineseCharactersScore'];

			// 버튼 그룹 초기화
			$('#score-analysis-div button').each((idx, ele) => $(ele).attr('id') == 'originalScoreBtn' ? $(ele).toggleClass('active', true) : $(ele).toggleClass('active', false));

			updateChart(scoreChart, '원점수');

			// 테이블 값 변경
			$('#koreaSelectSubject').text(koreanScore?.subjectMinorCategoryName ?? '');
			$('#mathSelectSubject').text(mathScore?.subjectMinorCategoryName ?? '');
			$('#inquiry1SelectSubject').text(inquiry1Score?.subjectMinorCategoryName ?? '');
			$('#inquiry2SelectSubject').text(inquiry2Score?.subjectMinorCategoryName ?? '');
			$('#secondLanguageAndChineseCharactersSelectSubject').text(secondLanguageAndChineseCharactersScore?.subjectMinorCategoryName ?? '');

			const $koreanHistoryTookStatusTd = $('#koreanHistoryTookStatus');
			$koreanHistoryTookStatusTd.empty();
			if (koreanHistoryScore != null) {
				const $span = $('<span></span>', {'class': 'subject-took-status-span'}).text('응시');
				$koreanHistoryTookStatusTd.append($span);
			}
			else {
				const $a = $('<a></a>', { 'class': 'subject-took-status-a', 'href': `/exam/examList` }).text('미응시');
				$koreanHistoryTookStatusTd.append($a);
			}

			const $koreanTookStatusTd = $('#koreanTookStatus');
			$koreanTookStatusTd.empty();
			if(koreanScore != null) {
				const $span = $('<span></span>', {'class': 'subject-took-status-span'}).text('응시');
				$koreanTookStatusTd.append($span);
			}
			else {
				const $a = $('<a></a>', { 'class': 'subject-took-status-a', 'href': `/exam/examList` }).text('미응시');
				$koreanTookStatusTd.append($a);
			}

			const $mathTookStatusTd = $('#mathTookStatus');
			$mathTookStatusTd.empty();
			if(mathScore != null) {
				const $span = $('<span></span>', {'class': 'subject-took-status-span'}).text('응시');
				$mathTookStatusTd.append($span);
			}
			else {
				const $a = $('<a></a>', { 'class': 'subject-took-status-a', 'href': `/exam/examList` }).text('미응시');
				$mathTookStatusTd.append($a);
			}

			const $englishTookStatusTd = $('#englishTookStatus');
			$englishTookStatusTd.empty();
			if(englishScore != null) {
				const $span = $('<span></span>', {'class': 'subject-took-status-span'}).text('응시');
				$englishTookStatusTd.append($span);
			}
			else {
				const $a = $('<a></a>', { 'class': 'subject-took-status-a', 'href': `/exam/examList` }).text('미응시');
				$englishTookStatusTd.append($a);
			}

			const $inquiry1TookStatusTd = $('#inquiry1TookStatus');
			$inquiry1TookStatusTd.empty();
			if(inquiry1Score != null) {
				const $span = $('<span></span>', {'class': 'subject-took-status-span'}).text('응시');
				$inquiry1TookStatusTd.append($span);
			}
			else {
				const $a = $('<a></a>', { 'class': 'subject-took-status-a', 'href': `/exam/examList` }).text('미응시');
				$inquiry1TookStatusTd.append($a);
			}
			
			const $inquiry2TookStatusTd = $('#inquiry2TookStatus');
			$inquiry2TookStatusTd.empty();
			if(inquiry2Score != null) {
				const $span = $('<span></span>', {'class': 'subject-took-status-span'}).text('응시');
				$inquiry2TookStatusTd.append($span);
			}
			else {
				const $a = $('<a></a>', { 'class': 'subject-took-status-a', 'href': `/exam/examList` }).text('미응시');
				$inquiry2TookStatusTd.append($a);
			}

			const $secondLanguageAndChineseCharactersTookStatusTd = $('#secondLanguageAndChineseCharactersTookStatus');
			$secondLanguageAndChineseCharactersTookStatusTd.empty();
			if(secondLanguageAndChineseCharactersScore != null) {
				const $span = $('<span></span>', {'class': 'subject-took-status-span'}).text('응시');
				$secondLanguageAndChineseCharactersTookStatusTd.append($span);
			}
			else {
				const $a = $('<a></a>', { 'class': 'subject-took-status-a', 'href': `/exam/examList` }).text('미응시');
				$secondLanguageAndChineseCharactersTookStatusTd.append($a);
			}

			$('#koreanHistoryOriginalScore').text(koreanHistoryScore?.subjectOriginalScore ?? '');
			$('#koreanOriginalScore').text(koreanScore?.subjectOriginalScore ?? '');
			$('#mathOriginalScore').text(mathScore?.subjectOriginalScore ?? '');
			$('#englishOriginalScore').text(englishScore?.subjectOriginalScore ?? '');
			$('#inquiry1OriginalScore').text(inquiry1Score?.subjectOriginalScore ?? '');
			$('#inquiry2OriginalScore').text(inquiry2Score?.subjectOriginalScore ?? '');
			$('#secondLanguageAndChineseCharactersOriginalScore').text(secondLanguageAndChineseCharactersScore?.subjectOriginalScore ?? '');

			$('#koreanStandardScore').text(koreanScore?.subjectStandardScore ?? '');
			$('#mathStandardScore').text(mathScore?.subjectStandardScore ?? '');
			$('#inquiry1StandardScore').text(inquiry1Score?.subjectStandardScore ?? '');
			$('#inquiry2StandardScore').text(inquiry2Score?.subjectStandardScore ?? '');

			$('#koreanPercent').text(koreanScore?.subjectPercent ?? '');
			$('#mathPercent').text(mathScore?.subjectPercent ?? '');
			$('#inquiry1Percent').text(inquiry1Score?.subjectPercent ?? '');
			$('#inquiry2Percent').text(inquiry2Score?.subjectPercent ?? '');

			$('#koreanHistoryRank').text(koreanHistoryScore?.subjectRank ?? '');
			$('#koreanRank').text(koreanScore?.subjectRank ?? '');
			$('#mathRank').text(mathScore?.subjectRank ?? '');
			$('#englishRank').text(englishScore?.subjectRank ?? '');
			$('#inquiry1Rank').text(inquiry1Score?.subjectRank ?? '');
			$('#inquiry2Rank').text(inquiry2Score?.subjectRank ?? '');
			$('#secondLanguageAndChineseCharactersRank').text(secondLanguageAndChineseCharactersScore?.subjectRank ?? '');

			$('#koreanHistoryGrade').text(koreanHistoryScore?.subjectGrade ?? '');
			$('#koreanGrade').text(koreanScore?.subjectGrade ?? '');
			$('#mathGrade').text(mathScore?.subjectGrade ?? '');
			$('#englishGrade').text(englishScore?.subjectGrade ?? '');
			$('#inquiry1Grade').text(inquiry1Score?.subjectGrade ?? '');
			$('#inquiry2Grade').text(inquiry2Score?.subjectGrade ?? '');
			$('#secondLanguageAndChineseCharactersGrade').text(secondLanguageAndChineseCharactersScore?.subjectGrade ?? '');

		});
		request.fail(function(jqXHR, textStatus, error) {
			console.log(error);
		});
	});

	$('.score-btn').click(function(e) {
		$('.score-btn').each((idx, ele) => $(ele).toggleClass('active', ele == this));
		if ($(e.target).attr('id') == 'originalScoreBtn') {
			updateChart(scoreChart, '원점수');
		} else if ($(e.target).attr('id') == 'standardScoreBtn') {
			updateChart(scoreChart, '표준점수');
		} else if ($(e.target).attr('id') == 'percentBtn') {
			updateChart(scoreChart, '백분위');
		} else if ($(e.target).attr('id') == 'gradeBtn') {
			updateChart(scoreChart, '등급');
		} else if ($(e.target).attr('id') == 'rankBtn') {
			updateChart(scoreChart, '석차');
		}
	});



	const ctx = document.getElementById('scoreChart').getContext('2d');
	const data = {
		labels: ['국어', '수학', '영어', '한국사', '탐구1', '탐구2', '제2외국어 및 한문'],
		datasets: [
			{
				label: '원점수 전국 평균',
				data: [koreanScore == null ? 0.0 : koreanScore.subjectOriginalScoreNationAvg,
				mathScore == null ? 0.0 : mathScore.subjectOriginalScoreNationAvg,
				englishScore == null ? 0.0 : englishScore.subjectOriginalScoreNationAvg,
				koreanHistoryScore == null ? 0.0 : koreanHistoryScore.subjectOriginalScoreNationAvg,
				inquiry1Score == null ? 0.0 : inquiry1Score.subjectOriginalScoreNationAvg,
				inquiry2Score == null ? 0.0 : inquiry2Score.subjectOriginalScoreNationAvg,
				secondLanguageAndChineseCharactersScore == null ? 0.0 : secondLanguageAndChineseCharactersScore.subjectOriginalScoreNationAvg],

				backgroundColor: 'rgba(198, 93, 143, 1)',
				borderColor: 'rgba(198, 93, 143, 1)',
				borderWidth: 1.5,
				tension: 0.25,
				fill: false,
				type: 'line'
			},
			{
				label: '원점수 도 평균',
				data: [koreanScore == null ? 0.0 : koreanScore.subjectOriginalScoreProvinceAvg,
				mathScore == null ? 0.0 : mathScore.subjectOriginalScoreProvinceAvg,
				englishScore == null ? 0.0 : englishScore.subjectOriginalScoreProvinceAvg,
				koreanHistoryScore == null ? 0.0 : koreanHistoryScore.subjectOriginalScoreProvinceAvg,
				inquiry1Score == null ? 0.0 : inquiry1Score.subjectOriginalScoreProvinceAvg,
				inquiry2Score == null ? 0.0 : inquiry2Score.subjectOriginalScoreProvinceAvg,
				secondLanguageAndChineseCharactersScore == null ? 0.0 : secondLanguageAndChineseCharactersScore.subjectOriginalScoreProvinceAvg],

				backgroundColor: 'rgba(84, 127, 214, 1)',
				borderColor: 'rgba(84, 127, 214, 1)',
				borderWidth: 1.5,
				tension: 0.25,
				fill: false,
				type: 'line'
			},
			{
				label: '원점수 시 평균',
				data: [koreanScore == null ? 0.0 : koreanScore.subjectOriginalScoreMunicipalityAvg,
				mathScore == null ? 0.0 : mathScore.subjectOriginalScoreMunicipalityAvg,
				englishScore == null ? 0.0 : englishScore.subjectOriginalScoreMunicipalityAvg,
				koreanHistoryScore == null ? 0.0 : koreanHistoryScore.subjectOriginalScoreMunicipalityAvg,
				inquiry1Score == null ? 0.0 : inquiry1Score.subjectOriginalScoreMunicipalityAvg,
				inquiry2Score == null ? 0.0 : inquiry2Score.subjectOriginalScoreMunicipalityAvg,
				secondLanguageAndChineseCharactersScore == null ? 0.0 : secondLanguageAndChineseCharactersScore.subjectOriginalScoreMunicipalityAvg],

				backgroundColor: 'rgba(70, 134, 184, 1)',
				borderColor: 'rgba(70, 134, 184, 1)',
				borderWidth: 1.5,
				tension: 0.25,
				fill: false,
				type: 'line'
			},
			{
				label: '원점수',
				data: [koreanScore == null ? 0.0 : koreanScore.subjectOriginalScore,
				mathScore == null ? 0.0 : mathScore.subjectOriginalScore,
				englishScore == null ? 0.0 : englishScore.subjectOriginalScore,
				koreanHistoryScore == null ? 0.0 : koreanHistoryScore.subjectOriginalScore,
				inquiry1Score == null ? 0.0 : inquiry1Score.subjectOriginalScore,
				inquiry2Score == null ? 0.0 : inquiry2Score.subjectOriginalScore,
				secondLanguageAndChineseCharactersScore == null ? 0.0 : secondLanguageAndChineseCharactersScore.subjectOriginalScore],

				barThickness: 50,

				backgroundColor: ['rgba(255, 173, 173, 0.75)',
					'rgba(255, 214, 165, 0.75)',
					'rgba(253, 255, 182, 0.75)',
					'rgba(202, 255, 191, 0.75)',
					'rgba(155, 246, 255, 0.75)',
					'rgba(160, 196, 255, 0.75)',
					'rgba(189, 178, 255, 0.75)'],
				borderColor: ['rgba(255, 173, 173, 1)',
					'rgba(255, 214, 165, 1)',
					'rgba(253, 255, 182, 1)',
					'rgba(202, 255, 191, 1)',
					'rgba(155, 246, 255, 1)',
					'rgba(160, 196, 255, 1)',
					'rgba(189, 178, 255, 1)'],
				borderWidth: 1
			}]
	};

	const config = {
		type: 'bar',
		data: data,
		options: {
			scales: {
				y: {
					beginAtZero: true,
					max: 100
				}
			},
			plugins: {
				legend: {
					position: 'top',
				},
				tooltip: {
					mode: 'index',
					intersect: false,
				}
			},
			responsive: true,
			maintainAspectRatio: false
		}
	};

	const scoreChart = new Chart(ctx, config);
}