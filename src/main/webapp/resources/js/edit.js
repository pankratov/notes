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
	self.alertMsg = ko.observable({error: ""});
	self.alert = ko.computed(function(){
		return self.alertMsg().error != "";
	});
	
	$.getJSON("rest/tags", function(data) {
        self.tags(data);
    });
	
	self.addNote = function() {
		self.alertMsg({error: ""});
		var data = {
				title: self.title(),
				body: self.body(),
				tags: ko.toJS(self.checkedTags)
		};
			
		$.postJSON("rest/notes", data, 
				function(returnedData) {
					self.body("");
					self.title("");
					self.checkedTags([]);
				}, 
				function(response, status, error) {
					self.alertMsg(response.responseJSON);
				}
		);
	}

}

ko.applyBindings(new AppViewModel());