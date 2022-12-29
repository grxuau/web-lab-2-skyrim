$(document).ready(function () {
    const MAX_INPUT_LENGTH = 12;

    const patterns = {
        integerStartingWithZero: new RegExp("^0+\\d+$"),
        numberSystemsPattern: new RegExp("(0x|0o|0b)\d*")
    }

    let pointCoords = {
        xCoord: undefined,
        yCoord: undefined,
        rCoord: undefined
    }

    function isNumberBelongInterval(leftBorder, rightBorder, number) {
        return (number <= rightBorder && number >= leftBorder)
    }

    function isNumberCorrectLength(number) {
        return number <= MAX_INPUT_LENGTH
    }

    function checkX() {
        const x = document.querySelector('input[name="xCoord"]:checked')
            .value
            .replace(',', '.')
            .trim()

        return isNumberBelongInterval(-5, 3, x)
               && Number.isInteger(x)
               && isNumberCorrectLength(x)
               && !(patterns.numberSystemsPattern.test(x))
               && !(patterns.integerStartingWithZero.test(x))
    }

    function checkY() {
        const y = document.querySelector('input[name="yCoord"]:checked')
            .value
            .replace(',', '.')
            .trim()

        return isNumberBelongInterval(-5, 3, y)
            && Number.isInteger(y)
            && isNumberCorrectLength(y)
            && !(patterns.numberSystemsPattern.test(y))
            && !(patterns.integerStartingWithZero.test(y))
    }

    function checkR() {
        const avaliableValues = ['1', '1.5', '2', '2.5', '3']
        const r = getCheckedBoxes();

        r.forEach(function (rElement) {
            rElement.toString()
                    .replace(',', '.')
        })

        return r.every(rElement => avaliableValues.includes(rElement)) &&
               r.every(rElement => !patterns.numberSystemsPattern.test(rElement)) &&
               r.every(rElement => !patterns.integerStartingWithZero.test(rElement))
    }

    function getCheckedBoxes() {
        const checkedBoxes = document.querySelectorAll('input[name=rCoord]:checked')
        return (checkedBoxes.length > 0) ? checkedBoxes : null
    }

    function setCoordinates() {
        pointCoords.xCoord = document.querySelector('input[name="xCoord"]:checked')
            .value
            .replace(',', '.')
            .trim()

        pointCoords.yCoord = document.querySelector('input[name="yCoord"]:checked')
            .value
            .replace(',', '.')
            .trim()

        pointCoords.rCoord = getCheckedBoxes()
        pointCoords.rCoord.forEach(function (rElement) {
            rElement.toString()
                .replace(',', '.')
        })
    }

    function sendGetRequest() {
        $.ajax({
            url: 'controller-servlet',
            method: 'GET',
            data: {
                x: pointCoords.xCoord,
                y: pointCoords.yCoord,
                r: pointCoords.rCoord
            },
            error: function(jqXHR, exception) {
                //TODO add error's description
            }
        })
    }

    let form = document.getElementById('input-coordinates')
    form.addEventListener('submit', (e) => {
        e.preventDefault()

        if (checkX() && checkY() && checkR()) {
            setCoordinates()
            sendGetRequest()
        }
    })
})