import {sendRequest} from "./Practice/request.js";

const nameOfPlantTextField = document.getElementById("nameOfPlant");
const typeOfPlantTextField = document.getElementById("typeOfPlant");
const dateOfPlantTextField = document.getElementById("datePlanted");
const listOfPlants = document.getElementById('listOfPlants');
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

const onPlantCreate = () => {
    // create plant object
    if (nameOfPlantTextField.value === "") {
        errorDiv.innerText = "Please, name your plant dumbass.";
        errorDiv.style.color = 'red';
        return;
    } else
        errorDiv.innerText = "";

    const plant = {
        "name": nameOfPlantTextField.value,
        "type" : typeOfPlantTextField.value,
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
