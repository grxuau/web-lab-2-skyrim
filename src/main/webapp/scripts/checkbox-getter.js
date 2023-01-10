//todo вынести все вторичные функции в файл utils.js
export function getCheckedBoxes() {
    $(document).ready(function () {
        let checkedValues = []
        $('#input-coordinates input[type = "checkbox"]:checked')
            .each(function () {
                checkedValues.push($(this).val())
            });
        return (checkedValues.length > 0) ? checkedValues : null
    })
}