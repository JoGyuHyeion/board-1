
$(document).ready(function () {

    $("#email").focusout(function () {

        var checkValue = /[A-Za-z0-9._@]/g;
        var value = $(this).val();
        $email = $(this);
        if (!checkValue.test(value)) {
            alert("영어만 입력 가능합니다.");
            $(this).val('');
        }
    });
});