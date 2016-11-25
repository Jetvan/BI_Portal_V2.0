/**
 * Created by XIANGYANG on 2016/11/7.
 */
function changeBodyTheme(colorObj){
//           alert(colorObj);
    $('pageBody').addClass(colorObj);
}
$(function () {
    window.setTimeout(function () {
        $("#pageBody").css("visibility", "visible");
    }, 500);
});
function openMainPage() {
    window.location.href = "#//main";
}
function openDefaultReportTab(menuId) {
    window.location.href = "#/reportBusiness/"+menuId;
}
window.onload = function () {
    //openMainPage();

    //
}
