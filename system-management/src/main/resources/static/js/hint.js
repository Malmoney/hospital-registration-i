$(function (){
    $("body").append(`
<div id="hint">
    <div id="close_div"><span id="hint_close">X</span></div>
    <div id="text_div">
        <span id="hint_text">
            修改成功
        </span>
    </div>
</div>`);
    $("#hint_close").click(hintHide);
})

function hintHide(){
    $("#hint").hide(200);
}
function setHintHide(){
    window.setTimeout(hintHide,2000);
}
function showHint(text){
    $("#hint_text").text(text);
    $("#hint").show(100);
    setHintHide();
}