$(document).ready(function () {
    const MAX_LENGTH = 12;

    let pointCoords = {
        xCoord: undefined,
        yCoord: undefined,
        rCoord: undefined,

        isValid: false
    };

    //GOVNOCODE
    //FIXME удостовериться, что проверки работают так как задуманно
    function validate() {
        check_x()
        if (pointCoords.isValid == false) {
            return
        }
        check_y()
        if (pointCoords.isValid == false) {
            return
        }
        check_r()
        if (pointCoords.isValid == false) {
            return false
        }
    }

//FIXME: переименовать регулярки
//FIXME: сделать код чище
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
            pointCoords.isValid = false
        } else if (startsWithZero.test(yElement)){
            alert('Number cannot starts with zero!')
            pointCoords.isValid = false;
        } else if (numberSystems.test(yElement)) {
            alert("You can only enter numbers in decimal notation!");
            pointCoords.isValid = false;
        } else if (parseFloat(yElement) < -5 || parseFloat(yElement) > 5) {
            alert('Please enter a number between -5 and 5')
            pointCoords.isValid = false;
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
            pointCoords.isValid = false
        } else if (startsWithZero.test(xElement)) {
            alert('There must be no zeros at the beginning of an integer!\n')
            pointCoords.isValid = false
        } else if (numberSystems.test(xElement)) {
            alert('Use decimal, warrior!')
            pointCoords.isValid = false
        }

        availableValues.forEach(function (avalValue) {
            if (xElement === avalValue) {
                pointCoords.xCoord = xElement
                pointCoords.isValid = true
            }
        })
    }

    //FIXME: сделать функцию проверок красивой
    function check_r() {
        const startsWithZero = new RegExp("^0+\\d+$");
        const numberSystems = new RegExp("(0x|0o|0b)\d*")

        let availableValues = ['1', '1.5', '2', '2.5', '3']


        const rElements = get_checked_boxes("rCoord");
        let r = rElements.trim().split(" ")

        r.forEach(function (rElement) {
            rElement.replace(',', '.')
                    .trim()
        })

        r.every(function (rElement) {
            if (startsWithZero.test(rElement)) {
                alert('There must be no zeros at the beginning of an integer!\n')
                pointCoords.isValid = false
                return false
            } else if (numberSystems.test(rElement)) {
                alert('Use decimal, warrior')
                pointCoords.isValid = false
                return false
            } else {
                pointCoords.isValid = true
            }
        })

        //FIXME: переписать проходы под every()

        pointCoords.isValid = r.every(rElement => availableValues.includes(rElement))

        if (pointCoords.isValid) {
            pointCoords.rCoord = r
        }
    }


    function get_checked_boxes(checkboxName) {
        let checkboxes = document.getElementsByName(checkboxName)

        let result = ""

        for (let i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                result += checkboxes[i].value + " "
            }
        }
        // return checkboxesChecked.length > 0 ? checkboxesChecked : null;
        return result
    }


    function sendGetRequest() {
        // alert("send-test")
        $.ajax({
            url: 'controller-servlet',
            method: 'GET',
            data: {
                x: pointCoords.xCoord,
                y: pointCoords.yCoord,
                r: pointCoords.rCoord
            },
            error: function(jqXHR, exception) {
                alert('Запрос не был отправлен!' + jqXHR.status + ' ' + exception)
            }
        })
    }


    //TODO сделать проверки чекбоксов
    let form = document.getElementById('input-coordinates')
    form.addEventListener('submit', (e) => {
        e.preventDefault()
        validate()
        if (pointCoords.isValid) {
            sendGetRequest()
        }
    })
})
