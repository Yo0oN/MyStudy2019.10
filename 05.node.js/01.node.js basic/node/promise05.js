"use strict";

function getAjax(url) {
    return new Promise(function(resolve, reject){
        var XMLHttpRequest = require('xmlhttprequest').XMLHttpRequest;
        var req = new XMLHttpRequest();
        req.open('get', url);
        req.onload = function(){
            if (req.readyState == 4){
                if (req.status == 200) {
                    resolve(req.responseText);
                } else {
                    reject(Error(req.statusText));
                }
            }
        };
        req.onerror = function() {
            reject(Error("Network Error"));
        };
        req.send();
    });
}

getAjax('https://www.naver.com').then(function(response){
    console.log("Success!", response);
}, function(error) {
    console.error("Failed!", error);
})