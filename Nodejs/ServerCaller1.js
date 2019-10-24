var server = require('./server')
var router = require('./router')
var requestHandlers=require('./RequestHandler')



var handle = {}
handle["/"] = requestHandlers.start
handle["/start"] = requestHandlers.start
handle["/upload"] = requestHandlers.upload
handle["/download"] = requestHandlers.download
handle["/imageUpload"] = requestHandlers.imageUpload


server.start(8888,router.route,handle)
