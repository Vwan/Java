/**
Core script to handle the entire layout and base functions
**/

'use strict';

var App = function () {

    return {
        //main function to initiate template pages
        init: function () {


        }

    }
}();


/* initizalize common actions */
function init(entity){
    $.fn.dataTable.ext.errMode = 'throw';

    if(typeof loadTable==="function") loadTable();

    /* Invoke eidt form modal and edit entities */
    btnClickDelete(entity);

    /* Invoke eidt form modal and edit entities */
   // editEntity("#edit-form",entity);
    /* Invoke new form modal and create new entity*/

    //    newEntity("#new-form",entity);
    $("#btnNew").click(function () {
        $("#new-entity-modal").dialog({modal:true});
    });
    crudEntity("#new-form",entity,'/tks/' + entity + '/create.action');
    // below line to be overrwiteen in each page
    btnClickEdit();
    if(entity!=="release" || entity !=="task") {
        crudEntity("#edit-form", entity, '/tks/' + entity + '/update.action');
        crudEntity("#delete-form", entity, '/tks/' + entity + '/delete.action');
    }
    /* refresh data table when modal closed */
    refreshTableOnCloseModal();

    /* refresh datable when click refresh button */
    refreshTable('#list',"#bthRefresh");

    //   newStatusAjaxPost("/tks/user/create.action");

    /* global style change */
    $("label").addClass(" text-success");
    $("h4").addClass(" text-success");
    $("h5").addClass(" text-success");
    $("th").addClass(" text-success");
    $(".text-primary").addClass("animated shake");
    $(".panel-title").parent().css("background-clor","green");
    $(".navbar-brand").parent().css("background-clor","green");
    $('input:button').addClass("btn-success");
    $('input:submit').addClass("btn-success");

    /* load delete modal on page loading */
    //$('.delete-modal').load("/tks/content/delete-modal.html");
}

/* Post New Entity */
function  newStatusAjaxPost(url){
    $("#new-form").submit(function(e)
    {
      //  e.preventDefault();
        var formInput=$(this).serializeArray();
        console.log( formInput );
        var str={
            name: "tst",
            password: "fjoe",
            email: "em"
        };
        $.ajax({
            type:"POST",
            contentType:"application/json; charset=utf-8",
            url: url,//"/tks/product/listAll",
            dataType:"json",
            data: formInput,// JSON.stringify(data),
            success: function (jsonResult) {
             //   alert(jsonResult);
            }

        });
       // doAjaxPost(url,data);
        $('.entity-id').text(''+data.entity.id + '');
        $('.result').text(''+data.message + '');
    });
    return false;
};


/* regresh data after modal close */
function refreshTableOnCloseModal() {
    /* Close modal and refresh page  or data table*/
    $('body').on('hidden.bs.modal', '.modal', function () {
        var table=$("#list").dataTable;
        table.ajax.reload();
        //document.location.reload(); // refresh page
        //loadTable(); // refresh data table only
    });
}

function refreshTable(tableid,clickid){
$(clickid).click(function(){
        var table = $(tableid).DataTable();
        table.ajax.reload();
    }
)}


/* Select data rows and Edit
function btnClickEdit(a){
    $('#btnEdit').click( function () {

        var fields = $("#edit-form").serializeArray();
        jQuery.each( fields, function(i, field){
            $(":input[name='"+field.name+"']").val(a[i]);
            // if(field.name=="id") $(":input[name='"+field.name+"']").setAttr("disabled","true");

        });
        // $(":input[name='mark']").val("edit");

        $("#entity-id").prop("disabled",true);
        $('#edit-entity-modal').dialog({modal:true});
    });

};*/

/* Start New Entity - Ajax GET
function newEntity(clickid,entity){
    $(clickid).submit(function()
    {
        var formInput=$(this).serialize();
        console.log("---form input data--");
        console.log( formInput );
        $(function() {
                doAjaxGet('/tks/' + entity + '/create.action', formInput);

            }
            );
        return false;
    });
};*/

