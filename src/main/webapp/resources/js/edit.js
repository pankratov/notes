$.postJSON = function(url, data, success, fail) {
    return jQuery.ajax({
        'type': 'POST',
        'url': url,
        'contentType': 'application/json',
        'data': JSON.stringify(data),
        'dataType': 'json',
        'success': success,
        'error': fail
    });
}

function AppViewModel() {
	var self = this;
	self.tags = ko.observableArray([]);
	self.title = ko.observable("");
	self.body = ko.observable("");
	self.checkedTags = ko.observableArray([]);
	self.alert = ko.observable(false);
	self.alertMsg = ko.observable({error: ""});
	
	$.getJSON("rest/tags", function(data) {
        self.tags(data);
    });
	
	self.addNote = function() {
		var data = {
				title: ko.toJS(self.title),
				body: ko.toJS(self.body),
				tags: ko.toJS(self.checkedTags)
		};
			
		$.postJSON("rest/notes", data, 
				function(returnedData) {
					self.body("");
					self.title("");
					self.checkedTags([]);
					self.alert(false);
				}, 
				function(response, status, error) {
					self.alert(true);
					self.alertMsg(JSON.parse(response.responseText));
				}
		);
	}

}

ko.applyBindings(new AppViewModel());