const MAX_LENGTH = 12;

let pointCoords = {
    xCoord: undefined,
    yCoord: undefined,
    rCoord: undefined,

    isValid: false
};

//FIXME: переименовать регулярки
function check_y() {
    const startsWithZero = new RegExp("^0+\\d+$");
    const numberSystems = new RegExp("(0x|0o|0b)\d*")


    const yElement = document.getElementById('yCoord')
        .value
        .replace(',', '.')
        .trim()


    if (yElement.length > MAX_LENGTH) {
        alert('Input is too long! Max length: ' + MAX_LENGTH)
        pointCoords.isValid = false
    } else if (isNaN(yElement) || isNaN(parseFloat(yElement))) {
        alert('Invalid input!')
        pointCoords.valid = false
    } else if (startsWithZero.test(yElement)){
        alert('Number cannot starts with zero!')
        pointCoords.valid = false;
    } else if (numberSystems.test(yElement)) {
        alert("You can only enter numbers in decimal notation!");
        pointCoords.valid = false;
    } else if (parseFloat(yElement) < -5 || parseFloat(yElement) > 5) {
        alert('Please enter a number between -5 and 5')
        pointCoords.valid = false;
    } else {
        pointCoords.yCoord = yElement
        pointCoords.isValid = true;
    }
}

function check_x() {
    const startsWithZero = new RegExp("^0+\\d+$");
    const numberSystems = new RegExp("(0x|0o|0b)\d*")

    let availableValues = ['-5', '-4', '-3', '-2', '-1', '0', '1', '2', '3']

    const xElement = document.querySelector('input[name="xCoord"]:checked')
        .value
        .replace(',', '.')
        .trim()

    if (xElement.length > MAX_LENGTH) {
        alert('Input is too long! Max length: ' + MAX_LENGTH)
        pointCoords.isValid = false
    } else if (isNaN(xElement) || isNaN(parseFloat(xElement))) {
        alert('Invalid input!')
        pointCoords.valid = false
    } else if (startsWithZero.test(xElement)) {
        alert('There must be no zeros at the beginning of an integer!\n')
        pointCoords.isValid = false
    } else if (numberSystems.test(xElement)) {
        alert('Use decimal, warrior!')
        pointCoords.isValid = false
    }

    availableValues.forEach(function (avalValue) {
        if (xElement === avalValue) {
            pointCoords.isValid = true
        }
    })
}

function check_r() {
    const startsWithZero = new RegExp("^0+\\d+$");
    const numberSystems = new RegExp("(0x|0o|0b)\d*")

    let rValues = ['1', '2', '3', '4', '5']
    const rElement = document.querySelector('input[name="rcoord"]:checked').value
    const r = rElement.replace(',', '.').trim();

    if (r.length > 14) {
        alert('Input is too long! Max length: 14')
        return false
    }



    //FIXME: else if
    if (startsWithZero.test(r)) {
        alert('There must be no zeros at the beginning of an integer!\n')
        return valid
    }

    if (numberSystems.test(r)) {
        alert('Use decimal bro')
        return valid
    }

    rValues.forEach(function (avalValue, index,  xValues) {
        if (r === avalValue) {
            valid = true
            return valid
        }
    })

    if (!valid) {
        alert('I\'m sorry, but R value is incorrect!')
    }
    return valid
}

