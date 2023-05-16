$(function() {
    var currentIndex = 0;
    var images = $('#banner img');
    var imageCount = images.length;
    var intervalId;

    function startSlideShow() {
        intervalId = setInterval(function () {
            images.eq(currentIndex).fadeOut(1000);
            images.eq(currentIndex).attr('style', 'display: none')
            currentIndex = (currentIndex + 1) % imageCount;
            images.eq(currentIndex).fadeIn(1000);
        }, 4000);
    }

    startSlideShow();

});