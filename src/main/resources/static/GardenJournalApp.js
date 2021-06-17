import {sendRequest} from "./request.js";

const plantNameTextField = document.getElementById('plantNameTextField');
const plantColorTextField = document.getElementById('plantColorTextField');
const plantHeightTextField = document.getElementById('plantHeightTextField');
const plantIdTextField = document.getElementById('plantIdTextField');
const listOfPlants = document.getElementById('listOfPlants'); // a DIV element containing a list of DIV elements with plant information
const errorDiv = document.querySelector('#show-error');


const createListOfPlants = () => {
    sendRequest({
        method: 'GET',
        url: '/plants',
        data: null
    }).then(response => {
        if (response.status !== 200) {
            throw new Error(`status is ${this.status}`);
        }

        const listOfPlantsFromResponse = response.data;
        listOfPlants.innerHTML = '';

        for (let i = 0; i < listOfPlantsFromResponse.length; ++i) {
            const newDiv = document.createElement('div');
            newDiv.className = 'plant-box';
            listOfPlants.appendChild(newDiv);
            newDiv.innerText = `Plant Name: ${listOfPlantsFromResponse[i].nameOfPlant},
                \nDate Planted: ${listOfPlantsFromResponse[i].heightInInches}`;

        }
    });
}

createListOfPlants()

const removeAPlant = () => {
    sendRequest({
        method: 'DELETE',
        url: '/plants/' + plantIdTextField.value,
        data: null
    }).then(response => {
        if (response.status !== 200) {
            throw new Error(`status is ${this.status}`);
        }
        console.log('removed a plant');

        plantIdTextField.value = '';

        createListOfPlants();
    })
}

const onPlantCreate = () => {
    // create plant object
    if (plantNameTextField.value === "") {
        errorDiv.innerText = "Please, name your plant dumbass.";
        errorDiv.style.color = 'red';
        return;
    } else
        errorDiv.innerText = "";

    const plant = {
        "name": plantNameTextField.value,
        "colorRed": 255,
        "colorGreen": 0,
        "colorBlue": 255,
        "heightInInches": plantHeightTextField.value
    };

    // send POST request to the server
    sendRequest({
        method: 'POST',
        url: '/plants/' + plantIdTextField.value,
        data: plant
    }).then(response => {
        if (response.status !== 200) {
            throw new Error(`status is ${this.status}`);
        }

        // if we succeeded, print the new plant's ID
        const plantId = response.data;

        console.log('created a plant', plantId, plant);

        // clear the input fields
        plantNameTextField.value = '';
        plantColorTextField.value = '';
        plantHeightTextField.value = '';

        createListOfPlants();
    });
}

window.onPlantCreate = onPlantCreate;
window.createListOfPlants = createListOfPlants;
window.removeAPlant = removeAPlant;
