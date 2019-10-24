var http = require('http')
function start() {
    function onRequest(request, response) {
        response.writeHead(201, { "Content-type": "text-plain" })
        response.write("My name is Tejas Malik")
        response.end();
    };
    var server = http.createServer(onRequest)
    server.listen(8888)
    console.log("Server started on port number: 8888")
}

exports.start = start