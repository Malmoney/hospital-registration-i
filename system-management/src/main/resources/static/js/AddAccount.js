$(function (){
    $("#addAccount-div-close").click(function (){
        $("#addAccount_div").hide(200);
    })
})
$("#addAccount_btn").click(function (){
    $("#addAccount_div").show(200);
})
function AddAccountHide(){
    $("#addAccount_div").hide(200);
}
function AddAccountShow(){
    $("#addAccount_div").show(200);
}