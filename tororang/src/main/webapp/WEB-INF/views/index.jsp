<%--
  Created by IntelliJ IDEA.
  User: kookyh
  Date: 2022/04/25
  Time: 4:59 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello World
<div>
    <img style="max-width: 180px;" id="previewImage" src="img/tmu01.jpeg" alt="프로필 사진" >
</div>
<div>
    <input type="checkbox"
           id="card1">
    <label for="card1">첫번째 카드</label>
    <input type="checkbox"
           id="card2">
    <label for="card2">두번째 카드</label>
    <input type="checkbox"
           id="card3">
    <label for="card3">세번째 카드</label>
</div>
<div>
<button type="button" onclick="fn_search();">오픈!
</button>
</div>
</body>
</html>
<script>
    function fn_search() {
        alert('Good!');
    }
</script>