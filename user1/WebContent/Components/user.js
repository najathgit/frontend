$(document).ready(function() {
	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {

	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateUserForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	var type = ($("#hidhosNOSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "UserAPI",
		type : type,
		data : $("#formUser").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onUserSaveComplete(response.responseText, status);
		}
	});
});

function onUserSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divHospitalGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidhosNOSave").val("");
	$("#formHospital")[0].reset();
}
// UPDATE==========================================
$(document).on(
		"click",
		".btnUpdate",
		function(event) {
			$("#hidhosNOSave").val(
					$(this).closest("tr").find('#hidhosNOUpdate').val());
			$("#hosID").val($(this).closest("tr").find('td:eq(0)').text());
			$("#First Name").val($(this).closest("tr").find('td:eq(1)').text());
			$("#Lst Name").val($(this).closest("tr").find('td:eq(2)').text());
			$("#dateOfBirth").val($(this).closest("tr").find('td:eq(3)').text());
			$("#Address").val($(this).closest("tr").find('td:eq(4)').text());
			$("#TelephoneNo").val($(this).closest("tr").find('td:eq(4)').text());
			$("#UserNAme").val($(this).closest("tr").find('td:eq(4)').text());
			$("#Password").val($(this).closest("tr").find('td:eq(4)').text());
			$("#Email").val($(this).closest("tr").find('td:eq(4)').text());
		});

// REMOVE ====================================================

$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "UserAPI",
		type : "DELETE",
		data : "hosNO=" + $(this).data("Userno"),
		dataType : "text",
		complete : function(response, status) {
			onUserDeleteComplete(response.responseText, status);
		}
	});
});
function onUserDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divHospitalGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// CLIENTMODEL=========================================================================
function validateUserForm() {
	// CODE
	if ($("#hosID").val().trim() == "") {
		return "Insert User ID.";
	}
	// NAME
	if ($("#First Name").val().trim() == "") {
		return "Insert User first  Name.";
	}
	//Last name
	if ($("#Last Name").val().trim() == "") {
		return "Insert User Last name.";
	}
	// PHONE NO-------------------------------
	if ($("#dateOfBirth").val().trim() == "") {
		return "Insert dateOfBirth.";
	}
	//address
	if ($("#Address").val().trim() == "") {
		return "Insert User address.";
	}

	// is numerical value
	var TelephoneNo = $("#TelephoneNo").val().trim();
	if (!$.isNumeric(TelephoneNo)) {
		return "Insert a numerical value for Phone no.";
	}
	//username
	if ($("#User Name").val().trim() == "") {
		return "Insert User user name.";
	}
	// password-------------------------------
	if ($("#password").val().trim() == "") {
		return "Insert user password.";
	}
	//email
	if ($("#Email").val().trim() == "") {
		return "Insert User email";
	}
	
	
	return true;

}
