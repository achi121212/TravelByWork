
//myJobTableBody
$(document).ready(getStoreid);
function getStoreid() {
    $.ajax({
        url: '/getStore',
        type: 'get',
        datatype: 'json',
        success: function(data) {
            getMyJob(data);
        },
        error: function(error) {
            console.log(error);
        }
    });
}

async function getMyJob(data) {
    const storeid = data.storememberid;
    try {
        const response = await $.ajax({
            url: '/getByStoreMemebrId/' + storeid,
            type: 'get',
            datatype: 'json'
        });
        response.forEach(populateRowWithData);
    } catch (error) {
        console.log(error);
    }
}

function populateRowWithData(item) {
    const jobid = item.storeworklistid;
    console.log(jobid);
    const row = "<tr>" +
        "<td>" + jobid + "</td>" +
        "<td>" + item.changedatebegin + "~" + item.changedateeend + "</td>" +
        "<td>" + item.location + "</td>";

    $.ajax({
        url: '/getJobByWorkListIdSize/' + jobid,
        type: 'get',
        datatype: 'json',
        success: function(data) {
            console.log(data);
            const size = data;
            const finalRow = row + "<td>" + size + "</td></tr>";
            $("#myjobtable").append(finalRow);
        },
        error: function(error) {
            console.log(error);
        }
    });
}