/* Convert form data to JSON */
function formData2Json(clickid){
        var formArray = $(clickid).serializeArray();
                $('input[disabled]').each( function() {
                    //formInput = formInput + '&' + $(this).attr('name') + '=' + $(this).val();
                    formArray.push($(clickid).val());
                });
          var jsonObj = {};
          $.each(formArray,
              function(i, v) {
                  jsonObj[v.name] = v.value;
              });
              var jsonObjNew={};
              jsonObjNew["entity"]=jsonObj;
              console.log(jsonObjNew);
              return jsonObjNew;
}

/* ajax call POST*/
function doAjaxPost(url,formdata){
     $.ajax({
        type:"POST",
        contentType:"application/json; charset=utf-8",
        url: url,
         data: JSON.stringify(formdata),
        dataType:"json"
      /*   beforeSend: function(request) {
             request.setRequestHeader("Accept", "application/json");
         },*/
    }).done(function (data) {
       // alert(JSON.stringify(data));
        // alert(data.message);
              if(url.indexOf("task") < 0){
                  $('.result').html('<label class="text-success"><i class="glyphicon glyphicon-ok">'+data.message + '</label>');
              }
          })
              .fail(function (data) {
                  console.log(data);
                  console.log(data.message);
                  if(url.indexOf("task") < 0){
                      $('.result').html('<label class="text-danger"><i class="glyphicon glyphicon-exclamation-sign"> '+data.responseJSON.message + '</i></label>');
                  }
              });
}


function doAjaxGet(url,formInput){
    //alert(url);
    return $.getJSON(url, formInput,function(data) {
        console.log("....tasks list ...");
        console.log(data);

    }).done(function (data) {
        if(!(/task/i.test(url))){
            $('.result').html('<label class="text-success"><i class="glyphicon glyphicon-ok">'+data.message + '</label>');
        }
    })
        .fail(function (data) {

            console.log(data);
            console.log(data.message);
            if(!(/task/i.test(url))){
                $('.result').html('<label class="text-danger"><i class="glyphicon glyphicon-exclamation-sign"> '+data.responseJSON.message + '</i></label>');
            }
        });
}

/* ajax call GET*/
function doAjaxGet(url){
    return $.ajax({
        type:"get",
        url: url,//"/tks/product/listAll",
        dataType:"json"
    });
}

/* Start Edit Task */
function editEntity(clickid,entity){
   /* $(clickid).submit(function()
    {
       console.log(formInput);
                var data =formData2Json(clickid);
                console.log("***********form input******");
                console.log( data );
        $(function(){
       // doAjaxGet('/tks/'+entity+'/update.action',formInput)
       doAjaxPost('/tks/' + entity + '/create.action', data);
        });
        return false;
    });*/
     $(clickid).submit(function()
        {
           // var formInput=$(this).serialize(); // for Get method
            var data =$(function() {formData2Json(clickid)});
            console.log("***********form input******");
            console.log( data );
            $(function() {
                    doAjaxPost('/tks/' + entity + '/create.action', data);
                }
            );
            return false;
        });
};

/* End Edit Task */
/* Start New Entity */
function newEntity(clickid,entity){
    $(clickid).submit(function () {
        var formInput = $(clickid).serialize();
        console.log("****do get ****");
        console.log(formInput);
        doAjaxGet('/tks/'+entity+'create.action',formInput);
    });
};

/* Start CRUD Entity */
function crudEntity(clickid,entity,url){
    $(clickid).submit(function()
    {

        var jsonObjNew={};
        var formArray = $(clickid).serializeArray();
        alert(JSON.stringify(formArray));
       // console.log(formArray);
                       $('input[disabled]').each( function() {
                           //formInput = formInput + '&' + $(this).attr('name') + '=' + $(this).val();
                           //alert($(this).val());
                           var di = {"name":"id","value":$(this).val()};
                           formArray.push(di);
                           alert(JSON.stringify(formArray));
                       });
       // alert(JSON.stringify(formArray));
                 var jsonObj = {};
                 var listSelected=[];
                 $.each(formArray,
                     function(i, v) {
                            if (v.name.indexOf(".") >= 0) {
                          //  alert(v.name);
                                var substr = v.name.split(".");
                                var tempObj = {};
                                 tempObj[substr[1]] = v.value;
                                jsonObj[substr[0]]=tempObj;
                            }
                         else if(v.name==="listSelected"){
                             listSelected.push(v.value);
                            }
                            else if(v.name==="statusListSelected"){
                                jsonObjNew["statusListSelected"]=v.value;
                            }
                          else   jsonObj[v.name] = v.value;
                     });

        jsonObjNew["listSelected"]=listSelected;
                     jsonObjNew["entity"]=jsonObj;
        console.log("***********form input******");
        console.log( jsonObjNew );
      //  $(function() {
    //  jsonObjNew={"entity":{"name":"fjfefeefff grffeffesfeefefoe","description":"fjoe","product":{"name":"test"} }};
                doAjaxPost(url, jsonObjNew);
       //     }
       // );
        return false;
    });
};

