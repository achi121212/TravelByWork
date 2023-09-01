/**
 * 
 */
$("#saveCV").click(savecv)

function savecv(event){
	event.preventDefault();
	var helpercv={};
	helpercv.helpermemberid=$("#helpermemberid").val();
	helpercv.username=$("#username").val();
	helpercv.account=$("#account").val();
	helpercv.helperphoto=$("#helperphoto").val();
	helpercv.helpercvlink=$("#helpercvlink").val();
	
	$.ajax({
        url: 'updatehelpercv',					
        type: 'post',
        dataType: 'text',  					
        contentType: 'application/json', 	    
        data: JSON.stringify(helpercv),								
        success: result,					 
        error: function (myerror) { console.log(myerror) ;}
    });
}
function result(data){
	alert(data);
}