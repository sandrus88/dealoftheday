function handleSaveRequest(args, dialogWidgetVar) {
	if (!args.validationFailed) {
		PF(dialogWidgetVar).hide();
	}
}

window.onload = function() {
	document.addEventListener('mouseover', function(event) {
		var target = event.target;

		if (!target.matches('[role="gridcell"]')) return;

		var container = target.className === 'ui-datatable-data ui-widget-content' ? target : target.parentNode;
		var title = target.title || target.getAttribute('data-title') || target.textContent;
		var overflowed = container.scrollWidth > container.clientWidth;

		target.title = overflowed ? title : '';
	});

	document.addEventListener('mouseout', function(event) {
		var target = event.target;
		if (!target.matches('[role="gridcell"]')) return;
		if (event.relatedTarget.parentNode === target) return;

		target.title = '';
	});
};