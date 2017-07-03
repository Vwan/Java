
var table = $('#list').DataTable();
var entity="user";

$(document).ready(


    //newEntity("#new-form",entity),
    //App.entity=entity,
    //App.init(),
    init(entity),

    //newTaskAjaxCall('/tks/task/create.action'),
    btnClickAssignToProduct(),
    crudEntity("#assign-product-form",entity, '/tks/' + entity + '/assignToProduct.action'),
    btnClickEdit(),
    //btnClickDelete(entity),
    /* btnClickEdit(
        $(
        function () {
        var table = $('#list').DataTable();
        var a = [];
        $.each(table.rows('.selected').data(), function() {
            a.push(this["id"]);
            a.push(this["code"]);
            a.push(this["name"]);
        });
        alert(a);
        return a;
    })
),*/
    handleProductSelectOptions(),

    refreshTable('#list',"#bthRefresh")

);




function refreshTable(tableid,clickid){
    $(clickid).click(function(){
            var table = $(tableid).DataTable();
            table.ajax.reload();
        }
    )}


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

        { "data": "id" }, { "data": "name" },{ "data": "password" } ,{ "data": "email" } ], [ { targets: [0,1,2] }],[[ 2, "desc" ]]
    )
};


/* Select data rows and Edit */
function btnClickEdit(){
    $('#btnEdit').click( function () {
        var a= [];
        var table = $('#list').DataTable();

        $.each(table.rows('.selected').data(), function() {
            a.push(this["id"]);
            a.push(this["name"]);
            a.push(this["password"]);
            a.push(this["email"]);
        });
        //alert("Are you sure to delete?","Yes","Cancel");
        // table.rows('.selected').
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

/* Select data rows and Edit */
function btnClickAssignToProduct(){
    $('#btnAssignToProduct').click( function () {
        var a= [];
        var table = $('#list').DataTable();

        $.each(table.rows('.selected').data(), function() {
            a.push(this["id"]);
          //  a.push(this["name"]);
        });
        //alert("Are you sure to delete?","Yes","Cancel");
        // table.rows('.selected').
        var fields = $("#assign-product-form").serializeArray();
        jQuery.each( fields, function(i, field){
            $(":input[name='"+field.name+"']").val(a[i]);
            // if(field.name=="id") $(":input[name='"+field.name+"']").setAttr("disabled","true");
        });
        // $(":input[name='mark']").val("edit");

        $("#user-id").prop("disabled",true);
        $('#assign-product-entity-modal').dialog({modal:true});
    });

};

/* Select data rows and Edit
function btnClickEdit(){
    $('#btnEdit').click( function () {
        var a= [];
        var table = $('#list').DataTable();

        $.each(table.rows('.selected').data(), function() {
            a.push(this["id"]);
            a.push(this["code"]);
            a.push(this["name"]);
        });
        //alert("Are you sure to delete?","Yes","Cancel");
        // table.rows('.selected').
        var fields = $("#edit-form").serializeArray();
        jQuery.each( fields, function(i, field){
            $(":input[name='"+field.name+"']").val(a[i]);
            // if(field.name=="id") $(":input[name='"+field.name+"']").setAttr("disabled","true");
        });
        // $(":input[name='mark']").val("edit");
        $('#edit-entity-modal').dialog({modal:true});
    });*/

//}
;

/* End btnClickEdit */




