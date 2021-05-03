function handleSaveRequest(args, dialogWidgetVar) {
    if (!args.validationFailed) {
        PF(dialogWidgetVar).hide();
    }
}