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


})