/* End CRUD Entity */

/* Select data rows and Delete */
function btnClickDelete(entity) {
    $('#confirm-delete').on('click', '.btn-ok', function (e) {
        var $modalDiv = $(e.delegateTarget);
        // $.ajax({url: '/api/record/' + id, type: 'DELETE'})
        // $.post('/api/record/' + id).then()
        $modalDiv.addClass('loading');
        setTimeout(function () {
            $modalDiv.modal('hide').removeClass('loading');
        }, 1000);

        var table = $('#list').DataTable();
            var formInput="";
        $.each(table.rows('.selected').data(), function () {
            formInput="";
            var a = [];
            a.push(this["id"]);
            //  a.push(this["summary"]);
            //a.push(this["description"]);
             formInput = {"entity":{"id":a[0]}};//"id="+a[0];
                console.log(JSON.stringify(formInput));
                //alert(formInput);
                $('#confirm-delete').on('show.bs.modal', function(e) {
                    var data = $(e.relatedTarget).data();
                    console.log("-----confirm delete---");
                    $('.id-to-be-deleted').text(formInput);
                });

                // alert ("formInput is "+formInput);
               /* $.getJSON('/tks/' + entity + '/delete.action', formInput, function (data) {
                    //$('#result').text(''+data.message + '');
                    // add check if successfully removed
                    table.rows('.selected').remove().draw(false);
                }).done(function (data) {
                    alert(data.message);

                })
                    .fail(function (data) {
                        alert(data.responseJSON.message);
                    });
            }
        );*/
        doAjaxPost("/tks/" + entity + "/delete.action",formInput);
});
});
}



/*
$('#confirmDeleteModal').find('.modal-footer #confirm-delete-ok').click(function (e) {
    e.preventDefault();
    var id = $('#confirmDeleteModal').data('id');
    $('[data-id="' + id + '"]').closest('tr').remove();
    $('#confirmDeleteModal').modal('hide');
    return true;
});
/* end Delete */


function fillDataTable(clickID, url,columnArray, columnDefsArray,order){
    var id;
    var responsedata;
    var table=$(clickID).dataTable({
        "destroy":true,
        "deferRender": true,
      //  "fnInitComplete": function (oSettings, json) {
       // },
        "ajax": /*ajaxCall(url) */
        {
            "cache":false,
            "type": 'GET',
            "url": url,
            "dataType":"json",
            "dataSrc": function (json) {
               // alert(JSON.stringify(json));
                 //  alert(json.entities);
                responsedata=JSON.stringify(json.entities);
                console.log("*******resp");
                console.log(responsedata);
                return $.parseJSON(responsedata);
            },
            "async": true/*,
         "success": function (data) {
         console.log("........");
         responsedata = data;
         console.log(responsedata);
         console.log(url);
         console.log("yes or no:" + url.indexOf("release"));
         if (url.indexOf("release") >= 0)
         console.log(responsedata);
         callbackRelease(responsedata);
         },
         "error": function () {
         alert("something went wrong");
         }*/
        }  ,
        "select": {
            "style": 'multi'
        },
        "dom": 'Bfrtip',
        "buttons": [
            'selectAll',
            'selectNone'
        ],
       // "processData": false,
        "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
           /* console.log(nRow);
            console.log("**** aData *****");
            console.log(JSON.stringify(aData));*/
            $('tr:eq(0)', nRow).attr("data-id",iDisplayIndexFull);
            $('td:eq(1)', nRow).attr("data-id",iDisplayIndexFull);
            $('td:eq(2)', nRow).attr("data-id",iDisplayIndexFull);
            $('td:eq(3)', nRow).attr("data-id","id-"+aData.id);
        },
        "columnDefs": columnDefsArray,
        "columns": columnArray,
        "order": order,
        "bLengthChange":true,
        "bFilter": true,
        "bAutoWidth": true
    });
    console.log("responsedata------");
    console.log(responsedata);
    return responsedata;
}

