
function setId(data){
	document.getElementById('helpermemberid').value=data.helperMember.helpermemberid;
}

$(document).ready(function() {
	//取得小幫手資料
		$.ajax({
			url: '/getGoogleSession',
			type: 'get',
			datatype: 'json',
			success:setId
	    });
     	$.ajax({
			url: '/getSession',
			type: 'get',
			datatype: 'json',
			success:setId
		});
    // Get postJob data from the backend
    $.ajax({
        url: '/getPostJobs',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            var shareDataBody = $('#shareDataBody');
            data.forEach(function(postJob) { 
                var row = $('<tr>');
                //取得店家被收藏數量
                $.ajax({
					url: '/getJobByWorkListIdSize/'+postJob.storeworklistid,
					type: 'get',
					datatype: 'json',
					success:function(data){
						row.append($('<td>').text(data));
					}
				});

                // 添加 "聯絡方式內容" 按鈕
                var callButton = $('<button>').addClass('callButton').text('聯絡方式');
                callButton.data('postJob', postJob); // 直接將整個 postJob 物件存儲在 data 屬性中
                row.append($('<td>').append(callButton));
                
				
                // 添加 "收藏" 按鈕
                var commentButton = $('<button>').addClass('commentButton').text('收藏');
                commentButton.data('storeworklistid', postJob.storeworklistid); 
                row.append($('<td>').append(commentButton));

                shareDataBody.append(row);
            });

            // 收藏
            $(document).on('click', '.commentButton', function() {
				var storeworklistid = $(this).data('storeworklistid');                
                var helpermemberid=$("#helpermemberid").val(); 
                var helperJob={};
                helperJob.storeworklistid=storeworklistid;
                helperJob.helpermemberid=helpermemberid;
                helperJob.favorite=true;
                
				if(helpermemberid===""){
					alert("請先登入");
				}else{
					$.ajax({
						url: 'addHelperJob',					
				        type: 'post',
				        dataType: 'text',  					
				        contentType: 'application/json', 	    
				        data: JSON.stringify(helperJob),								
				        success: function(data){alert(data);},					 
				        error: function (myerror) { console.log(myerror) ;}
					});
				}
            });

            // 使用事件代理處理動態生成的 "聯絡方式內容" 按鈕
            $(document).on('click', '.callButton', function() {
                var postJob = $(this).data('postJob'); // 直接使用整個 postJob 物件
                          
				var callContent = "Email: " + postJob.email + "<br>" +
                  "店內電話: " + postJob.phone + "<br>" +
                  "行動電話: " + postJob.mobile + "<br>" +
                  "地址: " + postJob.address +"<br>" +
                  "如何申請比較好？: " + postJob.howtoapply;
                $('#callDialog').html(callContent).dialog({
                    modal: true,
                    title: '聯絡方式',
                    width: 700,   // 寬度
                    height: 600,  // 高度
                    buttons: {
                        '關閉': function() {
                            $(this).dialog('close');
                        }
                    }
                });

			//google地圖功能
				let latitude;//經度
				let longitude//緯度
				if (!window.google || !google.maps) {
                	(g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})
        			({key: "MyGoogleApiKey", v: "beta"});//key： google金鑰
        			getLocation();//下方函式
				} else {
				  	getLocation();
				}

				function getLocation(){			//從資料庫(address)取得經緯度
					 const apiKey = 'MyGoogleApiKey';
					 const address = postJob.address;	

			
					 fetch(`https://maps.googleapis.com/maps/api/geocode/json?address=${encodeURIComponent(address)}&key=${apiKey}`)
					   .then(response => response.json())
					   .then(data => {
					       const location = data.results[0].geometry.location;
					       latitude = location.lat;
					       longitude = location.lng;
					       console.log(`緯度：${latitude}, 經度：${longitude}`);
					       initMap();
					   });
				}
					  
		        async function initMap() { 		//抓地圖函式
		            const position = { lat: latitude , lng:longitude };
		            const { Map } = await google.maps.importLibrary("maps");
		            const { AdvancedMarkerView } = await google.maps.importLibrary("marker");
		            let map = new Map(document.getElementById("mymap"), {
		            zoom: 18,
		            center: position,
		            mapId: "DEMO_MAP_ID",
		            });
		            const marker = new AdvancedMarkerView({
		            map: map,
		            position: position,
		            title: "StoreAddress",
		            });
		        }
				var mapContainer = document.createElement("div");	//新增div標籤
			    mapContainer.id = "mymap";	
			    mapContainer.style.overflow= "visible";				//處理畫面超出範圍
			    mapContainer.style.height = "400px";
			    mapContainer.style.width = "80%";
			    document.getElementById("callDialog").appendChild(mapContainer);   
            });
        }
    });
});





