var http = require('http')
var url = require('url')
var router = require('./Router')
function start(handle) {
    function onRequest(request, response) {

        var postData = ""
        var pathname = url.parse(request.url).pathname


        if(request.url === '/favicon.ico') {

            response.writeHead(200, { "Content-type": "image/x-icon" });
            response.end()
            return;

        }

        request.setEncoding("utf-8")

        request.addListener("data", function(postDataChunk){
            postData += postDataChunk
            console.log("Post Data Chunk "+postDataChunk)
        })

        request.addListener("end", function() {
            console.log("Completed")
            router.route(pathname, handle, response, postData)
        })

        // response.writeHead(201, { "Content-type": "text-plain" })
        // console.log("The requested current url is: "+pathname)
        // router.route(pathname, handle, response)
        // response.write("My name is Tejas Malik")
        // response.end();
    };
    var server = http.createServer(onRequest)
    server.listen(8888)
    console.log("Server started on port number: 8888")
}

exports.start = start