/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var RestControllerModule = (function () {

    var getChains = function (callback) {
        axios.get('/request')
            .then(function (request){
                callback.onSuccess(request.data);
            })
            .catch(function (error) {
                callback.onFailed(error);
            });
    };

    var postChain = function (chain, callback) {
        axios.post('/request',chain)
            .then(function (response) {
                callback.onSuccess(response.data);
            })
            .catch(function (error) {
                callback.onFailed(error);
            });
    };

    return {
        getChains: getChains,
        postChain: postChain
    };
    
})();
