import {getCheckedBoxes} from './checkbox-getter.js';

$(document).ready(function () {
        const widthPx = document.getElementById('coordinate-plane').style.width;
        const heigthPx = document.getElementById('coordinate-plane').style.height;

        const errorBlock = document.getElementById('error-message')

        //todo can import
        let point = {
            xCoord: undefined,
            yCoord: undefined,
            rCoord: undefined
        }
        document.getElementById('coordinate-plane').addEventListener('click', (e) => {
            if (e.clientX < widthPx / 2 && e.clientY < heigthPx / 2) {
                const x = getX(e.clientX, widthPx)
                const y = getY(e.clientY, heigthPx)
                point.xCoord = x
                point.yCoord = y
                //todo insert r validation
                point.rCoord = getR
            }
        })

        function getX(pixels, widthPx) {
            return -3.5 * (1 - pixels / (width / 2));
        }

        function getY(pixels, heigthPx) {
            return 3.5 * (1 - pixels / (heigthPx / 2));
        }

        function getR() {
            let r = getCheckedBoxes()
            return r.length > 0 ? r : undefined
        }

        function sendGetRequest() {
            if (point.rCoord == undefined) {
                errorBlock.innerText = 'invalid (r) coordinate!'
            } else {
                errorBlock.innerText = ''

                $.ajax({
                    url: 'check-servlet',
                    method: 'GET',
                    data: {
                        x: point.xCoord,
                        y: point.yCoord,
                        r: point.rCoord
                    },
                    error: function() {
                        alert('Отладочное сообщение!')
                    }
                })
            }
        }
})

