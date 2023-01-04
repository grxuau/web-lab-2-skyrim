$(document).ready(function () {
    //покрыть тестами
    const MAX_INPUT_LENGTH = 12;
    const errorElement = document.getElementById('error')

    const patterns = {
        integerStartingWithZero: new RegExp("^0+\\d+$"),
        numberSystemsPattern: new RegExp("(0x|0o|0b)\d*")
    }

    let point = {
        xCoord: undefined,
        yCoord: undefined,
        rCoord: undefined
    }

    let messages = [];

    function isNumberBelongInterval(leftBorder, rightBorder, number) {
        return (number >= leftBorder && number <= rightBorder)
    }

    function isNumberCorrectLength(number) {
        return number <= MAX_INPUT_LENGTH
    }

    function checkX() {
        const x = document.querySelector('input[name="xCoord"]:checked')
            .value
            .replace(',', '.')
            .trim()

        return isNumberBelongInterval(-5, 3, parseFloat(x))
               && Number.isInteger(parseFloat(x))
               && isNumberCorrectLength(parseFloat(x))
               && !(patterns.numberSystemsPattern.test(x))
               && !(patterns.integerStartingWithZero.test(x))
    }

    function checkY() {
        const y = document.getElementById('yCoord')
            .value
            .replace(',', '.')
            .trim()

        return isNumberBelongInterval(-5, 3, y)
            && Number.isInteger(parseFloat(y))
            && isNumberCorrectLength(parseFloat(y))
            && !(patterns.numberSystemsPattern.test(y))
            && !(patterns.integerStartingWithZero.test(y))
    }
    //fixme probably need to insert parseFloat() here
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
    //TODO make an attractive output
    //TODO redesign function
    function validate() {
        if (!checkX()) {
            messages.push('\'x\' value is incorrect')
            return false
        }
        if (!checkY()) {
            messages.push('\'y\' value is incorrect')
            return false
        }
        if (!checkR()) {
            messages.push('\'r\' value is incorrect')
            return false
        }

        return true
    }


    function getCheckedBoxes() {
        let checkedValues = []
        const checkedBoxes = $('#input-coordinates input[type = "checkbox"]:checked')
              .each(function () {
                  checkedValues.push($(this).val())
              })

        return (checkedValues.length > 0) ? checkedValues : null
    }

    function setCoordinates() {
        point.xCoord = document.querySelector('input[name="xCoord"]:checked')
             .value
             .replace(',', '.')
             .trim()

        point.yCoord =  document.getElementById('yCoord')
             .value
             .replace(',', '.')
             .trim()

        point.rCoord = getCheckedBoxes()
        point.rCoord.forEach(function (rElement) {
            rElement.toString()
                .replace(',', '.')
        })
    }

    function sendGetRequest() {
        $.ajax({
            url: 'controller-servlet',
            method: 'GET',
            data: {
                x: point.xCoord,
                y: point.yCoord,
                r: point.rCoord
            },
            error: function(jqXHR, exception) {
                //TODO add error's description
            }
        })
    }

    let form = document.getElementById('input-coordinates')
    form.addEventListener('submit', (e) => {
        //TODO make text which says how to fill form correctly
        //TODO ask what's the correct message to show with incorrect input
        //TODO make button 'need skooma' as a help button
        //FIXME error messages displays coords, also messages are incorrect
        //FIXME you can spam error messages
        e.preventDefault()

        if (validate()) {
            setCoordinates()
            sendGetRequest()
        } else {
            errorElement.innerText = messages.join('!')
        }
    })
})