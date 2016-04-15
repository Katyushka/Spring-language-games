function addWord() {
    $('#wordDialog').dialog("option", "title", 'Добавить слово');
    $('#wordDialog').dialog('open');
}

function editWord(id) {

    $.get("/words/get/" + id, function(result) {

        $("#wordDialog").html(result);

        $('#wordDialog').dialog("option", "title", 'Edit Word');

        $("#wordDialog").dialog('open');
    });
}

function deleteWord(id) {

    $( "#dialog-confirm" ).dialog({
        resizable: false,
        height:200,
        width: 300,
        modal: true,
        buttons: {
            "Delete word": function() {
                $.ajax({
                    url: "/words/delete/" + id,
                    type: "POST",
                    success:function(response) {
                        $('#word-'+id).hide()
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

    $('#wordDialog').dialog({

        autoOpen : false,
        position : 'center',
        modal : true,
        resizable : false,
        width : 440,
        buttons : {
            "Сохранить" : function() {
                $('#wordForm').submit();
            },
            "Отменить" : function() {
                $(this).dialog('close');
            }
        },
        close : function() {

            resetDialog($('#wordForm'));

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