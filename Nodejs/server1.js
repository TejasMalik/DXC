var http = require("http");
var url = require('url');
var router = require("./router");

function start(portNumber, route, handle) {
    function onRequest(req, res) {
        // res.writeHead(201,{"Content-type": "text-plain"})
        var pathname = url.parse(req.url).pathname
        // console.log("1.The requested current url is:" + pathname)
        // route(pathname,handle,res)
        // console.log("3.The requested current url is:" + pathname)
        // res.write("Your name is Brettly")
        // res.end()

        var i = 0;
        var postData = " ";
        req.setEncoding("utf8")
        req.addListener("data", function (postDataChunk) {
            postData += postDataChunk;
            console.log("########## Post data chunk" + postDataChunk + "")

            i++;
            var fs = require("fs")
            fs.writeFileSync("File" + i + ".txt", postDataChunk);

        });
        //  for(var j=0;j<i;j++){
        //     var fs = require("fs")
        //     var fileData = fs.readFileSync("takeHomeSalary.txt","utf8")
        //     console.log(fileData);
        //     fs.writeFileSync("data.txt"+j,fileData);
        //  }

        req.addListener("end", function () {
            console.log("$$$$$$$$$$ Finished Data  reading")
            route(pathname, handle, res, postData)
        })
    }
    var server = http.createServer(onRequest)
    server.listen(portNumber);
    console.log("server started on port number:" + portNumber)
}

exports.start = start