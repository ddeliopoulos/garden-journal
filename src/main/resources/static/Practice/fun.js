function sumFunction(firstNumber, secondNumber) {
    return firstNumber + secondNumber
}

// same thing as above
let sum = (firstNumber, secondNumber) => firstNumber + secondNumber;

const subtract = (firstNumber, secondNumber) => firstNumber - secondNumber;

// S - single responsibility
// O - open for extension / closed for modification

const functionalityThatTakesTime = (callback) => {
    setTimeout(() => callback('bla'), 1000);
}

let result = undefined;
functionalityThatTakesTime(functionResult => {
    // console.log(functionResult);
});

const timeoutPromise = timeoutMillis => new Promise((resolve, reject) => {
    try {
        setTimeout(resolve, timeoutMillis);
    } catch (error) {
        reject(error);
    }
});


// promise
timeoutPromise(2000)
    .then(() => "bla")
    .then(number => parseInt(number))
    .then(parsedNumber => timeoutPromise(parsedNumber))
    .catch(error => console.error(error));


const asyncFunction = async bla => {
    const result = await timeoutPromise(2000);
};