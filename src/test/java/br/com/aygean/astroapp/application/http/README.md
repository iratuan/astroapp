## Usage

#### Extensão recomendada
[@ext:humao.rest-client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client)

In editor, type an HTTP request as simple as below:
```
https://example.com/comments/1
```
Or, you can follow the standard RFC 2616 that including request method, headers, and body.

```
POST https://example.com/comments HTTP/1.1
content-type: application/json

{
    "name": "sample",
    "time": "Wed, 21 Oct 2015 18:27:50 GMT"
}

```
Once you prepared a request, click the Send Request link above the request (this will appear if the file's language mode is HTTP, by default .http files are like this), or use shortcut Ctrl+Alt+R(Cmd+Alt+R for macOS), or right-click in the editor and then select Send Request in the menu, or press F1 and then select/type Rest Client: Send Request, the response will be previewed in a separate webview panel of Visual Studio Code. If you'd like to use the full power of searching, selecting or manipulating in Visual Studio Code, you can also preview response in an untitled document by setting rest-client.previewResponseInUntitledDocument to true. Once a request is issued, the waiting spin icon will be displayed in the status bar until the response is received. You can click the spin icon to cancel the request. After that, the icon will be replaced with the total duration and response size.

You can view the breakdown of the response time when hovering over the total duration in status bar, you could view the duration details of Socket, DNS, TCP, First Byte and Download.

When hovering over the response size in status bar, you could view the breakdown response size details of headers and body.

All the shortcuts in REST Client Extension are ONLY available for file language mode http and plaintext.

Send Request link above each request will only be visible when the request file is in http mode, more details can be found in http language section.

Select Request Text
You may even want to save numerous requests in the same file and execute any of them as you wish easily. REST Client extension could recognize requests separated by lines begin with three or more consecutive # as a delimiter. Place the cursor anywhere between the delimiters, issuing the request as above, and the underlying request will be sent out.
```
GET https://example.com/comments/1 HTTP/1.1

###

GET https://example.com/topics/1 HTTP/1.1

###

POST https://example.com/comments HTTP/1.1
content-type: application/json

{
    "name": "sample",
    "time": "Wed, 21 Oct 2015 18:27:50 GMT"
}
```