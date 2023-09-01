

$(document).ready(function() {
	let helpermemberid;
	
	$.ajax({
		url: '/getGoogleSession',
		type: 'get',
		datatype: 'json',
		success:function(data){  helpermemberid = data.helperMember.helpermemberid;
            						getJobByHelperId(helpermemberid); },
		error: function (error) {
			console.log(error)
		}
	});
	$.ajax({
		url: '/getSession',
		type: 'get',
		datatype: 'json',
		success:function(data){  helpermemberid = data.helperMember.helpermemberid;
            						getJobByHelperId(helpermemberid); },
		error: function (error) { console.log(error); }
	});
	
	function getJobByHelperId(id) {
	   $.ajax({
        url: "/getJobByHelperId/"+id, 
        type: "GET",
        dataType: "json",
        success: function(data) {
            const tableBody = $("#helperjob");
            data.forEach(function(item) {
				var row = "<tr>" ;
				const storeworklistid=item.storeworklistid;
				//取得 storeWorkList 資料
				$.ajax({
					url: '/getFavoriteJob/'+storeworklistid,
					type: 'get',
					datatype: 'json',
					success:function(data){
						row += "<td>"+data.storeName+"</td>";
						row += "<td>"+data.changedatebegin+"</td>";
						row += "<td>"+data.changedateeend+"</td>";
						$.ajax({
							url: '/getJobByWorkListIdSize/'+storeworklistid,
							type: 'get',
							datatype: 'json',
							success:function(data){
								const size = data; 
					            row += "<td>"+size+"</td>";
					            row += "<td> <button class='delete-btn' data-id='" + item.helperjobid + "'>删除</button> </td>" +
					                "</tr>";
			            		tableBody.append(row);
						},
						error: function (error) { console.log(error); }
						});
					},
					error: function (error) { console.log(error); }
				});

            });
            tableBody.on('click', '.delete-btn', function() {
                    const jobId = $(this).data("id"); 
                    deleteFavorite(jobId);
            });
        },
       	error: function (error) { console.log(error); }
    	});
    }
});


function deleteFavorite(jobId){
	$.ajax({
		url: "deleteFavorite/"+jobId,
	    method: 'delete',
	    dataType: 'text',
	    success: result,
	    error: function(error) { console.error('Error:', error);}
	});
}

function result(data){
    if(data === "刪除成功"){
       alert(data);
    } else { alert(data); }
}


/*
	//取得 storeWorkList 資料
	$.ajax({
		url: '/getFavoriteJob/'+storeworklistid,
		type: 'get',
		datatype: 'json',
		success:function(data){
			row += "<td>"+data.storeName+"</td>";
		}
	});
*/
