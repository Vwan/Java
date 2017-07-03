
        function fillDataTable(clickID, url,columnArray, columnDefsArray){
            $(clickID).dataTable({
                                   "ajax": {
                                           "dataType": 'json',
                                           "contentType": "application/json; charset=utf-8",
                                           "type": "POST",
                                           "url":url,
                                           "dataSrc": function (json) {
                                                 return $.parseJSON(JSON.stringify(json.entity));
                                           }
                                       },
                                       "columnDefs": columnDefsArray,
                                       "columns": columnArray,
                                       "order": [[ 1, "desc" ]],
                                       "bLengthChange":true,
                                       "bFilter": true,
                                       "bAutoWidth": true
        });
        }

