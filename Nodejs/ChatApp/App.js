// var server = require('./CreateServer')

var server = require('./Url')
var requestHandler = require('./RequestHandler')

var handle = {}
    handle["/"] = requestHandler.start
    handle["/start"] = requestHandler.start
    handle["/upload"] = requestHandler.upload
    handle["/download"] = requestHandler.download
    handle["/imageUpload"] = requestHandler.imageUpload


server.start(handle)