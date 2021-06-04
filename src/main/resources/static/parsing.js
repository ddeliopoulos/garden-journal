const mockResponse = '[ {"name":"bla", "age":15}, {"name":"abc"} ]';
const callServer = (callback) => {
    callback.bind({
        responseText: mockResponse
    })();
};




callServer(function() {
    const responseAsString = this.responseText;
    const responseAsObject = JSON.parse(responseAsString);
    const name = responseAsObject.bla;
    console.log(name);
});