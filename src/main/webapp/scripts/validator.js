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

//FIXME: сделать функцию проверок красивой
function check_r() {
    const startsWithZero = new RegExp("^0+\\d+$");
    const numberSystems = new RegExp("(0x|0o|0b)\d*")

    let availableValues = ['1', '1.5', '2', '2.5', '3']
    const rElements = document.querySelector('input[name="rСoord"]:checked').value

    rElements.forEach(function (rElement) {
        rElement.replace(',', '.')
            .trim()
    })
    //FIXME НУ НЕ КАЖДЫЙ ЖЕ РАЗ ВЫВОДИТЬ СООБЩЕНИЕ
    rElements.forEach(function (rElement) {
        if (startsWithZero.test(rElement)) {
            alert('There must be no zeros at the beginning of an integer!\n')
            pointCoords.isValid = false
        } else if (numberSystems.test(rElement)) {
            alert('Use decimal, warrior')
        }
    })
}

    //FIXME: написать проверку соответствия допустимым значениям


form = document.getElementById('input-coordinates')
form.addEventListener('submit', (e) => {
    e.preventDefault()
    //FIXME: дописать код
})
