// 1. read a CSV file
// 2. FirstName,LastName,CountryOfOrigin
//    Pawel,Szymanski,Poland
// 3. send a POST request to http://httpbin.org/post for each person in Spain
// 4. when we get a response, we save it to a separate file


const fs = require('fs');
const readline = require('readline');

const fileName = "C:\\Users\\ddeli\\IdeaProjects\\garden-journal\\pawel_rambling\\persons.csv";

// processLineByLine(line => {})
async function processLineByLine(onNextLine) {
    const fileStream = fs.createReadStream(fileName);

    const lines = readline.createInterface({
        input: fileStream,
        crlfDelay: Infinity
    });

    for await (const line of lines) {
        onNextLine(line);
    }
}




function greeting(name){
    console.log("fak ")
}

function practiceCallbacks1(callback){
    name = 'racists';
    callback(name);
}

practiceCallbacks1(greeting);



