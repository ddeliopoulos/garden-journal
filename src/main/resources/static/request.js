// input:
//  * request method
//  * url
//  * request data

// output:
//  * response
//    * status
//    * response data
const sendRequest = input => {
    const httpMethod = input.method;
    const url = input.url;
    const data = input.data;

    const httpRequest = new XMLHttpRequest();
    const promiseResult = new Promise((resolve, reject) => {
        httpRequest.onreadystatechange = function () {
            // when response didn't come yet, move on
            if (this.readyState !== 4) return;

            resolve({
                status: this.status,
                data: this.responseText === '' ? null : JSON.parse(this.responseText)
            });
        };
        httpRequest.onerror = error => reject(error);
    });

    httpRequest.open(httpMethod, `http://localhost:8080/api/v1${url}`, true);
    // tell the server we are sending a JSON
    httpRequest.setRequestHeader('Content-Type', 'application/json');
    // actually send the request
    if (data != null) {
        httpRequest.send(JSON.stringify(data));
    } else {
        httpRequest.send();
    }

    return promiseResult;
}

export {sendRequest};