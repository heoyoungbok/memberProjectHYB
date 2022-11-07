<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>memberSave.jsp</title>
    <script src="/resources/js/jquery.js"></script>
</head>
<body>
    <form class="/save" method="post" name="saveForm">
    <input type="text" name="memberEmail" id="memberEmail" placeholder="이메일" onblur="emailJoinCheck()">
        <span id="email-Check"></span><br>
        <span id="input-push"></span>
    <input type="text" name="memberPassword" id="memberPassword" placeholder="비밀번호">
        <span id="input-push-pass"></span>
    <input type="text" name="memberName" id="memberName" placeholder="이름">
    <input type="text" name="memberMobile" id="memberMobile" placeholder="전화번호">
    <input type="file" name="memberProfile"  placeholder="프로필사진">
    <input type="button" value="회원가입" onclick="saveFn()">
    </form>
</body>
<script>
    const saveFn = () => {
        if (document.saveForm.memberEmail.value == ""){
            const emailCheck = document.getElementById("input-push");
            emailCheck.innerHTML="필수 항목입니다.";
            emailCheck.style.color="red";

        }else if(document.saveForm.memberPassword.value ==""){
            const passCheck = document.getElementById("input-push-pass");
            passCheck.innerHTML="필수 항목입니다.";
            passCheck.style.color="red";
        }else if(document.saveForm.memberName.value == ""){
            alert("이름을 입력해주세요");
        }else if(document.saveForm.memberMobile.value == ""){
            alert("전화번호를 입력해주세요");
        }
        document.saveForm.submit();
    }

    const emailJoinCheck = () => {
      const email = document.getElementById("memberEmail").value;
      const checkResult = document.getElementById("email-Check");

      $.ajax({
          type:"post",
          url:"/joinCheck",
          data:{inputEmail: email},
          dataType:"text",
          success: function (result){
              if (result == "ok"){
                  checkResult.innerHTML="사용할 수 있는 이메일입니다.";
                  checkResult.style.color="green";
              }else {
                  checkResult.innerText="중복된 이메일입니다.";
                  checkResult.style.color="red";
                  }
              },
            error:function (){
              console.log("실패");
            }
      });

    }


</script>
</html>
