function start(response) {
    console.log("Request handler 'start' was called.");
    var body = '<html>' +
        '<head>' +
        '<meta http-equiv="Content-Type" content="text/html; ' +
        'charset=UTF-8" />' +
        '</head>' +
        '<body>' +
        '<form action="/upload" method="post">' +
        '<textarea name="text" rows="20" cols="60"></textarea>' +
        '<input type="submit" value="Submit text" />' +
        '</form>' +
        '</body>' +
        '</html>';
    response.writeHead(200, { "Content-Type": "text/html" });
    response.write(body);
    response.end()
}

function upload(response, postData) {
    console.log("Upload")
    response.writeHead(201, { "Content-type": "text-plain" })
    response.write("You Have "+postData )
    response.end()
}

function download() {
    console.log("Download")
}

function imageUpload() {
    console.log("Image Upload")
}

exports.start = start
exports.upload = upload
exports.download = download
exports.imageUpload = imageUpload