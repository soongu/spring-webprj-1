

//스크롤 일정 부분 다운시 헤더를 변경함
function changeFixHeader(scrollTop) {

    //로고 이미지 태그를 얻어야 함
    // const $logoImage = $('.inner-header img');
    const $logoImage = document.querySelector('.inner-header img');
    // console.log($logoImage);

    const $header = document.querySelector('header');

    if (scrollTop > 200) {
        // $logoImage.eq(0).attr('src', 'img/logo2.png');
        $logoImage.setAttribute('src', 'img/logo2.png');
        // $header.addClass('on');
        $header.classList.add('on');
    } else {
        // $logoImage.eq(0).attr('src', 'img/logo.png');
        $logoImage.setAttribute('src', 'img/logo.png');
        $header.classList.remove('on');
    }

}

//맨 위로 이동 버튼 숨기기
function hideGoTop(scrollTop) {

    const $goTop = document.querySelector('.go-top');
    if (scrollTop < 800) {
        $goTop.classList.add('hide');
    } else {
        $goTop.classList.remove('hide');
    }
}

//즉시 실행 함수
(function(){

    //스크롤 이벤트
    document.addEventListener('scroll', function(e) {
        // console.log('스크롤 이벤트 발생!');

        //스크롤 위치값을 얻는 방법
        // console.log(document.documentElement.scrollTop);
        let scrollTop = document.documentElement.scrollTop;

        changeFixHeader(scrollTop);
        hideGoTop(scrollTop);
    });

    //go-top 스크롤 부드럽게 올리는 처리
    /*
    document.querySelector('.go-top').addEventListener('click', function(e) {
        $('html, body').animate({
            scrollTop: 0
        }, 1200);
    });
    */

    $('.go-top').on('click', function(e) {
        $('html, body').animate({
            scrollTop: 0
        }, 1200);
    });

}());