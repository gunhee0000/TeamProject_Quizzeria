    $(document).ready(function() {
    // 배너 이미지의 개수를 저장합니다.
    var numberOfBanners = $('#banner>a').length;

    // 배너 이미지를 감싸는 div 엘리먼트의 너비를 계산합니다.
    var bannerWidth = $('#banner').width();

    // 각 배너 이미지의 너비를 계산합니다.
    var bannerImageWidth = bannerWidth / numberOfBanners;

    // 배너 이미지의 초기 위치를 설정합니다.
    var currentPosition = 0;

    // 배너 이미지를 움직이는 함수를 정의합니다.
    function moveBanners() {
    // currentPosition을 1 증가시킵니다.
    currentPosition++;

    // currentPosition이 배너 이미지의 개수와 같으면 currentPosition을 0으로 초기화합니다.
    if (currentPosition == numberOfBanners) {
    currentPosition = 0;
}

    // #banner div 엘리먼트를 오른쪽으로 이동시킵니다.
    $('#banner').animate({
    left: -currentPosition * bannerImageWidth
}, 5000, 'linear', moveBanners);
}

    // moveBanners 함수를 호출하여 배너 이미지를 움직입니다.
    moveBanners();
});