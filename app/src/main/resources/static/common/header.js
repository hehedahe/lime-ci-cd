"use strict"

fetch('/member/getLoginUser').then(function (response) {
    return response.json();
}).then(function (result) {

    if (result.status == "success") {
        $('#u-nav-links').html(`
            <div id="u-links-cal">
                <a href="/social-match/rsv.html">
                    <img src="/asset/image/header/calendar.png" height="30px" width="30px">
                </a>
            </div>
            <div id="u-links-msg">
                <img src="/asset/image/header/msg2.png" height="30px" width="30px">
            </div>
<<<<<<< HEAD
            <div id="u-links-user">
<!--            <button id=logoutBtn onclick="test()">버튼</button>-->
<!--                <div id="myDropdown" class="dropdown-content">-->
<!--                    <a href="#">Link 1</a>-->
<!--                    <a href="#">Link 2</a>-->
<!--                    <a href="#">Link 3</a>-->
<!--                </div> -->
<!--                <img src="../asset/image/user2b.png" height="30px" width="30px">-->
            </div>
=======
            <ul class="nav nav-pills id="u-links-user"">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false"><img src="../header/userImg.png" height="30px" width="30px"/></a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">마이페이지</a></li>
                            <li><a class="dropdown-item" href="#">나의 활동</a></li>
                            <li><a class="dropdown-item" href="#">찜목록</a></li>
                            <li><a class="dropdown-item" id="logoutBtn" href="#" style="color: red;">로그아웃</a></li>
                        </ul>
                </li>
            </ul>
>>>>>>> il
        `)
        $('#logoutBtn').on('click', function() {
            fetch("/member/signout").then(function(response) {
                $('#u-nav-links').html(`
                <li><a href="/login/login.html">로그인</a></li>
                <li><a href="#">|</a></li>
                <li><a href="/signup/signup1.html">회원가입</a></li>`)
            });
        });
    }
});
<<<<<<< HEAD


window.addEventListener('load', function() {
    // alert("okokok")
    const logoutBtn = this.document.querySelector(".logoutBtn")
    console.log(logoutBtn)
})

//$(document).on('click', )


document.addEventListener('DOMContentLoaded', function() {
    alert("okok2")


    const logoutBtn = document.querySelector(".logoutBtn")
    console.log(logoutBtn)
    
 }, false);


// window.onload = function() {
//     alert(:)
// }


 function test() {
     const h1Tag = document.createElement("h1")
     const hihi = document.createTextNode('Hi!')

     h1Tag.appendChild(hihi)

     document.this.appendChild(h1Tag)
 }


=======
>>>>>>> il
