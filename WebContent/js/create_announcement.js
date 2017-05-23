$(document).ready(function(){
$("#submitbutton").bind("click",function(){
var title = $("#title").val();
var description = $("#description").val();
if(!title){
	alert("No title entered!")
}else if(!description){
	alert("No description entered!");
}else{
	$("#announcementform").submit();
}
});
});