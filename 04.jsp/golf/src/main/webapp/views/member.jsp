<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,
                 golf.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보조회</title>
</head>
<body>
<%@ include file="../layout/header.jsp" %>

<section>
    <div class="title">회원정보조회</div>

    <%
        List<MemberVO> memberList = (List<MemberVO>) request.getAttribute("memberList");
    %>

    <table>
        <thead>
            <tr>
                <th>회원번호</th>
                <th>회원명</th>
                <th>연락처</th>
                <th>주소</th>
                <th>등급</th>
            </tr>
        </thead>
        <tbody>
            <% if (memberList == null || memberList.isEmpty()) { %>
                <tr>
                    <td colspan="5" style="color: #888;">등록된 회원 정보가 없습니다.</td>
                </tr>
            <% } else {
                for (MemberVO member : memberList) {
                    // 전화번호 포맷팅 (01012345678 -> 010-1234-5678)
                    String phone = member.getPhone();
                    String phoneFormatted = "-";
                    if (phone != null && phone.length() == 11) {
                        phoneFormatted = phone.substring(0, 3) + "-" + phone.substring(3, 7) + "-" + phone.substring(7);
                    } else if (phone != null) {
                        phoneFormatted = phone;
                    }

                    // 등급 한글화
                    String grade = member.getGrade();
                    String gradeKor = "기타";
                    if ("A".equalsIgnoreCase(grade)) {
                        gradeKor = "VIP";
                    } else if ("B".equalsIgnoreCase(grade)) {
                        gradeKor = "일반";
                    } else if ("C".equalsIgnoreCase(grade)) {
                        gradeKor = "직원";
                    } else if (grade != null) {
                        gradeKor = grade;
                    }
            %>
                <tr>
                    <td><%= member.getcNo() %></td>
                    <td><%= member.getcName() %></td>
                    <td><%= phoneFormatted %></td>
                    <td><%= member.getAddress() != null ? member.getAddress() : "" %></td>
                    <td><%= gradeKor %></td>
                </tr>
            <%
                }
            }
            %>
        </tbody>
    </table>
</section>

<%@ include file="../layout/footer.jsp" %>
</body>
</html>
