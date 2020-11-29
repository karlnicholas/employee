$(document).ready(function() {
  $.ajax('/hr/employees', {success: function(data){
	var content = "<table>"
	for(i=0; i<data.length; i++){
	    content += '<tr>';
	    content += '<td>' + data[i].id + '</td>';
	    content += '<td>' + data[i].name + '</td>';
	    content += '<td>' + data[i].department.name + '</td>';
	    content += '<td>' + data[i].salary + '</td>';
	    content += '</tr>';
	}
	content += "</table>"
	
	$('#employees').append(content);
	}});
})