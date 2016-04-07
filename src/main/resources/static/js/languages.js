function addLanguage() {
    $('#languageDialog').dialog("option", "title", 'Add Language');
    $('#languageDialog').dialog('open');
}

function editLanguage(id) {

    $.get("/languages/get/" + id, function(result) {

        $("#languageDialog").html(result);

        $('#languageDialog').dialog("option", "title", 'Edit Language');

        $("#languageDialog").dialog('open');
    });
}

function deleteLanguage(id) {

    $( "#dialog-confirm" ).dialog({
        resizable: false,
        height:200,
        width: 300,
        modal: true,
        buttons: {
            "Delete language": function() {
                $.ajax({
                    url: "/languages/delete/" + id,
                    type: "POST",
                    success:function(response) {
                        $('#language-'+id).hide()
                    }
                });
                $( this ).dialog( "close" );
            },
            Cancel: function() {
                $( this ).dialog( "close" );
            }
        }
    });
}

function resetDialog(form) {

    form.find("input").val("");
}

$(document).ready(function() {

    $('#languageDialog').dialog({

        autoOpen : false,
        position : 'center',
        modal : true,
        resizable : false,
        width : 440,
        buttons : {
            "Save" : function() {
                $('#languageForm').submit();
            },
            "Cancel" : function() {
                $(this).dialog('close');
            }
        },
        close : function() {

            resetDialog($('#languageForm'));

            $(this).dialog('close');
        }
    });
});

$(function () {
    var token = $("input[name='_csrf']").val();
    var header = "X-CSRF-TOKEN";
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});
