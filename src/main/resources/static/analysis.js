$(document).ready(function() {
  $.ajax('/analysis', {success: function(data){
    var content = '<p>min: ' + data.min + ' max: ' + data.max + ' mean: ' + data.mean + ' sd: ' + data.standardDeviation + '<p>';
	$('#analysis').append(content);
	}});
})