/*function ajaxCall(url){
 var datalist;
 $.ajax({
 "dataType": "json",
 "contentType": "application/json; charset=utf-8",
 "type": "POST",
 "url": url,
 "async": "false",
 "dataSrc": function (json) {
 console.log(json);
 datalist= $.parseJSON(JSON.stringify(json));
 return datalist;
 },
 "success": function (data) {
 console.log("........");
 //datalist = data;
 console.log(datalist);
 console.log(url);
 console.log("yes or no:" + url.indexOf("release"));
 if (url.indexOf("release") >= 0) {
 console.log(data);
 callbackRelease(data);
 }
 }
 /*$('#employee-list').html("Please select Employee under Department:      <select name = \"employee\"></select>");
 $.each(list, function(index, data){
 $('#employee-list select').html("<option value = "+data.empID+">"+data.givenName+"</option>");
 });
 ,
 "error": function(){
 alert("something went wrong");
 }
 })
 console.log("------datalist in ajaxCall function");
 console.log(datalist);
 return datalist;
 }
 */
function callbackRelease(data) {
    var langlist=data[1].languages;
    console.log("langlist is:"+langlist);
    $.each(langlist,function(index){
        console.log("lang is: "+langlist[index]+",");
    });
}

function refreshTableOnCloseModal(){
    /* Close modal and refresh page  or data table*/
    $('body').on('hidden.bs.modal', '.modal', function () {
        $('#list').DataTable().ajax.reload();
        //document.location.reload(); // refresh page
        //loadTable(); // refresh data table only
    });
}

function markStatus() {
    $('#status_name').each(function() {
        var lastColumn = $(this).html();

        var replaceValue = lastColumn.Append("Changed Content");

        $(this).html(replaceContent);
    });
};


/* retrieve all languages and dynamic create select options*/
//$(document).ready(
function handleLangSelectOptions(){
    $.ajax({
        type:"get",
        url:"/tks/lang/listAll",
        dataType:"json",
        //success: function (data) {
    }).done(function (data) {
            //  alert(JSON.stringify(data));
            var str=$('<select id ="seleLangInForm" title="" multiple="multiple" list="languages"  name="listSelected" value="listSelected" listKey="id" listValue="label" emptyOption="true">');
            data=data.entities;
            $.each(data,function(index){
                var option=$('<option value="'+data[index].code+'" name="code">'+data[index].code+'</option>');
                option.appendTo(str);
            });
            $("#languagesInForm").html(str     );
       // if(typeof setupSelect==="function") setupSelect();
        }

    )
}

/* retrieve all languages and dynamic create select options*/
//$(document).ready(
function handleProductSelectOptions(){
    setupSelect();
    $.ajax({
        type:"get",
        url:"/tks/product/listAll",
        dataType:"json",
        //success: function (data) {
    }).done(function (data) {
            //  alert(JSON.stringify(data));
            var str=$('<select id ="seleProductInForm" title="" multiple="multiple" list="product"  name="listSelected" value="listSelected" listKey="id" listValue="label" emptyOption="true">');
            data=data.entities;
            $.each(data,function(index){
                var option=$('<option value="'+data[index].name+'" name="code">'+data[index].name+'</option>');
                option.appendTo(str);
            });
            $("#productInForm").html(str     );

        }

    )
}



function setupSelect(clickid){
    $(clickid).multiselect({
        noneSelectedText: "Please select",
        checkAllText: "All Selected",
        uncheckAllText: 'None Selected',
        // selectedList:numberOfLanguages
    });
};


//)