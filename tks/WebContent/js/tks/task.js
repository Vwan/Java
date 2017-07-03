
var table = $('#list').DataTable();
var entity="task";
var numberOfLanguages=10;
var taskUrl='';

$(document).ready(

    // load all languages
    handleLangSelectOptions(),

    //App.entity=entity,
    //App.init(),

    $(function(){
        var doneAllProducts=doAjaxGet("/tks/product/listAll.action").done(
            handleAjaxResponseProduct
        );//.fail(error);
        var doneAllReleases=$.when(doneAllProducts).done(
            function(){
                loadAllReleases();
            }
        );
        var doneAllTasks=$.when(doneAllReleases).done(
            getAllTasks
        );
        // $.when(doneAllTasks).done(showTaskDetails),
       // btnClickNewTaskProgress()

        /* create new task progress */
        $("#btnNewProgress").click(function () {
            $("#new-progress-modal").dialog({modal:true});
        });
        newEntity("#new-progress-form","taskprogress");
    }),


    init(entity),

    /* load product management page when clicking Admin->Product*/
    $("#product-li").click(function(){
            $("#right-panel").load("/tks/content/product/product.jsp");
            $("#left-panel-ul").html('<li class="active"><a href="#">Product <span class="sr-only">(current)</span></a></li>');
        }
    ),


   // newTaskAjaxCall('/tks/task/create.action'),
   // btnClickDelete(entity),
    //btnClickEdit(entity),
   // btnClickNewTaskProgress(),

    loadTaskProgresses(29),

    $("#btnRefreshProgress").click(function(){
            loadTaskProgresses(29);
        }
    ),

    refreshTable('#list',"#btnRefreshTasks"),

    setupSelect("#seleProductInForm")

);


/* Load Task Progresses for specific task*/
function loadTaskProgresses(taskid){
    var doneTaskProgress=doAjaxGet("/tks/taskprogress/listAll.action?task.id="+taskid).done(
        handleAjaxResponseTaskProgress
    );}

/* $(document).ready(function(){ $('#task-form').load("content/task/task-form-new.html"); });*/


/* New Task
function newTaskAjaxCall(url){
    $("#task_form").submit(
        function() {
            var formInput=$(this).serialize();
            console.log( formInput );
            $.getJSON(url, formInput,function(data) {
                $('#statusID').text(''+data.entity.id + '');
                $('#statusName').text(''+data.entity.name + '');
                $('#statusDescription').text(''+data.entity.description + '');
            });
            return false;
        }

    );

};*/

/* Select data rows and Delete (Task)
function btnClickDelete(entity){
    //  var table = $('#list').DataTable();
    $("#btnDelete").click( function () {
        $.each(table.rows('.selected').data(), function() {
            var a=[];
            a.push(this["id"]);
            a.push(this["summary"]);
            a.push(this["description"]);
            alert(a[0]);
            var formInput="id="+a[0];
            alert("Are you sure to delete?","Yes","Cancel");
            $.getJSON('/tks/'+entity+'/delete.action', formInput,function(data) {
                //$('#result').text(''+data.message + '');
                alert(data.message);
                // add check if successfully removed
                table.rows('.selected').remove().draw( false );
            });
        });
    } )};*/

