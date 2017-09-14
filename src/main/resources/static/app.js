
// ----------------------------- UTILS START -----------------------------------------

function callAPI(url, data = {}, callback) {

	$.ajax({
	  url: url,
	  data: data,
	  success: function(resp){
	    callback(resp);
	  }
	});

}


function generateHTML(templateVariable, jsonDATA) {
	return _.template(templateVariable)(jsonDATA);
}


function generateViewForExperimentResultView(templateVariable, jsonDATA, targetElement) {

	var htmlString = '';

  var variants = jsonDATA["variants"]; 
  
  for (var i in variants) {
    htmlString += generateHTML(templateVariable, variants[i]);
  }
  
  $(targetElement).html(htmlString); 

  var options = $(targetElement);
  
  htmlString = generateHTML(templateVariable, jsonDATA);
  $(targetElement).html(htmlString);

}


function generateViewForExperimentList(templateVariable, jsonDATA, targetElement) {

	var htmlString = '';
  var options = $(targetElement);
  
  $.each( jsonDATA, function(key, val) {
    options.append(new Option(val, val));
  });
  
// 		htmlString = generateHTML(templateVariable, jsonDATA);

// 	}

// 	$(targetElement).html(htmlString);

}

function generateViewForRulesList(templateVariable, jsonDATA, targetElement) {

	var htmlString = '';
  
	// for (var prop in jsonDATA) {
	
  var rules = jsonDATA["rules"];
  var options = $(targetElement);
  
  for (var rule in rules) {
    htmlString += generateHTML(templateVariable, rules[rule]);
  }
  $(targetElement).html(htmlString); 
   
   //  console.log(val);
//     console.log(new Option(val, val));
//     options.append(new Option(val, val));
    // for (var i in val ) {
//       console.log(new Option(val[i], val[i]));
//       options.append(new Option(val[i], val[i]));
//     }
  
// 		htmlString = generateHTML(templateVariable, jsonDATA);

// 	}

// 	$(targetElement).html(htmlString);

}

function generateViewForSummaryTable(templateVariable, jsonDATA, targetElement) {

	var htmlString = '';
  
	// for (var prop in jsonDATA) {
	var variants = jsonDATA["variants"];
  
  for (var i in variants) {
    htmlString += generateHTML(templateVariable, variants[i]);
  }
  $(targetElement).html(htmlString);
}





// ----------------------------- UTILS END -----------------------------------------
