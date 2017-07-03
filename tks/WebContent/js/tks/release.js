
var table = $('#list').DataTable();
var entity="release";

$(document).ready(


    //newEntity("#new-form",entity),
    //App.entity=entity,
    //App.init(),
     handleLangSelectOptions(),
    init(entity),

    //newTaskAjaxCall('/tks/task/create.action'),

    btnClickEdit(),
    //newEntity("new-form",entity),
    //handleLangSelectOptions(),
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

    //$("#selaInTable").multiselect(),

    refreshTable('#list',"#bthRefresh"),

setupSelect("#seleLangInForm")

);


function refreshTable(tableid,clickid){
    $(clickid).click(function(){
            var table = $(tableid).DataTable();
            table.ajax.reload();
        }
    )}


/* fill task table*/
function loadTable( ){
    var datalist= fillDataTable ("#list","/tks/"+entity+"/listAll",[
            {
                data: null,
                defaultContent: '',
                className: 'select-checkbox',
                orderable: false
            },
            {
                "orderable":      false,
                "data":           null,
                "className": "hidden-xs",
                "defaultContent":''
                //"defaultContent": '<a id="Edit" href="#confirmDeleteModalContainerNew" role="button" class="btn" data-toggle="modal">Edit</a>'
                // "defaultContent":'<a id="btnEdit" href="#confirmDeleteModalContainerNew" role="button" class="btn" data-toggle="modal"><i class="glyphicon glyphicon-edit"></i></a>'
            },

            { "data": "id" },
            { "data": "name" },
            { "data": "description" },
            { "data": "product.name" },
            {
                //"data":'<select id="example-getting-started" multiple="multiple"> <option value="languages[0].code">languages[0].code</option><option value="tomatoes">Tomatoes</option><option value="mozarella">Mozzarella</option></select>',
                /* "data":function(data){$.each(data,function(index){
                 var str;
                 str=str+","+data[index];
                 return str;
                 })
                 }*/
                //,
                //  "defaultContent": '<select id="example-getting-started" multiple="multiple"> <option value="languages[0].code">languages[0].code</option><option value="tomatoes">Tomatoes</option><option value="mozarella">Mozzarella</option></select>'
                "data":"languages"}//"languages[0].code" }
        ],
        [ {
            "targets": 6,
            "data": "description",
            "render": function ( data, type, full, meta ) {
                //  data=["test1","test3"];
                console.log("----data---");
                console.log(data);
                console.log($.isArray(data));
                var str="";
                /* reserved; This is to put select multi options control in Languages cell
                 var selectStr='<select id ="selaInTable" title="Basic example" multiple="multiple" list="languages"  name="listSelected" value="listSelected" listKey="id" listValue="label" emptyOption="true">';
                 if($.isArray(data)){
                 $.each(data,function(index){
                 console.log("----render---");
                 console.log(data[index]);
                 selectStr= selectStr + '<option value="" name="code">'+data[index].code+'</option> ';
                 });
                 }
                 else{
                 selectStr= selectStr + '<option value="">'+data+'</option> ';
                 }
                 selectStr = selectStr + '</select>';
                 */
                if($.isArray(data)){
                    $.each(data,function(index){
                        console.log("----render---");
                        console.log(data[index]);
                        str= str+ data[index].name + ", ";
                    });
                }
                else{
                    str= str  +data.name+ ", ";
                }
                return str;
            }}]  ,
        [[ 2, "desc" ]]
    )
    console.log("datalist------");
    console.log(datalist);
    return datalist;
};

/* Select data rows and Edit */
function btnClickEdit(){
    $('#btnEdit').click( function () {
        var a= [];
        var table = $('#list').DataTable();

        $.each(table.rows('.selected').data(), function() {
            a.push(this["id"]);
            a.push(this["name"]);
            a.push(this["description"]);
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

/* reserved; check all options in Table Select Multi
 $("#selaInTable").multiselect();
 $("#selaInTable").multiselect("checkAll");*/




