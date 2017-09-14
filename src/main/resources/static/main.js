
var templateForRuleTable = `<tr>
							<td><%=ruleName%></td>
							<td><%=status%></td>
						</tr>`;

var templateForTable = `<tr>
							<td><%=experimentCode%></td>
							<td><%=experimentName%></td>
							<td><%=variantCode%></td>
							<td><%=variantName%></td>
							<td><%=status%></td>
							<td><%=startDate%></td>
							<td><%=visitors%></td>
							<td><%=purchaser%></td>
							<td><%=recommendation%></td>
						</tr>`;

var templateForDropDown = `<option data-tokens="Exp-1" value="abhi" ><%=name%></option>`

var templateForSummaryTable = `<tr>
							<td><%=variantCode%></td>
							<td><%=recommendation%></td>
						</tr>`;

// CODE TO make api call and change view
function testit() {

	callAPI('http://jsonbin.io/b/59b92cd365ca45062e633922', {}, function(resp) {

		generateView(templateForTable, resp, '#tableContainer');

	});
}

// making EVENT based Data change

// $(document).ready(function(){

	$('#experimentContainer').on('change', function(event){
		var selectedValue = event.target.value;
		var dataToSend = "code=" + selectedValue;

		callAPI('http://localhost:8080/experiment/find?', dataToSend, function(resp) {
 		generateViewForExperimentResultView(templateForTable, resp, '#tableContainer');

		});

	});

// });

$(document).ready(function(event) {
		var dataToSend = ""

		callAPI('http://localhost:8080/experiments', dataToSend, function(resp) {
      
      generateViewForExperimentList(templateForDropDown, resp, '#experimentContainer');

		});

	});
	
$(document).ready(function(event) {
		var dataToSend = ""

		callAPI('http://localhost:8080/variants', dataToSend, function(resp) {
      
      generateViewForExperimentList(templateForDropDown, resp, '#experimentContainer1');

		});

	});
	
$('#experimentContainer1').on('change', function(event){
		var selectedValue = event.target.value;
		var dataToSend = "code=" + selectedValue;

		callAPI('http://localhost:8080/variants/rules?', dataToSend, function(resp) {
      
			generateViewForRulesList(templateForRuleTable, resp, '#tableContainer1');

		});

	});
	
$(document).ready(function(event) {
    var dataToSend = ""
		callAPI('http://localhost:8080/variants/summary', dataToSend, function(resp) {
      
			generateViewForSummaryTable(templateForSummaryTable, resp, '#tableContainer2');

		});

	});
	
$('#recommendationButton').on('click', function(event){

    var dataToSend = "";
		callAPI('http://localhost:8080/experiment/execute', dataToSend, function(resp) {
      var status = resp["status"];
      
      alert(status);
      
		});
});

$('#recommendationButton1').on('click', function(event){

    var dataToSend = "";
		callAPI('http://localhost:8080/experiment/execute', dataToSend, function(resp) {
      var status = resp["status"];
      
      alert(status);
      
		});
});
