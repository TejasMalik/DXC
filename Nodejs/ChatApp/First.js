var http = require('http')
var server = http.createServer(function (request, response) {
    response.writeHead(201, { "Content-type": "text-plain" })
    response.write("My name is Tejas Malik")
    response.end();
});
server.listen(8888)
console.log("Server started on port number: 8888")