
const menuBtn = document.querySelector('header .menu-open');
const closeBtn = document.querySelector('.gnb .close');

const gnb = document.querySelector('.gnb');

//클릭 이벤트 생성
menuBtn.addEventListener('click', function() {
    gnb.classList.add('on');
});

closeBtn.addEventListener('click', function() {
    gnb.classList.remove('on');
});