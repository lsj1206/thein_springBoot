// 골프연습장 수강신청 페이지 전용 비즈니스 로직 및 이벤트 핸들러

// 달력의 기준이 되는 연도 변수 (기본값: 현재 연도)
var calendarYear = new Date().getFullYear();

// 수강월 입력 시 나타나는 월별 달력 팝업창의 표시 여부를 토글하는 함수
function showMonthCalendar() {
    var popup = document.getElementById("calendar_popup");
    if (popup.style.display === "block") {
        popup.style.display = "none";
        return;
    }
    renderCalendar(); // 달력 HTML 동적 렌더링
    popup.style.display = "block";
}

// 달력 팝업 내에서 연도를 이전(<) 또는 다음(>)으로 이동시키는 함수
function changeCalendarYear(offset) {
    var today = new Date();
    var baseYear = today.getFullYear();
    var targetYear = calendarYear + offset;

    // 현재 연도 기준 앞뒤 1년 범위 내에서만 연도 이동을 허용
    if (targetYear >= baseYear - 1 && targetYear <= baseYear + 1) {
        calendarYear = targetYear;
        renderCalendar();
    }
}

// 선택 가능한 월별 버튼들을 계산하여 달력 HTML을 동적으로 생성하고 화면에 출력하는 함수
function renderCalendar() {
    var today = new Date();
    var baseYear = today.getFullYear();
    var todayYear = today.getFullYear();
    var todayMonth = today.getMonth() + 1;

    // 달력 상단 헤더 영역 (연도 표시 및 연도 이동 버튼 구성)
    var html = '<div style="background:#2c3e50; color:white; padding:8px; display:flex; justify-content:space-between; align-items:center; border-radius:3px 3px 0 0;">';

    if (calendarYear > baseYear - 1) {
        html += '<span onclick="changeCalendarYear(-1)" style="cursor:pointer; font-weight:bold; display:inline-block; width:30px; text-align:center; font-size:16px;">&lt;</span>';
    } else {
        html += '<span style="color:#7f8c8d; font-weight:bold; display:inline-block; width:30px; text-align:center; font-size:16px; cursor:not-allowed;">&lt;</span>';
    }

    html += '<span style="font-weight:bold; font-size:15px;">' + calendarYear + '</span>';

    if (calendarYear < baseYear + 1) {
        html += '<span onclick="changeCalendarYear(1)" style="cursor:pointer; font-weight:bold; display:inline-block; width:30px; text-align:center; font-size:16px;">&gt;</span>';
    } else {
        html += '<span style="color:#7f8c8d; font-weight:bold; display:inline-block; width:30px; text-align:center; font-size:16px; cursor:not-allowed;">&gt;</span>';
    }
    html += '</div>';

    // 1월부터 12월까지의 월 선택 버튼 영역 생성
    html += '<div style="display:grid; grid-template-columns:repeat(4, 1fr); gap:8px; padding:12px; background:white;">';

    for (var m = 1; m <= 12; m++) {
        var monthStr = m + '월';
        var padMonth = m < 10 ? '0' + m : '' + m;
        var dateStr = calendarYear + '-' + padMonth; // 화면 표시용 포맷 (YYYY-MM)
        var dbStr = calendarYear + '' + padMonth;     // DB 전송용 포맷 (YYYYMM)

        var isDisabled = false;

        // 과거의 월이나 현재 연도 기준 너무 먼 미래의 월은 선택 불가 처리
        if (calendarYear < todayYear || (calendarYear === todayYear && m < todayMonth)) {
            isDisabled = true;
        }
        if (calendarYear > todayYear + 1 || (calendarYear === todayYear + 1 && m > todayMonth)) {
            isDisabled = true;
        }

        if (isDisabled) {
            html += '<button type="button" disabled style="padding:10px 0; background:#f1f1f1; border:1px solid #ddd; color:#bdc3c7; border-radius:3px; font-size:13px; cursor:not-allowed;">' + monthStr + '</button>';
        } else {
            html += '<button type="button" onclick="selectMonth(\'' + dateStr + '\', \'' + dbStr + '\')" style="padding:10px 0; background:#f8f9fa; border:1px solid #dee2e6; color:#2c3e50; font-weight:bold; border-radius:3px; font-size:13px; cursor:pointer;" onmouseover="this.style.background=\'#3498db\'; this.style.color=\'white\'" onmouseout="this.style.background=\'#f8f9fa\'; this.style.color=\'#2c3e50\'">' + monthStr + '</button>';
        }
    }
    html += '</div>';

    var popup = document.getElementById("calendar_popup");
    popup.innerHTML = html;
}

// 사용자가 특정 월을 선택했을 때 인풋 필드에 값을 설정하고 팝업창을 닫는 함수
function selectMonth(displayVal, dbVal) {
    document.getElementById("regist_month_display").value = displayVal;
    document.getElementById("regist_month_hidden").value = dbVal;
    document.getElementById("calendar_popup").style.display = "none";
}

