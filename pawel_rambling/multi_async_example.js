const doSomeWorkAsync = (input, callback) => setTimeout(() => callback(input + 1), 1000);

const doSomeWorkAsyncWithPromise = input => new Promise(resolve => setTimeout(resolve, 1000)).then(() => input + 1);

// be horrified
doSomeWorkAsync(1, result => {
    doSomeWorkAsync(2, anotherResult => {
        doSomeWorkAsync(3, result3 => {
            doSomeWorkAsync(4, result4 => {
                console.log("results", [result, anotherResult, result3, result4])
            });
        });
    });
});


const promises = [];
for (let i = 0 ; i < 100; i++){
    promises.push(doSomeWorkAsyncWithPromise(i));
}

function bla() {
    console.log('bla')
}

Promise.all(promises).then(values => {console.log(values)}).catch(() => console.log('bla'))