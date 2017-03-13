function validateShipForm(form) {

    var nameField = form.shipId;

    if (isNotEmpty(nameField)) {
        return true;
    }
    return false;
}

function isNotEmpty(field) {

    var fieldData = field.value;

    if (fieldData.length == 0 || fieldData == "" || fieldData == fieldData) {

        field.className = "FieldError"; //Classs to highlight error
        alert("Please correct the errors in order to continue.");
        return false;
    } else {

        field.className = "FieldOk"; //Resets field back to default
        return true; //Submits form
    }
}