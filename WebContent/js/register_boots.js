$(document).ready(function(){
$("#submitbutton").bind("click",function(){
var username = $("#username").val();
var password = $("#password").val();
var passwordcfm = $("#passwordcfm").val();
if(!username){
	alert("No username entered!")
}else if(password != passwordcfm){
	alert("The passwords do not match!");
}else if(!password){
	alert("No password entered!");
}else{
	$("#registerform").submit();
}
});
});