// 최초 페이지 로딩 시 수강월 입력칸에 현재 연월을 기본값으로 세팅
document.addEventListener("DOMContentLoaded", function () {
    var today = new Date();
    var year = today.getFullYear();
    var month = today.getMonth() + 1;
    if (month < 10) month = "0" + month;
    document.getElementById("regist_month_display").value = year + "-" + month;
    document.getElementById("regist_month_hidden").value = year + "" + month;
});

// 달력 영역 외의 외부 영역을 클릭했을 때 달력 팝업을 자동으로 닫는 처리
window.onclick = function (event) {
    const popup = document.getElementById('calendar_popup');
    const calBtn = document.querySelector('.btn-cal');
    if (!document.body.contains(event.target)) {
        return;
    }
    if (event.target !== popup && event.target !== calBtn && !popup.contains(event.target)) {
        popup.style.display = 'none';
    }
}

// 셀렉트 박스에서 회원명을 변경했을 때 동작하는 이벤트 핸들러
function changeMember() {
    var select = document.getElementById("c_no_select");
    var option = select.options[select.selectedIndex];

    if (option.value === "") {
        document.getElementById("c_no_display").value = "";
        document.getElementById("member_grade").value = "";
    } else {
        document.getElementById("c_no_display").value = option.value;
        document.getElementById("member_grade").value = option.getAttribute("data-grade");
    }
    calculateTuition(); // 등급 기반으로 수강료 재연산
}

// 선택 박스에서 강의명을 변경했을 때 동작하는 이벤트 핸들러
function changeClass() {
    var select = document.getElementById("class_name_select");
    var option = select.options[select.selectedIndex];

    if (option.value === "") {
        document.getElementById("teacher_code_hidden").value = "";
        document.getElementById("teacher_name_display").value = "";
        document.getElementById("class_area_display").value = "";
        document.getElementById("class_area_hidden").value = "";
        document.getElementById("class_price_hidden").value = "";
        document.getElementById("tuition_display").value = "";
        document.getElementById("tuition_hidden").value = "";
        return;
    }

    var teacherCode = option.value;
    var teacherName = option.getAttribute("data-teacher");
    var classPrice = parseInt(option.getAttribute("data-price"));
    var classArea = option.getAttribute("data-area");

    // 조회 전용 화면 표시 인풋 및 폼 전송용 히든 필드에 값 할당
    document.getElementById("teacher_code_hidden").value = teacherCode;
    document.getElementById("teacher_name_display").value = teacherName;
    document.getElementById("class_area_display").value = classArea;
    document.getElementById("class_area_hidden").value = classArea;
    document.getElementById("class_price_hidden").value = classPrice;

    calculateTuition();
}

// 수강료를 계산하는 함수
function calculateTuition() {
    var priceHidden = document.getElementById("class_price_hidden").value;
    if (!priceHidden) return;

    var basePrice = parseInt(priceHidden);

    var finalPrice = basePrice;

    document.getElementById("tuition_hidden").value = finalPrice;
    document.getElementById("tuition_display").value = finalPrice.toLocaleString() + "원";
}

// 입력된 폼 데이터를 초기화하고 수강월 필드를 현재 월로 재설정하는 함수
function resetForm() {
    document.frm.reset();
    document.getElementById("c_no_display").value = "";
    document.getElementById("member_grade").value = "";
    document.getElementById("teacher_code_hidden").value = "";
    document.getElementById("teacher_name_display").value = "";
    document.getElementById("class_area_display").value = "";
    document.getElementById("class_area_hidden").value = "";
    document.getElementById("class_price_hidden").value = "";
    document.getElementById("tuition_display").value = "";
    document.getElementById("tuition_hidden").value = "";

    var today = new Date();
    var year = today.getFullYear();
    var month = today.getMonth() + 1;
    if (month < 10) month = "0" + month;
    document.getElementById("regist_month_display").value = year + "-" + month;
    document.getElementById("regist_month_hidden").value = year + "" + month;
}

// 수강신청 전송 전 데이터 유효성 검증 및 전송 포맷 검사
function checkForm() {
    var displayVal = document.getElementById("regist_month_display").value.trim();
    var reg = /^\d{4}-\d{2}$/;

    // 수강월 입력 포맷 검증
    if (!reg.test(displayVal)) {
        alert("수강월 형식이 올바르지 않습니다. (예: 2026-06)");
        document.getElementById("regist_month_display").focus();
        return false;
    }

    // 화면용 표시 파싱
    var dbVal = displayVal.replace("-", "");
    document.getElementById("regist_month_hidden").value = dbVal;

    // 필수 항목 누락 점검
    if (!document.getElementById("c_no_select").value) {
        alert("회원명을 선택해 주십시오.");
        document.getElementById("c_no_select").focus();
        return false;
    }
    if (!document.getElementById("class_name_select").value) {
        alert("강의명을 선택해 주십시오.");
        document.getElementById("class_name_select").focus();
        return false;
    }
    return true;
}