/* Select data rows and Edit Tasks*/
function btnClickEdit(){
    $("#btnEdit").click( function () {
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

/* New Task Progress*/
//$(document).ready(doNewTaskProgress);
function btnClickNewTaskProgress(){
    $('#btnNewProgress').click( function () {
        var taskId=$(this).closest('td').data('id');
      //  alert("taskid is:"+taskid);
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

       // $("#entity-id").prop("disabled",true);
        $('#new-progress-modal').dialog({modal:true});
    });

};

/* Start New Task Progress
function newTaskProgress(entity){
    $("#new-progress-form").submit(function()
    {
        var formInput=$(this).serialize();
        console.log("---form input data--");
        console.log( formInput );
        $.getJSON('/tks/'+entity+'/create.action', formInput,function(data) {
            console.log("....tasks list ...");
            console.log(data);
            $('.entity-id').text(''+data.entity.id + '');
            $('.result').text(''+data.message + '');
        });
        return false;
    });
};*/

/* Delete Task from modal */
$('#confirmDeleteModal').find('.modal-footer #confirm-delete-ok').click(function (e) {
    e.preventDefault();
    var id = $('#confirmDeleteModal').data('id');
    $('[data-id="' + id + '"]').closest('tr').remove();
    $('#confirmDeleteModal').modal('hide');
    return true;
});
/* end Delete */

/* retrieve all languages and dynamic create select options
function getAlllangs(){
    return $.ajax({
        type:"get",
        url:"/tks/lang/listAll",
        dataType:"json",
        success: function (data) {
            var str=$('<select id ="seleInForm" title="Basic example" multiple=" multiple" list="languages"  name="listSelected" value="listSelected" listKey="id" listValue="label"emptyOption="true">');
            $.each(data,function(index){
                var option=$('<option value="'+data[index].code+'" name="code">'+data[index].code+'</option>');
                option.appendTo(str);
            });
            $("#languagesInForm").html(str     );
        }})
};
 */

/* select options in Form
 $(function (){
 $("select").multiselect({
 noneSelectedText: "Please select",
 checkAllText: "All Selected",
 uncheckAllText: 'None Selected',
 selectedList:numberOfLanguages
 });
 })
 );*/


/* retrieve all produts and dynamically populate the Product dropdown list on the Header panel*/
function handleAjaxResponseProduct(data){

    var rootTag=$('<div>');
    data=data.entities;
   // alert(JSON.stringify(data));
    $.each(data,function(index){
        var option=$(' <h4><li><a href="#" id="product-'+data[index].name+'">'+data[index].name+'</a></li></h4>');
        option.appendTo(rootTag);
        console.log("---product li rootTag--");
        console.log(rootTag);
        // $("#"+tagIdPrefix+"-list").html(rootTag   );
    });
    $("#product-list").html(rootTag   );
}

/* retrieve all releases for selected product and dynamically populate the Product dropdown list on the Left panel*/
function handleAjaxResponseRelease(data){
    var rootTag=$('<div align="right">');
    $.each(data,function(index){
        var option=$('<h5><li><a href="#" id="release-'+data[index].name+'"><i class="glyphicon center"></i>'+data[index].name+'</a></li></h5>');
        option.appendTo(rootTag);
        console.log("---product li rootTag--");
        console.log(rootTag);
        // $("#"+tagIdPrefix+"-list").html(rootTag   );
    });
    $("#release-list").html(rootTag   );
}

/* Load Release list on the left panel*/
function loadAllReleases(){
    var firstProduct=$('#product-list div li a').first().text();
    //     alert("firstProduct is:"+firstProduct);
    var getAllReleases=doAjaxGet("/tks/release/listAllByProduct?entity.product.name="+firstProduct).done(handleAjaxResponseRelease);
    $('#product-list div li a').each(function(){
        var product=$(this).text();
        //  alert("before click: product is:"+product);
        $(this).click(function(){
            // alert("product is:"+product);
            var getAllReleases=doAjaxGet("/tks/release/listAllByProduct?entity.product.name="+product).done(handleAjaxResponseRelease);

            /* if (typeof(callback)=="function"){
             $.when(getAllReleases).done(callback);
             }*/

        });
    });
};


//  $.when($.when(doneAllProducts).done(function(){loadAllReleases()})).done(function(){getAllTasks()});

/* Load Task list for selected release on the left panel*/
function getAllTasks(){
    var firstRelease=$('#release-list div li a').first().text();
    //  alert("first release is:"+firstRelease);
    loadTableData("/tks/task/listAllByRelease?entity.release.name=uft 12.54");//+firstRelease);
    $('#release-list div li a').each(function(){
        var release=$(this).text();
        //alert(release);
        $(this).click(function(){
           // alert(release);
            loadTableData("/tks/task/listAllByRelease?entity.release.name="+release);
        });
    });
};


/* fill task table*/
function loadTableData(url ){
    var datalist= fillDataTable ("#list",url//"/tks/"+entity+"/listAll"
        ,[
            {
                "className":      'details-control',
                "orderable":      false,
                "data":           null,
                "defaultContent": ''//<i class="glyphicon glyphicon-expand"/>'
            },
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

            { "data": "id"},
            { "data": "summary" },
            { "data": "description" },
            { "data": "taskStatus.name","className": "taskStatus_name" },
            { "data": "release.name" },
            { "data": "user.name" ,"className":"hidden-xs"},
            { "data":"release.languages"}//"languages[0].code" }
        ],
        [
            {
                "targets": 9,
                "data": "release.languages",
                "render": function ( data, type, full, meta ) {
                    alert(JSON.stringify(data));
                    // data=["test1","test3"];
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
                }},
            {
                "targets": 8,
                "data": "release.product.users",
                "render": function ( data, type, full, meta ) {
                    // data=["test1","test3"];
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
                    else if (data!==undefined){
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

// Add event listener for opening and closing details
function handleAjaxResponseTaskProgress(data){
    var tableq = $('#list').DataTable();
   // table.ajax.reload();
    var htmlstr= taskProgressCRUDHtml+'<table cellpadding="5" cellspacing="100" border="0" style="padding-left:50px;">';

     // alert(htmlstr);
    $('#list tbody').on('click', 'td.details-control', function (){

        var tableq = $('#list').DataTable();
        var tr = $(this).closest('tr');
        var td = $(this).closest('td');
        var row = tableq.row(tr);

        console.log(tr);
        console.log(td);
        console.log(row);
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
            td.removeClass('shown');
        }
        else {
          //  alert(htmlstr);
            // load task progresses for the row
            console.log("1------");
            console.log(data);
         //   alert(data);
            $.each(data,function(index){
                //  alert(data[index].id);
                alert(JSON.stringify(data));
                var d=data[index];
                if(d!==null || d.indexOf("Error")<0) {
                    alert("d is:"+d);
                    htmlstr = htmlstr + '<tr>' +
                        '<td>' + d.id + '</td>' +
                        '<td>' + new Date(Date.parse(d.createdOn, "yyyy-mm-dd")).toDateString() + ': </td>' +
                        '<td>' + d.details + '</td>' +
                        '<td>' + d.notes + '</td>' +
                        '</tr>';
                }});
            htmlstr = htmlstr +'</table>';

         //   alert(htmlstr);
            // Open this row
            row.child(  htmlstr).show();
            //row.child(format(row.data())).show();
            tr.addClass('shown');
            td.addClass('shown');
            tr.addClass('shown');
        }
    });
};


function heredoc(fn) {
    return fn.toString().split('\n').slice(1,-1).join('\n') + '\n'
}
var taskProgressCRUDHtml = heredoc(function(){/*
 <a id="btnNewProgress" href="#new-progress-modal" role="button" class="btn" data-toggle="modal" title="Click to add more"><i class="glyphicon glyphicon-plus-sign"></i></a>
 <a id="btnEditProgress" href="#edit-progress-modal" role="button" class="btn" data-toggle="modal" title="Click to edit selected row"><i class="glyphicon glyphicon-edit"></i></a>
 <a id="btnDeleteProgress" href="#confirmDeleteModal" role="button" class="btn" ><i class="glyphicon glyphicon-trash"></i></a>
 <a id="btnRefreshProgress" role="button" class="btn" ><i class="glyphicon glyphicon-refresh"></i></a>
 */})



