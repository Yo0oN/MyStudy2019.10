const http = require('http');

console.log('start');
http.createServer(function(request, response){
    response.writeHead(200, {'Content-Type' : 'text/html'});
    response.end('<h1>Hello NodeJS</h1>');

    console.log('....ing');
}).listen(3000);
console.log('end')

