
var table = $('#list').DataTable();
var entity="taskstatus";

$(document).ready(


    //newEntity("#new-form",entity),
    //App.entity=entity,
    //App.init(),
    init(entity),

    //newTaskAjaxCall('/tks/task/create.action'),

    //btnClickDelete(entity),
    btnClickEdit(),
    refreshTable('#list',"#bthRefresh")

);


function refreshTable(tableid,clickid){
    $(clickid).click(function(){
            var table = $(tableid).DataTable();
            table.ajax.reload();
        }
    )}

/* Select data rows and Edit */
function btnClickEdit(){
    $('#btnEdit').click( function () {
        var table = $('#list').DataTable();

        var a= [];
        $.each(table.rows('.selected').data(), function() {

            a.push(this["id"]);
            a.push(this["name"]);
            a.push(this["description"]);
        });
        //alert(a);
        var fields = $("#edit-form").serializeArray();
        jQuery.each( fields, function(i, field){
            $(":input[name='"+field.name+"']").val(a[i]);
            // if(field.name=="id") $(":input[name='"+field.name+"']").setAttr("disabled","true");

        });
        // $(":input[name='mark']").val("edit");

        $("#entity-id").prop("disabled",true);
        $('#edit-entity-modal').dialog({modal:true});
    });

};

/* Start Edit Entity
$(function(){
    $("#edit-form").submit(function()
    {
        var formInput=$(this).serialize();
        $.getJSON('/tks/'+entity+'/update.action', formInput,function(data) {
            $('.result').text(''+data.message + '');
        });
        return false;
    });
});
/* End btnClickEdit */

/* Start New Entity
$(function(){
    $("#new-form").submit(function()
    {
        var formInput=$(this).serialize();
        console.log( formInput );
        $.getJSON('/tks/'+entity+'/create.action', formInput,function(data) {
            console.log("---response from update action--");
            console.log(data);
            $('.entity-id').text(''+data.entity.id + '');
            $('.result').text(''+data.message + '');
        });
        return false;
    });
});
//  Delete from Modal
 $("#list").ready(function(){
 $("#btnDelete").click(function(){ // Click to only happen on announce links
 $("#list").bootstrapTable();
 $("#rowID").text("row");//$(this).closest('td').data('id'));
 $('#confirmDeleteModal').modal('show');
 $('#confirmDeleteModal').on('show.bs.modal', function(event) {
 $("#rowID").text("ro1w");//$(event.relatedTarget).data('id'));
 });
 });
 });
 */


/* fill task table*/
function loadTable( ){
    table= fillDataTable ("#list","/tks/"+entity+"/listAll",[
        {
            data: null,
            defaultContent: '',
            className: 'select-checkbox',
            orderable: false
        },
        {
            "orderable":      false,
            "data":           null,
            "defaultContent":''
            //"defaultContent": '<a id="Edit" href="#confirmDeleteModalContainerNew" role="button" class="btn" data-toggle="modal">Edit</a>'
            // "defaultContent":'<a id="btnEdit" href="#confirmDeleteModalContainerNew" role="button" class="btn" data-toggle="modal"><i class="glyphicon glyphicon-edit"></i></a>'
        },

        { "data": "id" }, { "data": "name" },{ "data": "description" } ], [ { targets: [0,1,2] }],[[ 2, "desc" ]]
    )
};





