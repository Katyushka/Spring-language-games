function addWordSet() {
    $('#wordSetDialog').dialog("option", "title", 'Add Word Set');
    $('#wordSetDialog').dialog('open');
}

function editWordSet(id) {

    $.get("/wordSets/get/" + id, function(result) {

        $("#wordSetDialog").html(result);

        $('#wordSetDialog').dialog("option", "title", 'Edit Word Set');

        $("#wordSetDialog").dialog('open');
    });
}

function deleteWordSet(id) {

    $( "#dialog-confirm" ).dialog({
        resizable: false,
        height:200,
        width: 300,
        modal: true,
        buttons: {
            "Delete word": function() {
                $.ajax({
                    url: "/wordSets/delete/" + id,
                    type: "POST",
                    success:function(response) {
                        $('#wordSet-'+id).hide()
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

    $('#wordSetDialog').dialog({

        autoOpen : false,
        position : 'center',
        modal : true,
        resizable : false,
        width : 440,
        buttons : {
            "Save" : function() {
                $('#wordSetForm').submit();
            },
            "Cancel" : function() {
                $(this).dialog('close');
            }
        },
        close : function() {

            resetDialog($('#wordSetForm'));

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