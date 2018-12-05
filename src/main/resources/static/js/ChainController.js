/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ChainControllerModule = (function (){
    
    var getChains = function () {
        var callback = {
            onSuccess: function (chains) {
                $("#tableSelect").empty();
                $("#tableSelect").append("<thead> <tr> <th class='col-md-1'>Chain</th> <th class='col-md-10'>Date</th> </tr> </thead>");
                for (i in chains){
                    $("#tableSelect").append("<tbody> <tr> <td> <a>"+chains[i].data+"</a> </td> <td> <a>"+chains[i].date+"</a> </td> </tr> </tbody>");
                }
            },
            onFailed: function (exception) {
                alert(exception);
                console.log("There is a problem with our servers. We apologize for the inconvince, please try again later");
            }
        };
        RestControllerModule.getChains(callback);
    };

    var postChain = function () {
        var chain = $('#chain').val();
        var callback = {
            onSuccess: function(){
                console.log("Chain created");
                getChains();
            },
            onFailed: function (exception) {
                alert(exception);
                console.log("There is a problem with our servers. We apologize for the inconvince, please try again later");
            }
        };
        RestControllerModule.postChain(chain,callback);
    };

    return {
        getChains: getChains,
        postChain: postChain
    };

})();
