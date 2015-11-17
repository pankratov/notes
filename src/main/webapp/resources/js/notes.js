function AppViewModel() {
	var self = this;
	self.notes = ko.observableArray([]);
	self.tags = ko.observableArray([]);
	self.titleFilter = ko.observable("");
	self.tagFilter = ko.observable("");

		
	self.filteredNotes = ko.computed(function(){
        var result;
        result = ko.utils.arrayFilter(self.notes(), function(model, event) {
        	var hasTag = true;
        	var selectedTag = self.tagFilter();
        	if(selectedTag != null) {        		
        		var firstObj = ko.utils.arrayFirst(model.tags, function(item) {
        		    return item.value == selectedTag.value;
        		});
        		hasTag = (firstObj != null);
        	}
        	return hasTag && model.title.search(self.titleFilter()) >= 0;
        });
        return result;
	});
	
	$.getJSON("rest/notes", function(data) {
        self.notes(data);
    });
	$.getJSON("rest/tags", function(data) {
		self.tags(data);
    });

}

ko.applyBindings(new AppViewModel());