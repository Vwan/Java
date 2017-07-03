
function getJSON_Lang(actionName){
                        var formInput=$(this).serialize();
                         console.log( formInput );
                        $.getJSON(actionName, formInput,function(data) {
                        $('#LanguageID').text(''+data.Language.id + '');
                        $('#LanguageCode').text(''+data.Language.langCode + '');
                        $('#LanguageName').text(''+data.Language.langName + '');
                              });
                          return false;
                           }

function getJSON_Status(actionName){
                        var formInput=$(this).serialize();
                         console.log( formInput );
                        $.getJSON(actionName, formInput,function(data) {
                        $('#statusName').text('result i ' + data.success+'<br>name i '+data.entity.name + '<br>description i '+data.entity.description + '');
                                                $('#statusID').text(''+data.entity.id + '');
                                                $('#statusName').text(''+data.entity.name + '');
                                                $('#statusDescription').text(''+data.entity.description + '');
                              });
                          return false;
                           }