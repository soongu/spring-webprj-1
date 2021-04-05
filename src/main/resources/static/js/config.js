//스크롤라 라이브러리 설정 적용
$('.animate').scrolla({
    mobile: false,
    once: false
});

//slick 라이브러리 설정 적용
$('section.visual .slide').slick({
    fade: true, //페이드 인 효과를 켬.
    autoplay: true, //자동 재생효과를 켬
    autoplaySpeed: 3000, //자동 재생 간격 3초    
});